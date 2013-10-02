package com.chronicweirdo.makeitso.grammar.wiki.text4;

import java.util.ArrayList;
import java.util.List;

public class Block implements Elem {

	private List<Elem> els = new ArrayList<Elem>();
	private int offset;
	private String name;
	
	public Block(String name) {
		this.name = name;
	}
	
	public void add(Elem el) {
		this.els.add(el);
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (Elem el: els) {
			b.append(el.toString());
		}
		return b.toString();
	}
	
	public void offset(int offset) {
		this.offset = offset;
		int to = offset;
		for (Elem el: els) {
			el.offset(to);
			to += el.length();
		}
	}
	
	public int end() {
		return offset() + length();
	}
	
	public int offset() {
		return this.offset;
	}
	
	public int length() {
		int length = 0;
		for (Elem el: els) {
			length += el.length();
		}
		return length;
	}
	
	public String detail(int tab) {
		StringBuilder builder = new StringBuilder();
		for (int t = 0; t < tab; t++) builder.append("\t");
		builder.append(name);
		builder.append(":").append(offset()).append(":").append(end()).append('\n');
		for (Elem el: els) {
			builder.append(el.detail(tab+1)).append('\n');
		}
		return builder.toString();
	}
}
