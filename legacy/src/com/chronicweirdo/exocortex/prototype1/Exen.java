package com.chronicweirdo.exocortex.prototype1;

import java.util.Map.Entry;

public class Exen implements Entry<Object, Object> {

	private Object key;
	private Object value;
	
	protected Exen(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public Object getKey() {
		return this.key;
	}

	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	public Object setValue(Object value) {
		Object oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (key != null) {
			builder.append(key.toString());
		} else {
			builder.append("null");
		}
		builder.append(":");
		if (value != null) {
			builder.append(value.toString());
		} else {
			builder.append("null");
		}
		return builder.toString();
	}

	
}
