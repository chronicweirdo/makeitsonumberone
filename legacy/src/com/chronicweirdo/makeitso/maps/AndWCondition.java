package com.chronicweirdo.makeitso.maps;

import java.util.ArrayList;
import java.util.List;

public class AndWCondition implements WCondition {

	private List<WCondition> conditions;
	
	public AndWCondition(WCondition ...conditions) {
		this.conditions = new ArrayList<WCondition>();
	}
	
	@Override
	public boolean test(WMap map) {
		for (WCondition condition: conditions) {
			if (condition.test(map) == false) {
				return false;
			}
		}
		return true;
	}

}
