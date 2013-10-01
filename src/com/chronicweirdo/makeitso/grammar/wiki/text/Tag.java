package com.chronicweirdo.makeitso.grammar.wiki.text;

public class Tag implements Section {
	
	private String name;
	private String value;
	
	public Tag(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("#").append(name);
		if (value != null) {
			builder.append(":").append(value);
		}
		return builder.toString();
	}
}
