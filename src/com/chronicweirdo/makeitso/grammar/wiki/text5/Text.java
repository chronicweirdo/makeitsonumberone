package com.chronicweirdo.makeitso.grammar.wiki.text5;

import java.util.ArrayList;
import java.util.List;

public class Text {

	private TT first;
	private TT last;
	private List<TG> groups;
	
	public TT first() {
		return first;
	}
	
	public TT last() {
		return last;
	}
	
	public Text() {
		groups = new ArrayList<TG>();
	}
	
	public Text(String token) {
		groups = new ArrayList<TG>();
		first = new TT(token);
		last = first;
	}
	
	// add a token
	public TT add(String text) {
		TT t = new TT(text);
		if (first == null) {
			first = t;
			last = t;
		} else {
			last.append(t);
			last = t;
		}
		return t;
	}
	
	// add new token to group
	public TT add(String text, TG group) {
		TT t = add(text);
		group.add(t);
		return t;
	}
	
	// add a group
	public TG group() {
		TG g = new TG();
		groups.add(g);
		return g;
	}
	
	public Text append(Text t) {
		if (first == null) {
			first = t.first;
			last = t.last;
		} else {
			last.append(t.first);
			last = t.last;
		}
		groups.addAll(t.groups);
		return this;
	}
	
	public void print() {
		first.print();
		System.out.println("groups: " + groups.size());
		for (TG g: groups) {
			g.print();
			System.out.println();
		}
	}
}
