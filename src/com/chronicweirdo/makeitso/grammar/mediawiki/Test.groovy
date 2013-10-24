package com.chronicweirdo.makeitso.grammar.mediawiki

import java.nio.file.Paths

import com.chronicweirdo.makeitso.grammar.Util

class Test {
	
	private static final String REGEX_TEMPLATE = /(?m)(?s)\Q{{\E.+\Q}}\E/
	private static final String PREDICATE_TEMPLATE = "template"

	/**
	 * Select interest regions in the text using a regex expression, then parse that structural
	 * information using a certain predicate in the grammar.
	 * @param text
	 * @param regex
	 * @param predicate
	 * @return
	 */
	static parse(text, regex, predicate) {
		def matcher = text =~ regex
		MediawikiListenerImpl listener = new MediawikiListenerImpl();
		for (match in matcher) {
			Util.test(MediawikiLexer.class, MediawikiParser.class,
				listener, predicate, match);
		}
	}
	
	static main(args) {
		String path = Paths.get("src", "com", "chronicweirdo", "makeitso",
			"grammar", "mediawiki", "test1").toString();
		String file = Util.readFile(path);
		parse(file, REGEX_TEMPLATE, PREDICATE_TEMPLATE);
	}

}
