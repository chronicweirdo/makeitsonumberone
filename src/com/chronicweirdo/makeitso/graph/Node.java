package com.chronicweirdo.makeitso.graph;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Node implements Serializable {

	private static final long serialVersionUID = 1666438291981055759L;
	
	private String id;
	private Map attributes;
	
	public Node() {
		this(UUID.randomUUID().toString());
	}
	
	public Node(String id) {
		this.id = id;
		this.attributes = new HashMap();
	}
	
	public Node(String id, Map attributes) {
		this.attributes = attributes;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Map getAttributes() {
		return attributes;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", attributes=" + attributes.toString() + "]";
	}
	
}
