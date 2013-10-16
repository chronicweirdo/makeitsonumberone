package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Path
import java.nio.file.Paths

import com.chronicweirdo.makeitso.path.PathProcessor

class Main {

	Path root;
	//Map<Path,Date> when = new HashMap();
	
	
	
	static void buildIndex() {
		// setup root path
		Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki");
		// scan all files and get tag-position pairs
		PairProcessor pairProcessor = new PairProcessor();
		PathProcessor pathProcessor = new PathProcessor(root);
		//pathProcessor.after = today.time;
		pathProcessor.addFileProcessor(pairProcessor);
		
		pathProcessor.run();
		
		println "ALL RESULTS"
		pathProcessor.results.each { path, result ->
			println "$path: $result";
		}
		// convert tag-position pairs to nodes and links and add them to index
		// test: search for some tags and obtain positions
		// test: display all tags in a file
	}
	static main(args) {
		buildIndex();
		
	}

}
