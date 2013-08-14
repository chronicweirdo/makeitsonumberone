package com.chronicweirdo.exocortex;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import com.chronicweirdo.exocortex.parser.ExocortexLexer;
import com.chronicweirdo.exocortex.parser.ExocortexListenerImpl;
import com.chronicweirdo.exocortex.parser.ExocortexParser;

public class Test {

	private static void execute(Class lexerClass, Class parserClass,
			ParseTreeListener listener, String methodName,
			String input)
			throws FileNotFoundException, NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		
		Constructor lexerConstructor = lexerClass
				.getConstructor(CharStream.class);
		Lexer lexer = (Lexer) lexerConstructor
				.newInstance(new ANTLRInputStream(input));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		Constructor parserConstructor = parserClass
				.getConstructor(TokenStream.class);

		Parser parser = (Parser) parserConstructor.newInstance(tokens);
		parser.setBuildParseTree(true);

		parser.addParseListener(listener);

		Method method = parserClass.getMethod(methodName);

		ParserRuleContext tree = (ParserRuleContext) method.invoke(parser);

		System.out.println("---- done ----");
	}

	public static void main(String[] args) throws FileNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Class lexerClass = ExocortexLexer.class;
		Class parserClass = ExocortexParser.class;
		ExocortexListenerImpl listener = new ExocortexListenerImpl();
		String methodName = "program";
		String input = readFile("/com/chronicweirdo/exocortex/test/query1");
		execute(lexerClass, parserClass, listener, methodName, input);
		print(listener.getVariables());
	}
	
	public static void print(Map<String, Object> maps) {
		for (Entry<String, Object> e: maps.entrySet()) {
			if (e.getValue() != null) {
				System.out.println(e.getKey() + " = " + e.getValue().toString());
			} else {
				System.out.println(e.getKey() + " = null");
			}
		}
		System.out.println();
	}
	
	public static String readFile(String path) throws FileNotFoundException {
		InputStream in = new Object().getClass().getResourceAsStream(path);
		return new Scanner(in).useDelimiter("\\Z").next();
	}
}
