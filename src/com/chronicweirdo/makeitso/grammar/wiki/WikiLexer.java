// Generated from src/com/chronicweirdo/makeitso/grammar/wiki/Wiki.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.wiki;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WikiLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HASH=1, COLON=2, HTTP=3, ID=4, NUMBER=5, SPACE=6, WORD=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'#'", "':'", "HTTP", "ID", "NUMBER", "SPACE", "WORD"
	};
	public static final String[] ruleNames = {
		"HASH", "COLON", "HTTP", "ID", "NUMBER", "SPACE", "WORD"
	};


	public WikiLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Wiki.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\tD\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4%\n\4\3\5\3\5"+
		"\7\5)\n\5\f\5\16\5,\13\5\3\6\6\6/\n\6\r\6\16\6\60\3\6\3\6\6\6\65\n\6\r"+
		"\6\16\6\66\5\69\n\6\3\7\6\7<\n\7\r\7\16\7=\3\b\6\bA\n\b\r\b\16\bB\2\t"+
		"\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\3\2\6\4\2C\\c|\7\2\60\60"+
		"\62;C\\aac|\5\2\13\f\17\17\"\"\7\2\13\f\17\17\"\"%%<<J\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\3\21\3\2\2\2\5\23\3\2\2\2\7$\3\2\2\2\t&\3\2\2\2\13.\3\2\2\2\r;\3\2\2"+
		"\2\17@\3\2\2\2\21\22\7%\2\2\22\4\3\2\2\2\23\24\7<\2\2\24\6\3\2\2\2\25"+
		"\26\7j\2\2\26\27\7v\2\2\27\30\7v\2\2\30\31\7r\2\2\31\32\7<\2\2\32\33\7"+
		"\61\2\2\33%\7\61\2\2\34\35\7j\2\2\35\36\7v\2\2\36\37\7v\2\2\37 \7r\2\2"+
		" !\7u\2\2!\"\7<\2\2\"#\7\61\2\2#%\7\61\2\2$\25\3\2\2\2$\34\3\2\2\2%\b"+
		"\3\2\2\2&*\t\2\2\2\')\t\3\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2"+
		"+\n\3\2\2\2,*\3\2\2\2-/\4\62;\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61"+
		"\3\2\2\2\618\3\2\2\2\62\64\7\60\2\2\63\65\4\62;\2\64\63\3\2\2\2\65\66"+
		"\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\62\3\2\2\289\3\2\2\2"+
		"9\f\3\2\2\2:<\t\4\2\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\16\3\2"+
		"\2\2?A\n\5\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\20\3\2\2\2\n\2"+
		"$*\60\668=B";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}