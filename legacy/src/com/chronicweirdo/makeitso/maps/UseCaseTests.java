package com.chronicweirdo.makeitso.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class UseCaseTests {
	
	public static final String ID = "_id";
	public static final String TYPE = "_type";

	public static Map<String, Object> map(Object ...objects) {
		if (objects.length % 2 != 0) return null;
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < objects.length; i += 2) {
			map.put(objects[i].toString(), objects[i+1]);
		}
		return map;
	}
	
	public static void print(Map<String, Object> map) {
		for (Entry<String, Object> entry: map.entrySet()) {
			System.out.println(entry.getKey() + " :: " + entry.getValue().toString());
		}
		System.out.println();
	}

	public static void test1() {
		// basic object
		Map<String, Object> m1 = map(ID, UUID.randomUUID(), TYPE, "");
		print(m1);
	}
	
	public static void test2() {
		// text file
		Map<String, Object> m1 = map(
				ID, UUID.randomUUID(),
				TYPE, "text",
				"paragraphs", map(
							"0", "The Story of Maury",
							"1", "",
							"2", "This is the story of Maury.",
							"3", "The time outside is beautiful."
						),
				"title", "The Story of Maury"
				);
		print(m1);
	}
	
	public static void main(String[] args) {
		test2();
	}

}
