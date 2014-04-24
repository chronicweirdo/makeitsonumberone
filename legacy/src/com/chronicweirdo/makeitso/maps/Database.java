package com.chronicweirdo.makeitso.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Database {

	private Rules rules;
	private Map<String, WMap> data = new HashMap<String, WMap>();
	
	public Database(Rules rules) {
		this.rules = rules;
	}
	
	public void save(WMap map) {
		rules.execute(Rules.BEFORE_SAVE, map);
		String id = UUID.randomUUID().toString();
		data.put(id, map);
		rules.execute(Rules.AFTER_SAVE, map);
	}
	
	public WMap load(String id) {
		WMap result = data.get(id);
		rules.execute(Rules.AFTER_LOAD, result);
		return result;
	}
	
	public List<WMap> find(WCondition query) {
		List<WMap> result = new ArrayList<WMap>();
		for (WMap map: data.values()) {
			if (query.test(map)) {
				rules.execute(Rules.BEFORE_FIND, map);
				result.add(map);
				rules.execute(Rules.AFTER_FIND, map);
			}
		}
		return result;
	}
}
