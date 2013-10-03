package com.chronicweirdo.makeitso.grammar.wiki.text5;

import java.util.ArrayList;
import java.util.List;

public class TGroup {

	public List<TToken> tokens = new ArrayList<TToken>();
	// tokens whose change will collapse the whole group
	public List<TToken> sensitiveTokens = new ArrayList<TToken>();
	
	protected TGroup() {
		
	}
	
	public void add(TToken token, boolean sensitive) {
		this.tokens.add(token);
		if (sensitive) {
			this.sensitiveTokens.add(token);
		}
	}
	
}
