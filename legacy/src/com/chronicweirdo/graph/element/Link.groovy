package com.chronicweirdo.graph.element

import groovy.transform.EqualsAndHashCode;

@EqualsAndHashCode
class Link {

	Map value = [:]
	Node from;
	Node to;
	
	@Override
	public String toString() {
		return "(" + from.toString() + " :: " + value.toString() + " :: " + to.toString() + ")"
	}
	
	static main(args) {
		Node ta = new Node(value: ["name": ["tag", "tech", "jena"], "id": 13])
		Node taa = new Node(value: ["name": ["tag", "tech", "jena"], "id": 13])
		Node tb = new Node(value: ["name": ["tag", "tech", "lucene"], "id": 13])
		Node fa = new Node(value: ["name": ["file", "home", "jena.txt"]])
		Node fb = new Node(value: ["name": ["file", "home", "apache.txt"]])
		
		Link la = new Link(value: ["type": "tag"], from: fa, to: ta);
		Link lb = new Link(value: ["type": "tag"], from: fa, to: ta);
		Link lc = new Link(value: ["type": "tag"], from: fa, to: taa);
		Link ld = new Link(value: ["type": "tag"], from: fb, to: ta);
		
		println la == lb
		println la == lc
		println la == ld
	}

}
