package com.chronicweirdo.makeitso.grammar.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FunctionsCentral implements Functions {

	private List<Functions> functions;
	
	public FunctionsCentral() {
		functions = new ArrayList();
		functions.add(new BasicFunctions());
		functions.add(new StorageFunctions());
	}
	
	@Override
	public Object function(Map map) throws Exception {
		for (Functions f: functions) {
			try {
				return f.function(map);
			} catch (Exception e) {
				// try next functions batch
			}
		}
		throw new Exception(E_FUNCTION);
	}

	@Override
	public Object function(String name, List parameters) throws Exception {
		for (Functions f: functions) {
			try {
				return f.function(name, parameters);
			} catch (Exception e) {
				// try next functions batch
			}
		}
		throw new Exception(E_FUNCTION);
	}

}
