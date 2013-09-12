package com.chronicweirdo.makeitso.grammar.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chronicweirdo.makeitso.ConsoleUtils;
import com.chronicweirdo.makeitso.file.FileUtils;
import com.chronicweirdo.protection.SerializationUtil;

public class Database {

	private String path;
	private Map data = new HashMap();
	
	public Object set(List path, Object value) {
		Object current = data;
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
	
	private Object set(Object source, Object path, Object value) {
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
	
	public Object get() {
		return get(null);
	}
	
	private Object get(Object source, Object pathEntry) {
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
	
	public Object get(List path) {
		Object value = data;
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
	
	public boolean save() {
		return save(null);
	}
	public boolean save(String path) {
		if (path == null) {
			if (this.path == null) return false;
			path = this.path;
		} else {
			this.path = path;
		}
		try {
			byte[] serialized = SerializationUtil.serialize(data);
			FileUtils.writeFile(path, serialized);
			this.path = path;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
	public boolean load() {
		return load(null);
	}
	public boolean load(String path) {
		if (path == null) {
			if (this.path == null) return false;
			path = this.path;
		} else {
			this.path = path;
		}
		try {
			byte[] file = FileUtils.readFile(path);
			data = (Map) SerializationUtil.deserialize(file);
			this.path = path;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		Database db = new Database();
		ConsoleUtils.print(db.data);

		List path = new ArrayList();
		path.add("var1");
		db.set(path, 5);
		System.out.println(db.get(path));
		ConsoleUtils.print(db.data);
		
		path = new ArrayList();
		path.add("var2");
		path.add("var3");
		db.set(path, new ArrayList());
		System.out.println(db.get(path));
		ConsoleUtils.print(db.data);
		
		path = new ArrayList();
		path.add("var2");
		path.add("var3");
		path.add("5");
		db.set(path, 17);
		System.out.println(db.get(path));
		ConsoleUtils.print(db.data);
	}

}
