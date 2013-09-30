package com.chronicweirdo.makeitso.grammar.maps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;


public class TestMapsInterpreter {

	private static void interpret(ParseTreeListener listener, String input) {
		Lexer lexer = new MapsLexer(new ANTLRInputStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		MapsParser parser = new MapsParser(tokens);
		parser.setBuildParseTree(true);

		parser.addParseListener(listener);

		ParserRuleContext tree = parser.program();
		printTree(tree);
	}
	private static void printTree(ParserRuleContext tree) {
		//System.out.println("children: " + tree.getChildCount());
		//for (int i = 0; i < tree.getChildCount(); i++) {
			printChild(tree, 0);
		//}
	}
	private static void printTabs(int tabs) {
		for (int i = 0; i < tabs; i++) System.out.print("\t");
	}
	private static void printChild(ParseTree elem, int depth) {
		// print current node
		printTabs(depth);System.out.println("text: " + elem.getText());
		printTabs(depth);System.out.println("class: " + elem.getClass().getCanonicalName());
		if (elem instanceof TerminalNodeImpl) {
			TerminalNodeImpl term = (TerminalNodeImpl) elem;
			printTabs(depth);System.out.println("a: " + elem.getSourceInterval().a);
			printTabs(depth);System.out.println("b: " + elem.getSourceInterval().b);
			printTabs(depth);System.out.println("l: " + elem.getSourceInterval().length());
		}
		// print children nodes
		for (int i = 0; i < elem.getChildCount(); i++) {
			printChild(elem.getChild(i), depth+1);
		}
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
