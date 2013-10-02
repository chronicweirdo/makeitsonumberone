package com.chronicweirdo.makeitso.grammar.wiki.text4;

public interface Elem {

	String toString();
	String detail(int tab);
	int length();
	int offset();
	void offset(int offset);
	int end();
}
