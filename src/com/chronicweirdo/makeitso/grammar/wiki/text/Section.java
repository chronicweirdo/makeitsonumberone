package com.chronicweirdo.makeitso.grammar.wiki.text;

public interface Section {

	String toString();
	int length();
	void insert(int offset, String string);
}
