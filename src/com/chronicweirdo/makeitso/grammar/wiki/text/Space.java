package com.chronicweirdo.makeitso.grammar.wiki.text;

public class Space implements Section {

	private String value;
	
	public Space(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
	
	public int length() {
		return value.length();
	}
}
