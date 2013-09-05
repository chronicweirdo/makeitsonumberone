package com.chronicweirdo.makeitso.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rules {
	
	public static final String BEFORE_SAVE = "beforeSave";
	public static final String BEFORE_FIND = "beforeFind";
	public static final String AFTER_SAVE = "afterSave";
	public static final String AFTER_FIND = "afterFind";
	public static final String AFTER_LOAD = "afterLoad";
	
	
	private Map<String, List<Rule>> actionRules = new HashMap<String, List<Rule>>();
	
	public Rules() {
		
	}
	
	public void add(String action, Rule rule) {
		if (!actionRules.containsKey(action)) {
			actionRules.put(action, new ArrayList<Rule>());
		}
		actionRules.get(action).add(rule);
	}
	
	public void execute(String action, WMap map) {
		if (actionRules.containsKey(action)) {
			for (Rule rule: actionRules.get(action)) {
				if (rule.matches(map)) {
					rule.execute(map);
				}
			}
		}
	}
}
