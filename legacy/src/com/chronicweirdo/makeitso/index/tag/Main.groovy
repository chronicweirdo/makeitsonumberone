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
	
	static Graph load(Path root, Path dbPath) {
		// try to load the graph
		Graph graph = null;
		Path fullDBPath = root.resolve(dbPath);
		GraphDB db = new GraphBinaryDB();
		if (fullDBPath.toFile().exists()) {
			graph = db.load(fullDBPath);
		}
		// initialize an empty graph
		if (graph == null) graph = new Graph();
		return graph;
	}
	
	static void update(Path root, Graph graph) {
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
		
		// mark graph as updated
		graph.updated = now;
		
		long duration = end - start;
		println "update in $duration millis"
	}
	
	static void save(Path root, Path dbPath, Graph graph) {
		// save graph
		Path fullDBPath = root.resolve(dbPath);
		GraphDB db = new GraphBinaryDB();
		db.save(fullDBPath, graph);
	}
	
	static void search(Graph graph) {
		// test search
		long start = System.currentTimeMillis();
		def result = graph.findNodesLike(["tag","tech","linux"]);
		long end = System.currentTimeMillis();
		long duration = end - start;
		println "found in $duration millis"
		result.each {
			println it.toString()
		}
		// test: search for some tags and obtain positions
		// test: display all tags in a file
	}
	
	static void buildIndex() {
		// setup root path
		Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki");
		Path dbPath = Paths.get(".graph.exo");
		
		Graph graph = load(root, dbPath);
		update(root, graph);
		save(root, dbPath, graph);
		
		search(graph);
	}
	
	static test_PositionConversion() {
		Path path = Paths.get("test", "path", "here");
		println path.toString()
		path.iterator().each {
			println it;
		}
		
		Position pos = new Position(path: path, line: 3);
		println pos
		PositionConverter conv = new PositionConverter();
		Node node = conv.convertToNode(pos);
		println node
		println conv.convertFromNode(node)
	}
	
	static main(args) {
		buildIndex();
	}

}
