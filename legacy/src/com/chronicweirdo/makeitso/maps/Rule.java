package com.chronicweirdo.makeitso.maps;

public interface Rule {

	// map matches the condition on this rule
	boolean matches(WMap map);
	
	// execute rule action
	void execute(WMap map);
}
