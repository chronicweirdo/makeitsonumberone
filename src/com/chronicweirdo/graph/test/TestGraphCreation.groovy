package com.chronicweirdo.graph.test

import java.nio.file.Path
import java.nio.file.Paths

import com.chronicweirdo.graph.Graph
import com.chronicweirdo.graph.element.Link
import com.chronicweirdo.graph.element.Node
import com.chronicweirdo.makeitso.path.PathProcessor

class TestGraphCreation {

	static main(args) {
		// folder we are scanning
		Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki");
		
		// scan folder for tags
		PathProcessor pathProcessor = new PathProcessor(root);
		LinePairProcessor pairProcessor = new LinePairProcessor();
		pathProcessor.addFileProcessor(pairProcessor);
		pathProcessor.run();
		
		// save results to graph
		Graph graph = new Graph();
		pathProcessor.results.each { path, result ->
			def pathList = []
			path.each {
				pathList.add(it.toString())
			}
			Node fileNode = new Node(value: ["type": "file", "path": pathList])
			result.each { subresult ->
				subresult.each {
					Node lineNode = new Node(value: ["type": "line", "path": pathList, "line": it.line])
					graph.links.add(new Link(value: ["type": "line"], from: fileNode, to: lineNode));
					Node tagNode = new Node(value: ["type": "tag", "tag": it.tag]);
					graph.links.add(new Link(value: ["type": "tag"], from: lineNode, to: tagNode));
				}
			}
		}
		graph.links.each {
			println it.toString()
		}
	}

}
