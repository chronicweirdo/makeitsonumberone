package com.chronicweirdo.makeitso.grammar.wiki;

import java.util.HashMap;
import java.util.Map;

import com.chronicweirdo.makeitso.grammar.Util;
import com.chronicweirdo.makeitso.grammar.wiki.text3.Telement;

public class TestWiki {

	private static void testGrammar() throws Exception {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso",
				"grammar", "wiki", "test1");
		String file = Util.readFile(path);
		Util.test(WikiLexer.class, WikiParser.class, 
				new DocWikiListenerImpl(), "page", 
				file);
	}
	
	private static void print(Telement page) {
		StringBuilder builder = new StringBuilder();
		page.print(builder);
		System.out.println(builder.toString());
		System.out.println(page.toString());
		System.out.println();
	}
	
	private static void testGrammar2() throws Exception {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso",
				"grammar", "wiki", "test2");
		String file = Util.readFile(path);
		Telement2WikiListenerImpl listener = new Telement2WikiListenerImpl();
		Util.test(WikiLexer.class, WikiParser.class,  listener, "page",  file);
		Telement page = listener.getPage();
		
		print(page);

		//page.delete(13, 9);
		//page.delete(13, 5);
		page.delete(40, 50);
		print(page);
	}
	public static void main(String[] args) throws Exception {
		testGrammar2();
	}

}
