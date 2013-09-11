package com.chronicweirdo.makeitso.grammar.maps;

import java.util.HashMap;
import java.util.Map;

public class Database {

	private Object data = new HashMap();
	
	public void set(Object data) {
		this.data = data;
	}
	
	public void set(String name, Object value) {
		if (data instanceof Map) {
			((Map) data).put(name, value);
		}
	}
	
	public Object get() {
		return data;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
