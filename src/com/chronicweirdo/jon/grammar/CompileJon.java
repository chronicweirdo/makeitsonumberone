package com.chronicweirdo.jon.grammar;

import java.io.File;
import java.net.URL;

import com.chronicweirdo.makeitso.grammar.Util;

public class CompileJon {

	public static void main(String[] args) {
		String path = Util.getPath("src", "com", "chronicweirdo", "jon", "grammar", "Jon.g4");
		System.out.println(path);
		Util.compile(path);
	}

}
