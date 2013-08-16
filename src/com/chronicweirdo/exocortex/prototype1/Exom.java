package com.chronicweirdo.exocortex.prototype1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exom implements Map<Object, Object> {

	private List<Exen> entries = new ArrayList<Exen>();
	
	public Exom() {
	}
	
	public Exom(Exom parent) {
		for (Exen entry: parent.entries) {
			entries.add(entry);
		}
	}
	
	@Override
	public int size() {
		return entries.size();
	}

	@Override
	public boolean isEmpty() {
		return entries.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		for (Exen entry: entries) {
			if (entry.getKey().equals(key)) return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for (Exen entry: entries) {
			if (entry.getValue().equals(value)) return true;
		}
		return false;
	}

	@Override
	public Object get(Object key) {
		for (Exen entry: entries) {
			if (entry.getKey().equals(key)) return entry.getValue();
		}
		return null;
	}
	
	public Exen getEntry(Object key) {
		for (Exen entry: entries) {
			if (entry.getKey().equals(key)) return entry;
		}
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		Exen entry = getEntry(key);
		if (entry == null) {
			this.entries.add(new Exen(key, value));
			return null;
		} else {
			return entry.setValue(value);
		}
	}
	
	public Exen putEntry(Exen entry) {
		Exen oldEntry = getEntry(entry.getKey());
		if (oldEntry == null) {
			entries.add(entry);
			return null;
		} else {
			entries.remove(oldEntry);
			entries.add(entry);
			return oldEntry;
		}
	}
	
	public void putEntryNO(Exen entry) {
		Exen oldEntry = getEntry(entry.getKey());
		if (oldEntry == null) {
			entries.add(entry);
		}
	}

	@Override
	public Object remove(Object key) {
		Exen entry = getEntry(key);
		if (entry == null) {
			return null;
		} else {
			entries.remove(entry);
			return entry.getValue();
		}
	}

	@Override
	public void putAll(Map<? extends Object, ? extends Object> m) {
		for (Entry entry: m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}
	
	public void putAllNO(Exom map) {
		for (Exen entry: map.entries) {
			putEntryNO(entry);
		}
	}

	@Override
	public void clear() {
		entries = new ArrayList<Exen>();
	}

	@Override
	public Set<Object> keySet() {
		Set<Object> keySet = new HashSet<Object>();
		for (Exen entry: entries) {
			keySet.add(entry.getKey());
		};
		return keySet;
	}

	@Override
	public Collection<Object> values() {
		Set<Object> values = new HashSet<Object>();
		for (Exen entry: entries) {
			values.add(entry.getValue());
		};
		return values;
	}

	@Override
	public Set<java.util.Map.Entry<Object, Object>> entrySet() {
		return new HashSet<java.util.Map.Entry<Object, Object>>(entries);
	}
	
	public Set<Exen> entries() {
		return new HashSet<Exen>(entries);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		String prefix = "";
		for (Exen entry: entries) {
			builder.append(prefix).append(entry.toString());
			prefix = ",";
		}
		builder.append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		Exom rootContext = new Exom();
		rootContext.put("_user", "chronic");
		rootContext.put("rootVar", "xxx");
		System.out.println("root context: " + rootContext.toString());
		
		// we enter a function context
		Exom functionContext = new Exom(rootContext);
		System.out.println("function context: " + functionContext.toString());
		functionContext.put("tempVar", 3);
		functionContext.put("rootVar", 7);
		System.out.println("function contect: " + functionContext.toString());
		
		// we go back to the root context
		System.out.println("root context: " + rootContext.toString());
	}

}
