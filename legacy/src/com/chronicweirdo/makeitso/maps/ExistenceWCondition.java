package com.chronicweirdo.makeitso.maps;

public class ExistenceWCondition implements WCondition {

	private String[] path;
	
	public ExistenceWCondition(String[] path) {
		this.path = path;
	}
	
	@Override
	public boolean test(WMap map) {
		Object object = map.get(path);
		return object != null;
	}

}
