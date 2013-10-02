package com.chronicweirdo.makeitso.grammar.wiki.text2;

import java.util.Arrays;
import java.util.List;

public class Telement {

	public static enum Type {
		TEXT, GROUP
	}
	
	private Telement previous;
	private Telement next;
	private Telement firstChild;
	private Telement parent;
	
	private StringBuffer value;
	private Type type;
	private String name;
	
	public Telement(String string) {
		this.type = Type.TEXT;
		this.value = new StringBuffer(string);
	}
	public Telement(Type type, String name, String string) {
		this.type = type;
		this.name = name;
		this.value = new StringBuffer(string);
	}
	public Telement(String name, String ...strings) {
		this.type = Type.GROUP;
		this.name = name;
		Telement current = null;
		for (String string: strings) {
			Telement child = new Telement(string);
			if (current  == null) {
				this.firstChild = child;
			} else {
				current.next = child;
				child.previous = current;
			}
			current = child;
		}
	}
	
	public Telement(String name, List<Telement> children) {
		this.type = Type.GROUP;
		this.name = name;
		Telement current = null;
		for (Telement child: children) {
			if (current  == null) {
				this.firstChild = child;
			} else {
				current.next = child;
				child.previous = current;
			}
			current = child;
		}
	}
	
	private String tabs(int tab) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < tab; i++) {
			b.append("\t");
		}
		return b.toString();
	}
	
	public void print(StringBuilder builder) { 
		print(builder, 0);
	}
	
	private void print(StringBuilder builder, int tab) {
		String tabs = tabs(tab);
		Telement current = this;
		while (current != null) {
			builder.append(tabs).append("T: ").append(current.type)
				.append(", N: ").append(current.name)
				.append(", V: ").append(current.value)
				.append("\n");
			if (current.firstChild != null) {
				current.firstChild.print(builder, tab+1);
			}
			current = current.next;
		}
	}
}
