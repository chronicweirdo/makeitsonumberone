package com.chronicweirdo.makeitso.grammar.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chronicweirdo.makeitso.ConsoleUtils;

public class BasicFunctions implements Functions {

	private Database database;
	
	@Override
	public void setDatabase(Database database) {
		this.database = database;
	}
	
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
	public Object function(Map map) {
		String function = (String) map.get(P_FUNCTION);
		if (function.equals(F_SET)) {
			List path = path(map.get(P_PATH));
			Object value = map.get(P_VALUE);
			return database.set(path, value);
		} else if (function.equals(F_PRINT)) {
			Object value = map.get(P_VALUE);
			if (value instanceof Map) {
				ConsoleUtils.print((Map) value);
			} else {
				ConsoleUtils.print(value);
			}
			return value;
		} else if (function.equals(F_EXIT)) {
			System.exit(0);
		} else if (function.equals(F_GET)) {
			List path = path(map.get(P_PATH));
			return database.get(path);
		}
		return null;
	}
	
	private Map map(Object ... object) {
		if (object.length % 2 != 0) return null;
		Map map = new HashMap();
		for (int i = 0; i < object.length; i += 2) {
			map.put(object[i], object[i+1]);
		}
		return map;
	}

	@Override
	public Object function(String name, List parameters) {
		if (name.equals(F_GET)) {
			if (parameters.size() != 1) return null;
			return function(map(P_FUNCTION, name, P_PATH, parameters.get(0)));
		} else if (name.equals(F_SET)) {
			if (parameters.size() != 2) return null;
			return function(map(P_FUNCTION, name, P_PATH, parameters.get(0), P_VALUE, parameters.get(1)));
		} else if (name.equals(F_EXIT)) {
			if (parameters.size() != 0) return null;
			return function(map(P_FUNCTION, name));
		} else if (name.equals(F_PRINT)) {
			if (parameters.size() != 1) return null;
			return function(map(P_FUNCTION, name, P_VALUE, parameters.get(0)));
		}
		return null;
	}

	@Override
	public Object function(String name) {
		return function(name, new ArrayList());
	}

	@Override
	public Object set(List path, Object value) {
		return function(map(P_FUNCTION, F_SET, P_PATH, path, P_VALUE, value));
	}

	@Override
	public Object get(List path) {
		return function(map(P_FUNCTION, F_GET, P_PATH, path));
	}

}
