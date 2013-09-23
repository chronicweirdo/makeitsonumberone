package com.chronicweirdo.makeitso.graph;

import java.util.Map;

import com.chronicweirdo.makeitso.PrettyPrintUtils;


public class Node extends GREL {

	private static final long serialVersionUID = 1859450805521995884L;

	public Node() {
		super();
	}
	
	public Node(Map attributes) {
		super(attributes);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("node:");
		PrettyPrintUtils.print(builder, "attributes", attributes);
		return builder.toString();
	}
}
