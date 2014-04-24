package com.chronicweirdo.makeitso.graph.old20131016;

public class TypeCondition implements Condition {

	private Class type;
	
	public TypeCondition(Class type) {
		super();
		this.type = type;
	}

	@Override
	public boolean evaluate(GREL object) {
		return object.getClass().equals(type);
	}

}
