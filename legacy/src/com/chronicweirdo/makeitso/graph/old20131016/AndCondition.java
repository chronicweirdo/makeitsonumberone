package com.chronicweirdo.makeitso.graph.old20131016;

import java.util.ArrayList;
import java.util.List;

public class AndCondition implements Condition {

	private List<Condition> conditions;
	
	public AndCondition(Condition ... conditions) {
		this.conditions = new ArrayList<Condition>();
		for (Condition condition: conditions) {
			this.conditions.add(condition);
		}
	}
	
	public AndCondition() {
		this.conditions = new ArrayList<Condition>();
	}
	
	public AndCondition add(Condition condition) {
		this.conditions.add(condition);
		return this;
	}
	
	public AndCondition and(Condition condition) {
		return this.add(condition);
	}
	
	@Override
	public boolean evaluate(GREL object) {
		for (Condition condition: conditions) {
			if (condition.evaluate(object) == false) {
				return false;
			}
		}
		return true;
	}

}
