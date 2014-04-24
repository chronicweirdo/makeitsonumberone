package com.chronicweirdo.makeitso.grammar.wiki.text;

public class Text implements Section {

	private StringBuffer value;
	
	public Text(String value) {
		this.value = new StringBuffer(value);
	}
	
	public String toString() {
		return this.value.toString();
	}
	
	public int length() {
		return value.length();
	}
	
	public void insert(int offset, String string) {
		value.insert(offset, string);
	}
}
