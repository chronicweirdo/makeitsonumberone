package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Path
import java.nio.file.Paths

import com.chronicweirdo.makeitso.graph.Graph
import com.chronicweirdo.makeitso.graph.Link
import com.chronicweirdo.makeitso.graph.Node
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
		TagConverter tagConverter = new TagConverter();
		PositionConverter positionConverter = new PositionConverter();
		Graph index = new Graph();
		pathProcessor.results.each { path, result ->
			result.each { rr ->
				rr.each {
					Node position = positionConverter.convertToNode(it.position);
					Node tag = tagConverter.convertToNode(it.tag); 
					index.add(new Link(position, tag));
				}
			}
		}
		println index.toString()
		println index.findNodesLike(["tag","tech"]);
		// test: search for some tags and obtain positions
		// test: display all tags in a file
	}
	
	static main(args) {
		buildIndex();
		
	}

}
