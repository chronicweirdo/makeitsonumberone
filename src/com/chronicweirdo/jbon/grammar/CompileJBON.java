package com.chronicweirdo.jbon.grammar;

import java.io.File;
import java.net.URL;

import com.chronicweirdo.makeitso.grammar.Util;

public class CompileJBON {

	public static void main(String[] args) {
		String path = Util.getPath("src", "com", "chronicweirdo", "jbon", "grammar", "JBON.g4");
		System.out.println(path);
		Util.compile(path);
	}

}
