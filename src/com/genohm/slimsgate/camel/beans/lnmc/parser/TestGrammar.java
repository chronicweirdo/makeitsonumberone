package com.genohm.slimsgate.camel.beans.lnmc.parser;

import java.io.FileNotFoundException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterLexer;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.FetchQueryContext;

public class TestGrammar {

	private static void testSlimsFilterGrammar() throws FileNotFoundException {
		String query = CompileGrammar.readFile("src/com/genohm/slimsgate/camel/beans/lnmc/parser/filter/testQuery3.txt");
		SlimsFilterLexer lexer = new SlimsFilterLexer(new ANTLRInputStream(query));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SlimsFilterParser parser = new SlimsFilterParser(tokens);
		parser.setBuildParseTree(true);
		parser.addParseListener(new SlimsFilterProcessor());
		ParserRuleContext tree = parser.formatQuery();
		System.out.println("done");
	}

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		testSlimsFilterGrammar();
	}

}
