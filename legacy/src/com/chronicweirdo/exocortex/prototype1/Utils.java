package com.chronicweirdo.exocortex.prototype1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Utils {

	public static Exom map(Object ... objects) {
		Exom map = new Exom();
		for (int i = 0; i < objects.length; i += 2) {
			map.put(objects[i], objects[i+1]);
		}
		return map;
	}
	
	public static Exom remove(Object ...objects) {
		Set<Object> notToBeIncluded = new HashSet<Object>(
				Arrays.asList(objects));
		Exom map = new Exom();
		for (Exen entry: map.entries()) {
			if (!notToBeIncluded.contains(entry.getKey())) {
				map.putEntry(entry);
			}
		}
		return map;
	}
	
	private static Object[] remainingPath(Object[] path) {
		if (path.length <= 1) return null;
		Object[] result = new Object[path.length-1];
		for (int i = 1; i < path.length; i++) {
			result[i-1] = path[i];
		}
		return result;
	}
	public static Object path(Exom map, Object[] path) {
		if (path == null || path.length == 0) return null;
		Object selection = map.get(path[0]);
		if (path.length > 1) {
			if (selection instanceof Exom) {
				Exom sel = (Exom) selection;
				Object[] p = remainingPath(path);
				return path(sel, p);
			} else {
				return null;
			}
		} else {
			return selection;
		}
	}

	public static List<Object> indexed(Exom map) {
		Map<Long, Object> indexes = new HashMap<Long, Object>();
		for (Exen entry: map.entries()) {
			Long index = null;
			try {
				index = Long.parseLong(entry.getKey().toString());
			} catch (NumberFormatException e) {
				// do nothing
			}
			if (index != null) {
				indexes.put(index, entry.getValue());
			}
		}
		// order
		List<Entry<Long, Object>> list = new ArrayList<Entry<Long, Object>>(indexes.entrySet());
		Collections.sort(list, new Comparator<Entry<Long, Object>>() {
			@Override
			public int compare(Entry<Long, Object> o1, Entry<Long, Object> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		// extract
		List<Object> result = new ArrayList<Object>();
		for (Entry<Long, Object> entry: list) {
			result.add(entry.getValue());
		}
		return result;
	}
	
	public static void main(String[] args) {
		//System.out.println(map("_type", "file", "name", "exocortex.txt").toString());
		System.out.println(indexed(map("_type","list",-7,7,1,1,5,2,"3",map(1,1))).toString());
	}

}
