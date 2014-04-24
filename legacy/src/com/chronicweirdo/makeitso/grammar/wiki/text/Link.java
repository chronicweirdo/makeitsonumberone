package com.chronicweirdo.makeitso.grammar.wiki.text;

public class Link implements Section {

	private String value;
	
	public Link(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
	public int length() {
		return value.length();
	}
}
