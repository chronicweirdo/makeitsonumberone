package com.chronicweirdo.makeitso.grammar.maps;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import com.chronicweirdo.makeitso.grammar.Util;

public class TestMaps {

	public static void main(String[] args) throws Exception {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso",
				"grammar", "maps", "test1");
		String file = Util.readFile(path);
		Util.test(MapsLexer.class, MapsParser.class, 
				new MapsListenerImpl(), "program", 
				file);
	}

}
