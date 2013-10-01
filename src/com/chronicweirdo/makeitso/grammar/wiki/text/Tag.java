package com.chronicweirdo.makeitso.grammar.wiki.text;

public class Tag {
	
	private String name;
	private String value;
	
	public Tag(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String toString() {
		return "#" + name + ":" + value;
	}
}
