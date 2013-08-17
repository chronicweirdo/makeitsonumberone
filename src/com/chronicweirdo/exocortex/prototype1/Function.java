package com.chronicweirdo.exocortex.prototype1;

import java.util.List;
import java.util.Stack;

public class Function {
	
	private static Stack<Exom> contexts = new Stack<Exom>();
	
	// operating on topmost context - probably just assign and select
	private static Object assign(Exom call) {
		String name = (String) call.get("name");
		Object value = call.get("value");
		if (value instanceof Exom) {
			value = call((Exom)value);
		}
		contexts.peek().put(name, value);
		return null;
	}
	
	private static Object fReturn(Exom call) {
		Object value = call.get("value");
		if (value instanceof Exom) {
			value = call((Exom)value);
		}
		contexts.peek().put("_return", value);
		return null;
	}
	
	private static Object select(Exom call) {
		Object path = call.get("path");
		if (path instanceof Exom) {
			path = call((Exom)path);
		}
		if (call.containsKey("value")) {
			Exom value = (Exom) call.get("value");
			value = (Exom) call(value);
			return value.get(path);
		} else {
			return contexts.peek().get(path);
		}
	}
	
	private static Object tokenize(Exom call) {
		Object value = call.get("value");
		if (value instanceof Exom) {
			value = call((Exom)value);
		}
		String split = (String) call.get("split");
		String[] list = value.toString().split(split);
		Exom result = new Exom();
		for (int i = 0; i < list.length; i++) {
			result.put(new Long(i), list[i]);
		}
		return result;
	}
	
	private static Object size(Exom call) {
		Object value = call.get("value");
		if (value instanceof Exom) {
			value = call((Exom)value);
		}
		if (value instanceof Exom) {
			return new Long(((Exom)value).size());
		} else {
			return null;
		}
	}
	
	private static Object minus(Exom call) {
		List<Object> arguments = Utils.indexed(call);
		for (int i=0; i < arguments.size(); i++) {
			if (arguments.get(i) instanceof Exom) {
				arguments.set(i, call((Exom)arguments.get(i)));
			}
		}
		Long result = Long.parseLong(arguments.get(0).toString());
		for (int i = 1; i < arguments.size(); i++) {
			result -= Long.parseLong(arguments.get(i).toString());
		}
		System.out.println("Result of minus is: " + result);
		return result;
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
		System.out.println(contexts.peek().toString());
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
		if (!type.equals("call")) return call;
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
		if (functionName.equals("minus")) {
			return minus(call);
		}
		if (functionName.equals("size")) {
			return size(call);
		}
		if (functionName.equals("tokenize")) {
			return tokenize(call);
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
	
	private static Exom m(Object ... objects) {
		return Utils.map(objects);
	}
	
	private static void defineFunction() {
		/*
		 * 0:[_type:call,_name:=,
				name:tokenizedName,
				value:[_type:call,_name:tokenize,
					value:[_type:call,_name:select,path:fileName],
					split:.
				]
			]
		 */
		Exom line0 = m(
			"_type", "call",
			"_name", "assign",
			"name", "tokenizedName",
			"value", m(
				"_type", "call",
				"_name", "tokenize",
				"value", m(
					"_type", "call",
					"_name", "select",
					"path", "fileName"
				),
				"split", "\\."
			)
		);
		/*
		1:[_type:call,_name:=,
				name:size,
				value:[_type:call,_name:size,
					value:[_type:call,_name:select,path:tokenizedName]
				]
			]
		*/
		Exom line1 = m(
			"_type", "call",
			"_name", "assign",
			"name", "size",
			"value", m(
				"_type", "call",
				"_name", "size",
				"value", m(
					"_type", "call",
					"_name", "select",
					"path", "tokenizedName"
				)
			)
		);
		/*
		2:[_type:call,_name:=,
				name:extension,
				value:[_type:call,_name:select,
					value:[_type:call,_name:select,path:tokenizedName],
					path:[_type:call,_name:-,
						0:[_type:call,_name:select,path:size],
						1:1
					]
				]
			]
		*/
		Exom line2 = m(
			"_type", "call",
			"_name", "assign",
			"name", "extension",
			"value", m(
				"_type", "call",
				"_name", "select",
				"value", m(
					"_type", "call",
					"_name", "select",
					"path", "tokenizedName"
				),
				"path", m(
					"_type", "call",
					"_name", "minus",
					0, m(
						"_type", "call",
						"_name", "select",
						"path", "size"
					),
					1, 1
				)
			)
			
		);
		/*
		3:[_type:call,_name:return,
				value:[_type:call,_name:select,path:extension]
			]
		*/
		Exom line3 = m(
			"_type", "call",
			"_name", "return",
			"value", m(
				"_type", "call",
				"_name", "select",
				"path", "extension"
			)
		);
		Exom function = Utils.map(
			"_type", "function",
			"_name", "extractExtension",
			"_parameters", Utils.map(0, "fileName"),
			0, line0,
			1, line1,
			2, line2,
			3, line3
		);
		function(function);
		/*
		[_type:function,_name:extractExtension,
			_parameters:[0:fileName],
			0:[_type:call,_name:=,
				name:tokenizedName,
				value:[_type:call,_name:tokenize,
					value:[_type:call,_name:select,path:fileName],
					split:.
				]
			]
			1:[_type:call,_name:=,
				name:size,
				value:[_type:call,_name:size,
					value:[_type:call,_name:select,path:tokenizedName]
				]
			]
			2:[_type:call,_name:=,
				name:extension,
				value:[_type:call,_name:select,
					value:[_type:call,_name:select,path:tokenizedName],
					path:[_type:call,_name:-,
						0:[_type:call,_name:select,path:size],
						1:1
					]
				]
			]
			3:[_type:call,_name:return,
				value:[_type:call,_name:select,path:extension]
			]
		]
		*/
	}
	
	public static void main(String[] args) {
		Exom rootContext = new Exom();
		contexts.push(rootContext);
		
		//System.out.println(call(Utils.map("_type", "call", "_name", "assign", "name", "name1", "value", 55)));
		//System.out.println(contexts.peek().toString());
		//System.out.println(call(Utils.map("_type", "call", "_name", "select", "path", "name1")));
		
		//System.out.println(call(Utils.map("_type", "call", "_name", "size", "value", Utils.map(1, 1, 2, 2, 3, 3))));
		//System.out.println(call(Utils.map("_type", "call", "_name", "minus", 1, 4, 2, 2, 3, -1)));
		//System.out.println(call(Utils.map("_type", "call", "_name", "tokenize", "value", "program.exe", "split", "\\.")));
		defineFunction();
		System.out.println(rootContext.toString());
		System.out.println(call(m("_type", "call", "_name", "extractExtension", "fileName", "program.exe")));
	}
}
