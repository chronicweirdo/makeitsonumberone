package com.chronicweirdo.exocortex.prototype1;

import java.util.Map;

public class Function {
	
	private static Object define(Map<Object, Object> parentContext, 
			Map<Object, Object> parameters) {
		String name = (String) parameters.get("name");
		Object value = parameters.get("value");
		parentContext.put(name, value);
		return null;
	}
	
	private static Object block(Map<Object, Object> parentContext, 
			Map<Object, Object> parameters) {
		
		return null;
	}
	
	private static Map<Object, Object> contextualize(
			Map<Object, Object> parentContext) {
		return parentContext;
	}
	
	public static Object call(Map<Object, Object> parentContext,
			Map<Object, Object> call) {
		String type = (String) call.get("_type");
		if (!type.equals("call")) return null;
		String functionName = (String) call.get("_name");
		
		Map<Object, Object> parameters = Utils.remove("_type", "_name");
		if (functionName.equals("define")) {
			return define(parentContext, parameters);
		}
		
		return null;
	}
}
