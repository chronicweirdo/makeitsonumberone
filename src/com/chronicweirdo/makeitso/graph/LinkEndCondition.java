package com.chronicweirdo.makeitso.graph;

public class LinkEndCondition implements Condition {
	
	private Condition condition;
	
	public LinkEndCondition(Condition condition) {
		super();
		this.condition = condition;
	}

	@Override
	public boolean evaluate(GREL object) {
		if (object instanceof Link) {
			Link link = (Link) object;
			if (condition.evaluate(link.a())) return true;
			if (condition.evaluate(link.b())) return true;
		}
		return false;
	}

}
