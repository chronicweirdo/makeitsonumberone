package com.chronicweirdo.makeitso.maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.chronicweirdo.PrettyPrintUtils;
import com.chronicweirdo.makeitso.ConsoleUtils;

public class WMap {
	
	private Map map = new HashMap();
	
	public void set(String[] keys, Object value) {
		set(this.map, keys, value);
	}
	
	public Object get(String[] keys) {
		return get(this.map, keys);
	}

	public static String[] a(String ...keys) {
		return keys;
	}
	
	private static void set(Map map, String[] keys, Object object) {
		for (int i = 0; i < keys.length-1; i++) {
			if (map.containsKey(keys[i])) {
				Object tobject = map.get(keys[i]);
				if (tobject instanceof Map) {
					map = (Map) tobject;
				} else {
					Map tmap = new HashMap();
					map.put(keys[i], tmap);
					map = tmap;
				}
			} else {
				Map tmap = new HashMap();
				map.put(keys[i], tmap);
				map = tmap;
			}
		}
		map.put(keys[keys.length-1], object);
	}
	
	private static Object get(Map map, String[] keys) {
		for (int i = 0; i < keys.length-1; i++) {
			if (map.containsKey(keys[i])) {
				Object tobject = map.get(keys[i]);
				if (tobject instanceof Map) {
					map = (Map) tobject;
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
		if (map.containsKey(keys[keys.length-1])) {
			return map.get(keys[keys.length-1]);
		} else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		PrettyPrintUtils.print(builder, map);
		return builder.toString();
	}

	public static void main(String[] args) throws Exception {
		WMap map = new WMap();
		map.set(a("credentials", "facebook", "john.doe", "password"), "skjansdkandksndkc");
		map.set(a("credentials", "facebook", "john.doe", "security questions", "birth place"), "Ibiza");
		map.set(a("credentials", "twitter", "john.doe", "password"), "dadsdnd232ed");
		
		ConsoleUtils.print("wmap", map);
		ConsoleUtils.print("john doe password", map.get(a("credentials", "facebook", "john.doe", "password")));
		ConsoleUtils.print("puppy password", map.get(a("credentials", "facebook", "puppy", "password")));
	}
}
