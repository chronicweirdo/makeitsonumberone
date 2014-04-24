package com.chronicweirdo.makeitso.grammar.maps;

import java.util.HashMap;
import java.util.Map;

import com.chronicweirdo.makeitso.grammar.Util;

public class TestMaps {

	private static void testGrammar() throws Exception {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso",
				"grammar", "maps", "test1");
		String file = Util.readFile(path);
		Util.test(MapsLexer.class, MapsParser.class, 
				new MapsListenerImpl(), "program", 
				file);
	}
	private static void testMap() {
		Map map = new HashMap();
		Object key = "key";
		map.put(key, 5);
		System.out.println(map.containsKey("key"));
	}
	public static void main(String[] args) throws Exception {
		testGrammar();
	}

}
