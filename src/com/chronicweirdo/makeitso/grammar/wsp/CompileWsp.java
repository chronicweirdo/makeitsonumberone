package com.chronicweirdo.makeitso.grammar.wsp;

import java.io.File;
import java.net.URL;

import com.chronicweirdo.makeitso.grammar.Util;

public class CompileWsp {

	public static void main(String[] args) {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso", "grammar",
				"wsp", "Wsp.g4");
		System.out.println(path);
		Util.compile(path);
	}

}
