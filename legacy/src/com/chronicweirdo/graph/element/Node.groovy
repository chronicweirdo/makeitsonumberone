package com.chronicweirdo.graph.element

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Node {

	Map value = [:]
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	static main(args) {
		Node a = new Node(value: ["name": ["tag", "tech", "jena"], "id": 13])
		Node b = new Node(value: ["name": ["tag", "tech", "jena"], "id": 13])
		Node c = new Node(value: ["name": ["tag", "tech", "jena"], "id": 14])
		Node d = new Node(value: ["name": ["tag", "tech", "lucene"], "id": 13])
		
		println a == b
		println a == c
		println a == d
	}

}
