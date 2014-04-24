package com.chronicweirdo.jbon.reader

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;

import com.chronicweirdo.jbon.grammar.JBONLexer
import com.chronicweirdo.jbon.grammar.JBONListener
import com.chronicweirdo.jbon.grammar.JBONListenerImpl
import com.chronicweirdo.jbon.grammar.JBONParser
import com.chronicweirdo.makeitso.grammar.Util

class JBONReader {

	static Object read(String jbon) {
		JBONListenerImpl listener = new JBONListenerImpl();
		parse(jbon, listener);
		return listener.object;
	}

	static private parse(String text, JBONListener listener) {
		JBONLexer lexer = new JBONLexer(new ANTLRInputStream(text));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JBONParser parser = new JBONParser(tokens);
		parser.setBuildParseTree(true);
		parser.addParseListener(listener);
		ParserRuleContext tree = parser.file();
	}

	static main(args) {
	}
}
