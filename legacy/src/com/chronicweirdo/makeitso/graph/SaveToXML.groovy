package com.chronicweirdo.makeitso.graph

import groovy.xml.MarkupBuilder

import java.nio.file.Path
import java.nio.file.Paths

class SaveToXML {

	static void graphToXml(Graph xGraph, Path path) {
		def writer = new FileWriter(path.toFile());
		def xml = new MarkupBuilder(writer)
		
		println xGraph.toString()
		
		xml.graph() {
			/*graph.properties.each { xPropertyName, sPropertyValue ->
				property(name: xPropertyName, sPropertyValue)
			}*/
			links() {
				xGraph.links.each { xLink ->
					link() {
						from() {
							xLink.from.value.each { xValue ->
								value(xValue)
							}
						}
						to() {
							xLink.to.value.each { xValue ->
								value(xValue)
							}
						}
					}
				}
			}
		}
		println xGraph
		writer.close();
	}
	
	static Graph xmlToGraph(Path path) {
		def grp = new XmlSlurper().parse(path.toFile())
		Graph gg = new Graph();
		//println grp.links.link.size()
		grp.property.each { grpProperty ->
			gg.properties[grpProperty.name] = grpProperty
		}
		grp.links.link.each { grpLink ->
			Link link = new Link();
			link.from = new Node();
			grpLink.from.value.each { grpValue ->
				link.from.value.add(grpValue)
			}
			link.to = new Node();
			grpLink.to.value.each { grpValue ->
				link.to.value.add(grpValue)
			}
			gg.add(link);
		}
		return gg;
	}
	
	static main(args) {
		
		Graph g = new Graph();
		//g.updated = "yesterday";
		g.add(new Link(new Node("tag","tech"), new Node("file","file1","1")));
		g.add(new Link(new Node("tag","tech","apache"), new Node("file","file1","1")));
		g.add(new Link(new Node("tag","overview"), new Node("file","file1","2")));
		g.add(new Link(new Node("tag","date","2013.10.14"), new Node("file","file1","3")));
		g.add(new Link(new Node("link","http://jgrapht.org/"), new Node("file","file1","8")));
		g.add(new Link(new Node("tag","tech","lucene"), new Node("file","file2","1")));
		g.add(new Link(new Node("tag","overview"), new Node("file","file2","1")));
		g.add(new Link(new Node("disk","pretty_image.png"), new Node("file","file2","3")));
		g.add(new Link(new Node("tag","apache"), new Node("file","file2","1")));
		g.add(new Link(new Node("tag","index"), new Node("file","file2","1")));
		g.add(new Link(new Node("tag","code"), new Node("file","file2","2")));
		g.add(new Link(new Node("tag","todo","tech"), new Node("file","file3","1")));
		g.add(new Link(new Node("tag","tech","lucene"), new Node("file","file3","2")));
		g.add(new Link(new Node("tag","tech","solr"), new Node("file","file3","3")));
		
		println g.toString()

		Path path = Paths.get("testGraphXML.xml");
		graphToXml(g, path);
		//println xml
		
		//Graph gg = readGraph(path);
		
		//println gg.toString()
	}
}
