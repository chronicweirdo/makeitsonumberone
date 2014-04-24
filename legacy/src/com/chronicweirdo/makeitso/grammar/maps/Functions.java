package com.chronicweirdo.makeitso.grammar.maps;

import java.util.List;
import java.util.Map;

public interface Functions {
	
	public static final String E_FUNCTION = "No function found!";
	
	public static final String P_FUNCTION = "function";
	public static final String P_PATH = "path";
	public static final String P_VALUE = "value";

	Object function(Map map) throws Exception;
	
	Object function(String name, List parameters) throws Exception;
}
