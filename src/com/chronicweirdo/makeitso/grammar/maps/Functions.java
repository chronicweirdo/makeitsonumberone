package com.chronicweirdo.makeitso.grammar.maps;

import java.util.List;
import java.util.Map;

public interface Functions {
	
	public static final String F_SET = "set";
	public static final String F_GET = "get";
	public static final String F_DEL = "del";
	public static final String F_PRINT = "print";
	public static final String F_EXIT = "exit";
	public static final String P_FUNCTION = "function";
	public static final String P_PATH = "path";
	public static final String P_VALUE = "value";

	void setDatabase(Database database);
	
	Object function(Map map) throws Exception;
	
	Object function(String name, List parameters) throws Exception;
	
	Object function(String name) throws Exception;
	
	Object set(List path, Object value) throws Exception;
	
	Object get(List path) throws Exception;

	Object del(List path) throws Exception;
}
