package com.chronicweirdo.makeitso.maps;

import java.util.ArrayList;
import java.util.Arrays;
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
	public Object getStar(String key) {
		List sources = new ArrayList();
		sources.add(this.map);
		return getStar(sources, key);
	}

	public static String[] a(String ...keys) {
		return keys;
	}
	
	public static List l(Object ... values) {
		List result = new ArrayList();
		for (Object o: values) {
			result.add(o);
		}
		return result;
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
		List sources = new ArrayList();
		sources.add(map);
		List result = get(sources, Arrays.asList(keys));
		if (result.size() == 0) {
			return null;
		} else if (result.size() == 1) {
			return result.get(0);
		} else {
			return result;
		}
	}
	private static List<Entry> matchingEntries(Map map, String pattern) {
		List<Entry> matching = new ArrayList<Entry>();
		for (Object o: map.entrySet()) {
			Entry entry = (Entry) o;
			if (entry.getKey().toString().matches(pattern)) {
				matching.add(entry);
			}
		}
		return matching;
	}
	private static List matchingValues(Map map, String pattern) {
		List matching = new ArrayList();
		for (Object o: map.entrySet()) {
			Entry entry = (Entry) o;
			if (entry.getKey().toString().matches(pattern)) {
				matching.add(entry.getValue());
			}
		}
		return matching;
	}
	private static List get(List sources, List<String> keys) {
		List results = new ArrayList();
		for (Object source: sources) {
			if (source instanceof Map) {
				Map map = (Map) source;
				// get all entries matching the current key
				List matching = matchingValues(map, keys.get(0));
				if (keys.size() == 1) {
					// this is the result
					results.addAll(matching);
				} else {
					// look for results at next level
					List<String> nextKeys = keys.subList(1, keys.size());
					List nextResults = get(matching, nextKeys);
					results.addAll(nextResults);
				}
			}
		}
		return results;
	}
	
	private static List getStar(List sources, String key) {
		List results = new ArrayList();
		for (Object source: sources) {
			if (source instanceof Map) {
				Map map = (Map) source;
				// get all entries matching the current key
				List matching = matchingValues(map, key);
				// add all matching values to results
				results.addAll(matching);
				// continue search on all values
				List all = matchingValues(map, ".*");
				List nextResults = getStar(all, key);
				results.addAll(nextResults);
				
			}
		}
		return results;
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
		map.set(a("notes", "websites", "facebook", "title"), "facebook");
		map.set(a("notes", "websites", "facebook", "contents"), "This is a social site that allows you to make new friends.");
		map.set(a("bookmarks", "facebook", "name"), "facebook");
		map.set(a("credentials", "twitter", "john.doe", "password"), "dadsdnd232ed");
		map.set(a("bookmarks", "facebook", "tag", "about"), l("social network", "socializing", "friends", "news"));
		
		ConsoleUtils.print("wmap", map);
		ConsoleUtils.print("john doe password", map.get(a("credentials", "facebook", "john.doe", "password")));
		ConsoleUtils.print("puppy password", map.get(a("credentials", "facebook", "puppy", "password")));
		ConsoleUtils.print("all passwords", map.get(a("credentials", ".*", ".*", "password")));
		ConsoleUtils.print("facebook data at second level", map.get(a(".*", "facebook")));
		ConsoleUtils.print("all facebook data", map.getStar("facebook"));
	}
}
