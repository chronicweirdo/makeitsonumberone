package com.chronicweirdo.makeitso.graph;

import java.util.ArrayList;
import java.util.List;

import com.chronicweirdo.makeitso.ConsoleUtils;

public class Database {

	public static final String K_ID = "id";
	
	private List<Node> nodes = new ArrayList<Node>();
	private List<Link> links = new ArrayList<Link>();
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public Node findNode(Object key, Object value) {
		for (Node node: nodes) {
			if (value.equals(node.get(key.toString()))) {
				return node;
			}
		}
		return null;
	}
	
	public void addLink(Link link) {
		links.add(link);
	}
	
	public void print() {
		for (Node node: nodes) {
			System.out.println(node.toString());
		}
		System.out.println();
		for (Link link: links) {
			System.out.println(link.toString());
		}
	}
	
}
