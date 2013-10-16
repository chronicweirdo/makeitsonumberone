package com.chronicweirdo.makeitso.path

import java.nio.file.Path
import java.nio.file.Paths

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

class PathProcessor {
	
	Path root;
	
	PathProcessor(Path root) {
		this.root = root;
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
	
	void run() {
		processPath(Paths.get(""));
	}
	
	private void processPath(Path current) {
		File file = fullPath(current).toFile();
		if (file.isDirectory()) {
			processFolder(current);
			file.list().each{
				processPath(newPath(current, it));
			}
		} else {
			processFile(current);
		}
	}
	
	static main(args) {
		Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki");
		
		TestProcessor testProcessor = new TestProcessor();
		PathProcessor pathProcessor = new PathProcessor(root);
		pathProcessor.addFileProcessor(testProcessor);
		pathProcessor.addFolderProcessor(testProcessor);
		
		pathProcessor.run();
		
		println pathProcessor.results
		pathProcessor.results.each { path, result ->
			println "$path: $result";
		}
	}

}
