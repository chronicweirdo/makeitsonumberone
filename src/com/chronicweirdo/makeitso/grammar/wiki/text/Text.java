package com.chronicweirdo.makeitso.grammar.wiki.text;

public class Text implements Section {

	private String value;
	
	public Text(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
}