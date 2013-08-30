package com.chronicweirdo.makeitso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ConsoleUtils {

	private static String getString(Object o) {
		return o == null ? "null" : o.toString();
	}
	
	public static void print(Map map) {
		print(null, map);
	}
	
	public static void print(String name, Map map) {
		if (name != null) {
			System.out.print(name + ": ");
		}
		System.out.println("{");
		List<Entry<String, Object>> entryList = new ArrayList<Entry<String, Object>>(map.entrySet());
		Collections.sort(entryList, new Comparator<Entry>() {
			@Override
			public int compare(Entry arg0,
					Entry arg1) {
				return arg0.getKey().toString().compareTo(arg1.getKey().toString());
			}
		});
		for (Entry<String, Object> entry: entryList) {
			System.out.println(entry.getKey() + " : " + getString(entry.getValue()));
		}
		System.out.println("}");
	}
	
	public static void print(byte[] bytes) {
		print(bytes, false);
	}
	
	public static void print(byte[] bytes, boolean showSize) {
		if (showSize) {
			System.out.print(bytes.length + ": ");
		}
		System.out.print("[");
		String separator = "";
		for (byte b: bytes) {
			System.out.print(separator);
			System.out.print(b);
			separator = ", ";
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
