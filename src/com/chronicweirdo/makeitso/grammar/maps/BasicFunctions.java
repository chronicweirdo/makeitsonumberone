package com.chronicweirdo.makeitso.grammar.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chronicweirdo.makeitso.StructureUtils;

public class BasicFunctions implements Functions {
	
	public static final String F_SET = "set";
	public static final String F_GET = "get";
	public static final String F_DEL = "del";
	public static final String F_EXIT = "exit";
	
	private Object data = new HashMap();

	private List path(Object object) {
		if (object instanceof List) {
			return (List) object;
		} else {
			List list = new ArrayList();
			list.add(object);
			return list;
		}
	}

	@Override
	public Object function(Map map) throws Exception {
		String function = (String) map.get(P_FUNCTION);
		if (function.equals(F_SET)) {
			List path = path(map.get(P_PATH));
			Object value = map.get(P_VALUE);
			return StructureUtils.set(data, path, value);
		} else if (function.equals(F_DEL)) {
			List path = path(map.get(P_PATH));
			return StructureUtils.delete(data, path);
		} else if (function.equals(F_EXIT)) {
			System.exit(0);
		} else if (function.equals(F_GET)) {
			List path = path(map.get(P_PATH));
			return StructureUtils.get(data, path);
		} 
		throw new Exception(E_FUNCTION);
	}

	@Override
	public Object function(String name, List parameters) throws Exception {
		if (name.equals(F_GET) && parameters.size() == 1) {
			return function(StructureUtils.map(P_FUNCTION, name, P_PATH, parameters.get(0)));
		} else if (name.equals(F_SET) && parameters.size() == 2) {
			return function(StructureUtils.map(P_FUNCTION, name, P_PATH, parameters.get(0),
					P_VALUE, parameters.get(1)));
		} else if (name.equals(F_DEL) && parameters.size() == 1) {
			return function(StructureUtils.map(P_FUNCTION, name, P_PATH, parameters.get(0)));
		} else if (name.equals(F_EXIT) && parameters.size() == 0) {
			return function(StructureUtils.map(P_FUNCTION, name));
		}
		throw new Exception(E_FUNCTION);
	}
}
