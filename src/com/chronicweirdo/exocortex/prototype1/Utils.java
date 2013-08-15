package com.chronicweirdo.exocortex.prototype1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Utils {

	public static Map map(Object ... objects) {
		Map map = new HashMap();
		for (int i = 0; i < objects.length; i += 2) {
			map.put(objects[i], objects[i+1]);
		}
		return map;
	}
	
	public static Map<Object, Object> remove(Object ...objects) {
		Set<Object> notToBeIncluded = new HashSet<Object>(
				Arrays.asList(objects));
		Map<Object, Object> map = new HashMap<Object, Object>();
		for (Entry<Object, Object> entry: map.entrySet()) {
			if (!notToBeIncluded.contains(entry.getKey())) {
				map.put(entry.getKey(), entry.getValue());
			}
		}
		return map;
	}

	public static void main(String[] args) {
		System.out.println(map("_type", "file", "name", "exocortex.txt").toString());
	}

}
