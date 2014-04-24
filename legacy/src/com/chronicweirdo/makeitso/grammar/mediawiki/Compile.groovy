package com.chronicweirdo.makeitso.grammar.mediawiki

import java.nio.file.Paths

import com.chronicweirdo.makeitso.grammar.Util

class Compile {

	static main(args) {
		String path = Paths.get("src", "com", "chronicweirdo", "makeitso", "grammar",
			"mediawiki", "Mediawiki.g4").toString();
		System.out.println(path);
		Util.compile(path);
	}

}
