package com.chronicweirdo.makeitso.graph.old20131016;

import java.util.Map;

import com.chronicweirdo.makeitso.PrettyPrintUtils;

public class Link extends GREL {

	private static final long serialVersionUID = 4736737922374383216L;
	
	public static final String K_CLASS = "class";
	public static final String V_UNIDIRECTIONAL = "unidirectional";
	public static final String V_BIDIRECTIONAL = "bidirectional";
	public static final String K_TYPE = "type";
	public static final String V_PARENT = "parent";
	
	private Node a;
	private Node b;
	
	public Link(Node a, Node b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public Node a() {
		return a;
	}
	
	public Node b() {
		return b;
	}
	
	public Link(Node a, Node b, Map attributes) {
		super(attributes);
		this.a = a;
		this.b = b;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("link:");
		PrettyPrintUtils.print(builder, "a", a);
		builder.append(", ");
		PrettyPrintUtils.print(builder, "b", b);
		builder.append(", ");
		PrettyPrintUtils.print(builder, "attributes", attributes);
		return builder.toString();
	}
}
