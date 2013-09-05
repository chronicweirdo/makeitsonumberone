package com.chronicweirdo.makeitso.maps;

public class EqualityWCondition implements WCondition {

	private String[] path;
	private Object value;
	
	public EqualityWCondition(String[] path, Object value) {
		this.path = path;
	}
	
	@Override
	public boolean test(WMap map) {
		Object object = map.get(path);
		return value == null ? object == null : value.equals(object);
	}

}
