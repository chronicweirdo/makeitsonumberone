package com.chronicweirdo.makeitso.grammar.wiki;

import com.chronicweirdo.makeitso.grammar.Util;

public class CompileWiklex {

	public static void main(String[] args) {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso", "grammar",
				"wiki", "Wiklex.g4");
		System.out.println(path);
		Util.compile(path);
	}

}
