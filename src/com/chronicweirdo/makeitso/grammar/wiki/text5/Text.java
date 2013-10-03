package com.chronicweirdo.makeitso.grammar.wiki.text5;

import java.util.ArrayList;
import java.util.List;

public class Text {

	private List<TToken> tokens;
	private List<TGroup> groups;
	
	public Text() {
		tokens = new ArrayList<TToken>();
		groups = new ArrayList<TGroup>();
	}
	
	// add a token
	public TToken add(String text) {
		TToken t = new TToken(text);
		tokens.add(t);
		return t;
	}
	
	// add new token to group
	public TToken add(String text, TGroup group, boolean sensitive) {
		TToken t = new TToken(text);
		tokens.add(t);
		group.add(t, sensitive);
		return t;
	}
	
	// add a group
	public TGroup group() {
		TGroup g = new TGroup();
		groups.add(g);
		return g;
	}
}
