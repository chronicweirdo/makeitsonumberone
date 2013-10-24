package com.chronicweirdo.makeitso.parboiled;

import org.parboiled.BaseParser;
import org.parboiled.Parboiled;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;

@BuildParseTree 
class CalculatorParser extends BaseParser<Object> {

    Rule Expression() {
        return Sequence(
            Term(),
            ZeroOrMore(AnyOf("+-"), Term())
        );
    }

    Rule Term() {
        return Sequence(
            Factor(),
            ZeroOrMore(AnyOf("*/"), Factor())
        );
    }

    Rule Factor() {
        return FirstOf(
            Number(),
            Sequence('(', Expression(), ')')
        );
    }

    Rule Number() {
        return OneOrMore(CharRange('0', '9'));
    }

	public static void main(String[] args) {
		// https://github.com/sirthias/parboiled/wiki/Installation
		String input = "test 1+2";
		CalculatorParser parser = Parboiled.createParser(CalculatorParser.class);
		ParsingResult<?> result = ReportingParseRunner.run(parser.Expression(), input);
		String parseTreePrintOut = ParseTreeUtils.printNodeTree(result);
		System.out.println(parseTreePrintOut);
	}

}
