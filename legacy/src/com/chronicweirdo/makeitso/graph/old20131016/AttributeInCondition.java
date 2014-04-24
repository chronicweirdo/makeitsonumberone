package com.chronicweirdo.makeitso.graph.old20131016;

import java.util.List;

public class AttributeInCondition implements Condition {

	private Object key;
	private List values;
	
	public AttributeInCondition(Object key, List values) {
		super();
		this.key = key;
		this.values = values;
	}

	@Override
	public boolean evaluate(GREL object) {
		Object attribute = object.get(key);
		for (Object value: values) {
			if (value.equals(attribute)) {
				return true;
			}
		}
		return false;
	}

}
