package com.chronicweirdo.makeitso.grammar.maps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import com.chronicweirdo.makeitso.Struct;
import com.chronicweirdo.makeitso.grammar.Util;

public class TestMapsInterpreter {

	private static void interpret(ParseTreeListener listener, String input) {
		Lexer lexer = new MapsLexer(new ANTLRInputStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		MapsParser parser = new MapsParser(tokens);
		parser.setBuildParseTree(true);

		parser.addParseListener(listener);

		ParserRuleContext tree = parser.program();
	}
	private static void readLoop() throws Exception {
		Functions functions = new FunctionsCentral();
		MapsListenerImpl listener = new MapsListenerImpl();
		listener.setFunctions(functions);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = br.readLine();
			if (!line.endsWith(";")) {
				line += ";";
			}
			interpret(listener, line);
		}
	}
	public static void main(String[] args) throws Exception {
		readLoop();
	}

}
