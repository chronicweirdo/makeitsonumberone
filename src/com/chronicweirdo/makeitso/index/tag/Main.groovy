package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Path
import java.nio.file.Paths

import com.chronicweirdo.makeitso.graph.Graph
import com.chronicweirdo.makeitso.graph.GraphBinaryDB
import com.chronicweirdo.makeitso.graph.GraphDB
import com.chronicweirdo.makeitso.graph.Link
import com.chronicweirdo.makeitso.graph.Node
import com.chronicweirdo.makeitso.path.PathProcessor

class Main {

	Path root;
	//Map<Path,Date> when = new HashMap();
	
	
	
	static void buildIndex() {
		// setup root path
		Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki");
		Path dbPath = Paths.get(".graph.exo");
		
		// try to load the graph
		Graph graph = null;
		Path fullDBPath = root.resolve(dbPath);
		GraphDB db = new GraphBinaryDB();
		if (fullDBPath.toFile().exists()) {
			graph = db.load(fullDBPath);
		}
		if (graph == null) graph = new Graph();
		
		long start = System.currentTimeMillis();
		// scan all files and get tag-position pairs
		Date now = new Date();
		PairProcessor pairProcessor = new PairProcessor();
		//PairProcessor fileLogProcessor = new FileLogProcessor();
		PathProcessor pathProcessor = new PathProcessor(root);
		pathProcessor.after = graph.updated; // can be null
		pathProcessor.addFileProcessor(pairProcessor);
		//pathProcessor.addFileProcessor(fileLogProcessor);
		pathProcessor.run();
		
		/*println "ALL RESULTS"
		pathProcessor.results.each { path, result ->
			println "$path: $result";
		}*/
		
		// convert tag-position pairs to nodes and links and add them to index
		TagConverter tagConverter = new TagConverter();
		PositionConverter positionConverter = new PositionConverter();
		println "found " + pathProcessor.results.size() + " changed files";
		pathProcessor.results.each { path, result ->
			// remove all existing info about path
			graph.findNodesLike(["position", path.toString()]).each {
				graph.delete(it);
			}
			// add new info
			result.each { rr ->
				rr.each {
					Node position = positionConverter.convertToNode(it.position);
					Node tag = tagConverter.convertToNode(it.tag); 
					graph.add(new Link(position, tag));
				}
			}
		}
		long end = System.currentTimeMillis();
		println graph.toString()
		
		long duration = end - start;
		println "update in $duration millis"
		
		// save graph
		graph.updated = now;
		db.save(fullDBPath, graph);
		
		// test search
		start = System.currentTimeMillis();
		def result = graph.findNodesLike(["tag","tech","linux"]);
		end = System.currentTimeMillis();
		duration = end - start;
		println "found in $duration millis"
		result.each {
			println it.toString()
		}
		// test: search for some tags and obtain positions
		// test: display all tags in a file
	}
	
	static main(args) {
		buildIndex();
		
	}

}
