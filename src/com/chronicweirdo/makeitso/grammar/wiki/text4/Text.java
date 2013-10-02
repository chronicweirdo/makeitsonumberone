package com.chronicweirdo.makeitso.grammar.wiki.text4;

public class Text implements Elem {

	private StringBuffer value;
	private String name;
	private int offset;
	
	public Text(String name, String value) {
		this.name = name;
		this.value = new StringBuffer(value);
	}
	
	public String toString() {
		return value.toString();
	}
	
	public void offset(int offset) {
		this.offset = offset;
	}
	
	public int offset() {
		return this.offset;
	}
	
	public int length() {
		return this.value.length();
	}
	
	public int end() {
		return offset() + length();
	}
	
	public String detail(int tab) {
		StringBuilder builder = new StringBuilder();
		for (int t = 0; t < tab; t++) builder.append("\t");
		builder.append(name).append(':').append(value);
		builder.append(":").append(offset()).append(":").append(end());
		return builder.toString();
	}
}
