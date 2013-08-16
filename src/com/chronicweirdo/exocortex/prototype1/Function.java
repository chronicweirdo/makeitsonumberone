package com.chronicweirdo.exocortex.prototype1;

import java.util.List;
import java.util.Stack;

public class Function {
	
	private static Stack<Exom> contexts = new Stack<Exom>();
	
	// operating on topmost context - probably just assign and select
	private static Object assign(Exom call) {
		String name = (String) call.get("name");
		Object value = call.get("value");
		contexts.peek().put(name, value);
		return null;
	}
	
	private static Object fReturn(Exom call) {
		Object value = call.get("value");
		contexts.peek().put("_return", value);
		return null;
	}
	
	private static Object select(Exom call) {
		String path = (String) call.get("path");
		if (call.containsKey("value")) {
			Exom value = (Exom) call.get("value");
			return value.get(path);
		} else {
			return contexts.peek().get(path);
		}
	}
	
	// this defines a function, by saving it to the _functions map
	private static Object function(Exom function) {
		if (!contexts.peek().containsKey("_functions")) {
			contexts.peek().put("_functions", new Exom());
		}
		Exom functions = (Exom) contexts.peek().get("_functions");
		String name = (String) function.get("_name");
		functions.put(name, function);
		return null;
	}
	
	// creating their own context
	private static Object execute(Exom function, Exom call) {
		// new context is call with parent context 
		Exom parentContext = contexts.peek();
		call.putAllNO(parentContext);
		contexts.push(call);
		// extract lines in function
		List<Object> lines = Utils.indexed(function);
		// execute each instruction
		for (Object line: lines) {
			if (line instanceof Exom) {
				Exom instruction = (Exom) line;
				instruction(instruction);
			}
		}
		// verify if we have a return value
		Object result = null;
		if (call.containsKey("_return")) {
			result = call.get("_return");
		}
		// pop context
		contexts.pop();
		return result;
	}
	
	public static Object instruction(Exom map) {
		String type = (String) map.get("_type");
		if (type.equals("call")) return call(map);
		return null;
	}
	
	public static Object call(Exom call) {
		String type = (String) call.get("_type");
		if (!type.equals("call")) return null;
		String functionName = (String) call.get("_name");
		
		// look at predefined functions first 
		if (functionName.equals("assign")) {
			return assign(call);
		}
		if (functionName.equals("select")) {
			return select(call);
		}
		if (functionName.equals("return")) {
			return fReturn(call);
		}
		// not look in the context functions
		if (contexts.peek().containsKey("_functions")) {
			Exom functions = (Exom) contexts.peek().get("_functions");
			Exom function = (Exom) functions.get(functionName);
			if (function != null) {
				return execute(function, call);
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Exom rootContext = new Exom();
		contexts.push(rootContext);
		
		System.out.println(call(Utils.map("_type", "call", "_name", "assign", "name", "name1", "value", 55)));
		System.out.println(contexts.peek().toString());
		System.out.println(call(Utils.map("_type", "call", "_name", "select", "path", "name1")));
	}
}
