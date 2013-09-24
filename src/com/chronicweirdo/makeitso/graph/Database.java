package com.chronicweirdo.makeitso.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {

	private static final long serialVersionUID = 3913843436109484902L;

	public static final String K_ID = "id";
	
	private String path;
	private String id;
	private List<Node> nodes = new ArrayList<Node>();
	private List<Link> links = new ArrayList<Link>();
	
	public Database(String id, String path) {
		this.id = id;
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public Object updateNode(Node node) {
		Node existing = findNode(K_ID, node.get(K_ID));
		if (existing == null) {
			addNode(node);
		} else {
			for (Object key: node.keys()) {
				existing.set(key.toString(), node.get(key.toString()));
			}
		}
		return node.get(K_ID);
	}
	
	public Node findNode(Object key, Object value) {
		for (Node node: nodes) {
			if (value.equals(node.get(key.toString()))) {
				return node;
			}
		}
		return null;
	}
	
	public Link findLink()
	
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
