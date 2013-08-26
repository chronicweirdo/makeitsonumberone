package com.chronicweirdo.makeitso.grammar;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.antlr.v4.Tool;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;

public class Util {

	public static void compile(String path) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("done");
			}
		});
		Tool.main(new String[] { path });
	}

	public static void test(Class lexerClass, Class parserClass,
			ParseTreeListener listener, String methodName, String input)
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

	public static String readFile(String path) {
		try {
			StringBuilder builder = new StringBuilder();
			FileInputStream fstream = new FileInputStream(path);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				builder.append(strLine).append("\n");
			}
			in.close();
			return builder.toString();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}
	}
}
