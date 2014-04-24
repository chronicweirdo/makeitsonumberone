package com.chronicweirdo.makeitso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Struct {
	
	public static List list(Object ... objects) {
		List list = new ArrayList();
		for (Object object: objects) {
			list.add(object);
		}
		return list;
	}
	
	public static Map map(Object... objects) {
		if (objects.length % 2 != 0)
			return null;
		Map map = new HashMap();
		for (int i = 0; i < objects.length; i += 2) {
			map.put(objects[i], objects[i + 1]);
		}
		return map;
	}
	
	public static List duplicate(List original) {
		List list = new ArrayList();
		for (Object object: original) {
			list.add(object);
		}
		return list;
	}
	public static List duplicate(List original, Object ... append) {
		List list = duplicate(original);
		for (Object object: append) {
			list.add(object);
		}
		return list;
	}
	
	
	public static List path(Object key) {
		String[] sPath = key.toString().split("\\\\.");
		return new ArrayList(Arrays.asList(sPath));
	}
	
	public static Object delete(Object source, List path) {
		Object current = source;
		if (path != null) {
			for (int i = 0; i < path.size()-1; i++) {
				if (current == null) return null;
				Object entry = path.get(i);
				// see if we have an object there or not
				Object temp = get(current, entry);
				if (temp == null) {
					return null;
				} else {
					current = temp;
				}
			}
			// remove the last value
			return delete(current, path.get(path.size()-1));
		} else {
			// do nothing if path is null
			// we can't change the base database object
			return null;
		}
	}

	public static Object set(Object source, List path, Object value) {
		Object current = source;
		if (path != null) {
			for (int i = 0; i < path.size()-1; i++) {
				if (current == null) return null;
				Object entry = path.get(i);
				// see if we have an object there or not
				Object temp = get(current, entry);
				if (temp == null) {
					Map map = new HashMap();
					current = set(current, entry, map);
				} else {
					current = temp;
				}
			}
			// add the last value
			return set(current, path.get(path.size()-1), value);
		} else {
			// do nothing if path is null
			// we can't change the base database object
			return null;
		}
	}
	
	private static Object delete(Object source, Object path) {
		if (source instanceof List) {
			// entry must be cast to int
			try {
				List list = (List) source;
				Integer index = Integer.parseInt(path.toString());
				if (index < 0) return null;
				if (index < list.size()) {
					// remove existing value
					Object removed = list.get(index);
					list.remove(index);
					return removed;
				} else {
					return null;
				}
			} catch (NumberFormatException e) {
				// could not set
				return null;
			}
		} else if (source instanceof Map) {
			Map map = (Map) source;
			if (map.containsKey(path)) {
				Object removed = map.get(path);
				map.remove(path);
				return removed;
			}
			return null;
		} else {
			// we can't remove a value from something else that list or map
			return null;
		}
	}
	
	private static Object set(Object source, Object path, Object value) {
		if (source instanceof List) {
			// entry must be cast to int
			try {
				List list = (List) source;
				Integer index = Integer.parseInt(path.toString());
				if (index < 0) return null;
				if (index < list.size()) {
					// update existing value
					list.set(index, value);
					return value;
				} else {
					// create new values up to index
					for (int i = list.size(); i < index; i++) {
						list.add(null);
					}
					list.add(value);
					return value;
				}
			} catch (NumberFormatException e) {
				// could not set
				return null;
			}
		} else if (source instanceof Map) {
			Map map = (Map) source;
			map.put(path, value);
			return value;
		} else {
			// we can't set a value on something else that list or map
			return null;
		}
	}
	
	
	// get the entry from source
	// works for map or list
	private static Object get(Object source, Object pathEntry) {
		if (source instanceof List) {
			// entry must be cast to int
			try {
				List list = (List) source;
				Integer index = Integer.parseInt(pathEntry.toString());
				if (0 <= index && index < list.size()) {
					return list.get(index);
				} else {
					return null;
				}
			} catch (NumberFormatException e) {
				return null;
			}
		} else if (source instanceof Map) {
			if (((Map) source).containsKey(pathEntry)) {
				return ((Map) source).get(pathEntry);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	/**
	 * Get object in source according to path.
	 * Works for series of lists and maps.
	 * @param source - an object, a list or a map
	 * @param path - path to the desired value through series of lists and maps
	 * @return null if nothing is found, or the found value
	 */
	public static Object get(Object source, List path) {
		Object value = source;
		if (path != null) {
			for (Object entry: path) {
				value = get(value, entry);
				if (value == null) {
					return null;
				}
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
		Map map = new HashMap();
		List path = new ArrayList();
		path.add("home");
		path.add("data");
		path.add("complete");
		set(map, path, 15);
		set(map, list("new"), 14);
		System.out.println(get(map, path));
		ConsoleUtils.print(map);
		delete(map, "home");
		ConsoleUtils.print(map);
	}

}
