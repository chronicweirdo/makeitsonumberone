package com.chronicweirdo.makeitso.grammar.maps;

import java.util.List;
import java.util.Map;

public interface Functions {

	void setDatabase(Database database);
	
	Object function(Map map);
	
	Object function(String name, List parameters);
}
