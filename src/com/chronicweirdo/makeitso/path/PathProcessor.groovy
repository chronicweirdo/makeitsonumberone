package com.chronicweirdo.makeitso.path

import java.nio.file.Path
import java.nio.file.Paths

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

class PathProcessor {
	
	Date after;
	Path root;
	boolean processRoot = true;
	
	PathProcessor(Path root) {
		this.root = root;
	}
	
	PathProcessor(Path root, Date after, boolean processRoot) {
		this.root = root;
		this.after = after;
		this.processRoot = processRoot;
	}
	
	Set<FolderProcessor> folderProcessors = new HashSet();
	Set<FileProcessor> fileProcessors = new HashSet();
	
	void addFolderProcessor(FolderProcessor processor) {
		folderProcessors.add(processor);
	}
	
	void addFileProcessor(FileProcessor processor) {
		fileProcessors.add(processor);
	}
	
	Map<FolderProcessor, Map<Path, Object>> folderResults = [:];
	Map<FileProcessor, Map<Path, Object>> fileResults = [:];
	Map<Path,List> results = [:];

	Path fullPath(Path relative) {
		if (relative) {
			return root.resolve(relative);
		} else {
			return root;
		}
	}
	
	Path newPath(Path relative, String child) {
		if (relative) {
			return Paths.get(relative.toString(), child);
		} else {
			return Paths.get(child);
		}
	}
	
	private void addFolderResult(FolderProcessor processor, Path current, Object result) {
		// add to folder results
		if (folderResults[processor] == null) folderResults[processor] = [:]
		folderResults[processor][current] = result;
		// add to total results
		if (results[current] == null) results[current] = []
		results[current].add(result);
	}
	private void processFolder(Path current) {
		folderProcessors.each {
			Object r = it.processFolder(root, current);
			if (r) addFolderResult(it, current, r);
		}
	}
	private void addFileResult(FileProcessor processor, Path current, Object result) {
		// add to folder results
		if (fileResults[processor] == null) fileResults[processor] = [:]
		fileResults[processor][current] = result;
		// add to total results
		if (results[current] == null) results[current] = []
		results[current].add(result);
	}
	private void processFile(Path current) {
		fileProcessors.each {
			Object r = it.processFile(root, current);
			if (r) addFileResult(it, current, r);
		}
	}
	
	boolean isRoot(Path current) {
		return current.toString().length() == 0;
	}
	long lastModified(Path current) {
		return root.resolve(current).toFile().lastModified();
	}
	boolean shouldProcess(Path current) {
		if (processRoot == false && isRoot(current)) return false;
		if (after != null && after.time > lastModified(current)) return false;
		return true;
	}
	
	void run() {
		processPath(Paths.get(""));
	}
	
	private void processPath(Path current) {
		File file = fullPath(current).toFile();
		if (file.isDirectory()) {
			if (shouldProcess(current)) processFolder(current);
			file.list().each{
				processPath(newPath(current, it));
			}
		} else {
			if (shouldProcess(current)) processFile(current);
		}
	}
	
	static main(args) {
		Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki");
		
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0)
		
		TestProcessor testProcessor = new TestProcessor();
		PathProcessor pathProcessor = new PathProcessor(root);
		pathProcessor.processRoot = false;
		pathProcessor.after = today.time;
		println today.time
		pathProcessor.addFileProcessor(testProcessor);
		pathProcessor.addFolderProcessor(testProcessor);
		
		pathProcessor.run();
		
		println "ALL RESULTS"
		println pathProcessor.results
		pathProcessor.results.each { path, result ->
			println "$path: $result";
		}
		println "FOLDER RESULTS"
		pathProcessor.folderResults.each { processor, value ->
			value.each { path, result ->
				println "$path: $result";
			}
		}
		println "FILE RESULTS"
		pathProcessor.fileResults.each { processor, value ->
			value.each { path, result ->
				println "$path: $result";
			}
		}
	}

}
