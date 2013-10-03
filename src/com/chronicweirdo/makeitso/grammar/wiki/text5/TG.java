package com.chronicweirdo.makeitso.grammar.wiki.text5;

import java.util.ArrayList;
import java.util.List;

public class TG {

	public List<TT> tokens = new ArrayList<TT>();
	
	public TG() {
	}
	
	public void add(TT token) {
		this.tokens.add(token);
	}
	
	public TT first() {
		TT f = null;
		for (TT t: tokens) {
			if (f == null || t.before(f)) {
				f = t;
			}
		}
		return f;
	}
	
	public TT last() {
		TT l = null;
		for (TT t: tokens) {
			if (l == null || l.before(t)) {
				l = t;
			}
		}
		return l;
	}
	
	public void print() {
		System.out.println("important");
		for (TT t: tokens) {
			System.out.println(t.toString());
		}
		System.out.println("all");
		TT x = first();
		while (x != last()) {
			System.out.println(x.toString());
			x = x.next();
		}
		System.out.println(x.toString());
	}
}
