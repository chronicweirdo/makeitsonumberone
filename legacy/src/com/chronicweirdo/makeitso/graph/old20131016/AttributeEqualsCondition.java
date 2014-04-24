package com.chronicweirdo.makeitso.graph.old20131016;

public class AttributeEqualsCondition implements Condition {

	private Object key;
	private Object value;
	
	public AttributeEqualsCondition(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public boolean evaluate(GREL object) {
		Object attribute = object.get(key);
		return value.equals(attribute);
	}

}
