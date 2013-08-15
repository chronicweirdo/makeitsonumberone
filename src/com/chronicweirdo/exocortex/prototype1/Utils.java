package com.chronicweirdo.exocortex.prototype1;

import java.util.HashMap;
import java.util.Map;

public class Utils {

	public static Map map(Object ... objects) {
		Map map = new HashMap();
		for (int i = 0; i < objects.length; i += 2) {
			map.put(objects[i], objects[i+1]);
		}
		return map;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(map("_type", "file", "name", "exocortex.txt").toString());
	}

}
