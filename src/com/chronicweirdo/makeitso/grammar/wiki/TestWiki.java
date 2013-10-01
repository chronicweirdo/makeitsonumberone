package com.chronicweirdo.makeitso.grammar.wiki;

import java.util.HashMap;
import java.util.Map;

import com.chronicweirdo.makeitso.grammar.Util;

public class TestWiki {

	private static void testGrammar() throws Exception {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso",
				"grammar", "wiki", "test1");
		String file = Util.readFile(path);
		Util.test(WikiLexer.class, WikiParser.class, 
				new DocWikiListenerImpl(), "page", 
				file);
	}
	public static void main(String[] args) throws Exception {
		testGrammar();
	}

}
