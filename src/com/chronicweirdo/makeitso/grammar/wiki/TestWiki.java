package com.chronicweirdo.makeitso.grammar.wiki;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;

import com.chronicweirdo.makeitso.grammar.Util;
import com.chronicweirdo.makeitso.grammar.wiki.text3.Telement;
import com.chronicweirdo.makeitso.grammar.wiki.text4.Elem;
import com.chronicweirdo.makeitso.grammar.wiki.text5.Text;

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
		//page.delete(40, 50);
		page.insert(0, "this is a welcome addition ");
		print(page);
	}
	private static void testGrammar3() throws Exception {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso",
				"grammar", "wiki", "test2");
		String file = Util.readFile(path);
		Wiklex lex = new Wiklex(new ANTLRInputStream(file));
		Token token = lex.nextToken();
		System.out.println(Wiklex.ruleNames.length);
		while (token.getType() != Token.EOF) {
			
			System.out.println(token.getText()
					+ " " + Wiklex.tokenNames[token.getType()]
					+ " " + Wiklex.ruleNames[token.getType()-1]);
			token = lex.nextToken();
		}
	}
	
	public static Telement split(String input) {
		List<Telement> list = new ArrayList<Telement>();
		Wiklex lex = new Wiklex(new ANTLRInputStream(input));
		Token token = lex.nextToken();
		while (token.getType() != Token.EOF) {
			list.add(new Telement(Wiklex.ruleNames[token.getType()-1], token.getText()));
			token = lex.nextToken();
		}
		Telement result = Telement.link(list);
		return result;
	}
	
	public static void updateOffset(List<Elem> els) {
		int offset = 0;
		for (Elem el: els) {
			el.offset(offset);
			offset += el.length();
		}
	}

	private static void testGrammar4() throws Exception {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso",
				"grammar", "wiki", "test2");
		String file = Util.readFile(path);
		Telement page = split(file);
		
		print(page);

		//page.delete(13, 9);
		//page.delete(13, 5);
		//page.delete(40, 50);
		page.insert(0, "this is a welcome addition ");
		print(page);
	}
	
	private static void testGrammar5() throws Exception {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso",
				"grammar", "wiki", "test2");
		String file = Util.readFile(path);
		ElemWikiListenerImpl listener = new ElemWikiListenerImpl();
		Util.test(WikiLexer.class, WikiParser.class,  listener, "page",  file);
		List<Elem> page = listener.getPage();
		updateOffset(page);
		for(Elem el: page) {
			System.out.println(el.detail(0));
		}
		
		/*
		 * everything is in a page block
		 * when editing something:
		 * 	using offset and end, find place of insert/delete/update (can be the whole place)
		 * 	collapse that place to text (if it is a block)
		 * 	edit the text
		 * 	parse the text to obtain structure 
		 */
	}
	
	private static void testGrammar6() throws Exception {
		String path = Util.getPath("src", "com", "chronicweirdo", "makeitso",
				"grammar", "wiki", "test2");
		String file = Util.readFile(path);
		System.out.println(file);
		TokenDocWikiListenerImpl listener = new TokenDocWikiListenerImpl();
		Util.test(WikiLexer.class, WikiParser.class,  listener, "page",  file);
		listener.get().print();

	}
	
	public static void main(String[] args) throws Exception {
		testGrammar6();
	}

}
