package com.chronicweirdo.makeitso.grammar.wiki.text5;

import java.util.ArrayList;
import java.util.List;

public class TG {

	public List<TT> tokens = new ArrayList<TT>();
	// tokens whose change will collapse the whole group
	public List<TT> sensitiveTokens = new ArrayList<TT>();
	
	public TG() {
		
	}
	
	public void add(TT token, boolean sensitive) {
		this.tokens.add(token);
		if (sensitive) {
			this.sensitiveTokens.add(token);
		}
	}
	
	public void add(TT from, TT to, boolean sensitive) {
		TT x = from;
		while (x != to) {
			add(x, sensitive);
			x = x.next();
		}
		add(x, sensitive);
	}
	
	public void print() {
		System.out.println("tokens");
		for (TT t: tokens) {
			System.out.println(t.toString());
		}
		System.out.println("important tokens");
		for (TT t: sensitiveTokens) {
			System.out.println(t.toString());
		}
	}
}
