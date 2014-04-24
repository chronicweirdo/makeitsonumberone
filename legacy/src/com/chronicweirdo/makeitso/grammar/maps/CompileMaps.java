package com.chronicweirdo.makeitso.grammar.maps;

import java.io.File;
import java.net.URL;

import com.chronicweirdo.makeitso.grammar.Util;

public class CompileMaps {

	public static void main(String[] args) {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso", "grammar",
				"maps", "Maps.g4");
		System.out.println(path);
		Util.compile(path);
	}

}
