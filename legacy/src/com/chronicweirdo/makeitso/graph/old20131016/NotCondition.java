package com.chronicweirdo.makeitso.graph.old20131016;

public class NotCondition implements Condition {

	private Condition condition;
	
	public NotCondition(Condition condition) {
		this.condition = condition;
	}
	
	@Override
	public boolean evaluate(GREL object) {
		return !condition.evaluate(object);
	}

}
