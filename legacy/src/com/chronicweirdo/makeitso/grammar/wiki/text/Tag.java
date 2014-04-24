package com.chronicweirdo.makeitso.grammar.wiki.text;

public class Tag implements Section {
	
	private static final String START = "#";
	private static final String SEPARATOR = ":";
	
	private StringBuffer start;
	private StringBuffer name;
	private StringBuffer separator;
	private StringBuffer value;
	
	public Tag(String name, String value) {
		this.start = new StringBuffer(START);
		this.name = new StringBuffer(name);
		if (value != null) {
			this.separator = new StringBuffer(SEPARATOR);
			this.value = new StringBuffer(value);
		}
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(start).append(name);
		if (value != null) {
			builder.append(separator).append(value);
		}
		return builder.toString();
	}
	
	public int length() {
		return toString().length();
	}
	
	public void insert(int offset, String string) {
		if (offset < start.length()) {
			// insert into the start section
			start.insert(offset, string);
		} else if (offset - start.length() < name.length()) {
			// insert into the name section
			name.insert(offset - start.length(), string);
		} else if (offset - start.length() - name.length() < separator.length()) {
			// insert into the separators section
			separator.insert(offset, b)
		}
	}
}
