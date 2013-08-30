package com.chronicweirdo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PrettyPrintUtils {

	private static final String TAB = ". ";
	private static final String NL = "\n";
	private static final String SP = " : ";
	
	private static String getString(Object o) {
		return o == null ? "null" : o.toString();
	}
	
	public static void print(StringBuilder builder, Map map) {
		print(builder, null, map);
	}
	
	public static void print(StringBuilder builder, String name, Map map) {
		print(builder, name, map, 0);
	}
	
	private static void tabs(StringBuilder builder, int tab) {
		for (int i = 0; i < tab; i++) {
			builder.append(TAB);
		}
	}
	
	private static void print(StringBuilder builder, String name, Map map, int tab) {
		tabs(builder, tab);
		if (name != null) {
			builder.append(name + SP);
		}
		builder.append("{").append(NL);
		// sort entries
		List<Entry> entryList = new ArrayList<Entry>(map.entrySet());
		Collections.sort(entryList, new Comparator<Entry>() {
			@Override
			public int compare(Entry arg0,
					Entry arg1) {
				return arg0.getKey().toString().compareTo(arg1.getKey().toString());
			}
		});
		// list entries
		for (Entry entry: entryList) {
			if (entry.getValue() instanceof Map) {
				print(builder, entry.getKey().toString(), (Map) entry.getValue(), tab+1);
			} else {
				tabs(builder, tab+1);
				builder.append(entry.getKey() + SP + getString(entry.getValue())).append(NL);
			}
		}
		tabs(builder, tab);
		builder.append("}").append(NL);
	}
	
	public static void print(StringBuilder builder, byte[] bytes) {
		print(builder, null, bytes);
	}
	
	public static void print(StringBuilder builder, String name, byte[] bytes) {
		if (name != null) {
			builder.append(name).append(SP);
		}
		builder.append("[");
		String separator = "";
		for (byte b: bytes) {
			builder.append(separator);
			builder.append(b);
			separator = ", ";
		}
		builder.append("]").append(SP);
		builder.append(bytes.length);
	}
	
	public static void print(StringBuilder builder, String name, Object object) {
		if (name != null) {
			builder.append(name).append(SP);
		}
		builder.append(getString(object));
	}
}
