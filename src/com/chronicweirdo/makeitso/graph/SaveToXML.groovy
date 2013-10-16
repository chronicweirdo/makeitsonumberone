package com.chronicweirdo.makeitso.graph

import com.sun.org.apache.xerces.internal.util.XML11Char;

import groovy.xml.MarkupBuilder

class SaveToXML {

	
	static main(args) {
		
		Graph g = new Graph();
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

		def writer = new StringWriter()
		def xml = new MarkupBuilder(writer)
		
		xml.graph() {
			links() {
				g.links.each { xLink ->
					link() {
						from() {
							xLink.from.value.each { xValue ->
								value(type:"string",xValue)
							}
						}
						to() {
							xLink.to.value.each { xValue ->
								value(type:"string",xValue)
							}
						}
					}
				}
			}
		}
		
		println writer.toString();
	}
}
