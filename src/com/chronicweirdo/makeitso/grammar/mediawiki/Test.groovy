package com.chronicweirdo.makeitso.grammar.mediawiki

import java.nio.file.Paths

import com.chronicweirdo.makeitso.grammar.Util

class Test {

	static main(args) {
		String path = Paths.get("src", "com", "chronicweirdo", "makeitso",
			"grammar", "mediawiki", "test1").toString();
		String file = Util.readFile(path);
		def matcher = file =~ /(?m)(?s)\Q{{\E.+\Q}}\E/
		for (match in matcher) {
			println match
			Util.test(MediawikiLexer.class, MediawikiParser.class,
				new MediawikiListenerImpl(), "page",
				match);
		}
		/*Util.test(MediawikiLexer.class, MediawikiParser.class,
			new MediawikiListenerImpl(), "page",
			file);*/
	}

}
