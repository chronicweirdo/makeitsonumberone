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
		T__3=1, T__2=2, T__1=3, T__0=4, ID=5, NUMBER=6, WS=7, ANY=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':'", "'#'", "'http'", "'https'", "ID", "NUMBER", "WS", "ANY"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "ID", "NUMBER", "WS", "ANY"
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\n=\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\7\6%\n\6\f\6\16\6"+
		"(\13\6\3\7\6\7+\n\7\r\7\16\7,\3\7\3\7\6\7\61\n\7\r\7\16\7\62\5\7\65\n"+
		"\7\3\b\6\b8\n\b\r\b\16\b9\3\t\3\t\2\n\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r"+
		"\b\1\17\t\1\21\n\1\3\2\5\4\2C\\c|\7\2\60\60\62;C\\aac|\5\2\13\f\17\17"+
		"\"\"A\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\25\3\2\2\2\7\27\3\2"+
		"\2\2\t\34\3\2\2\2\13\"\3\2\2\2\r*\3\2\2\2\17\67\3\2\2\2\21;\3\2\2\2\23"+
		"\24\7<\2\2\24\4\3\2\2\2\25\26\7%\2\2\26\6\3\2\2\2\27\30\7j\2\2\30\31\7"+
		"v\2\2\31\32\7v\2\2\32\33\7r\2\2\33\b\3\2\2\2\34\35\7j\2\2\35\36\7v\2\2"+
		"\36\37\7v\2\2\37 \7r\2\2 !\7u\2\2!\n\3\2\2\2\"&\t\2\2\2#%\t\3\2\2$#\3"+
		"\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\f\3\2\2\2(&\3\2\2\2)+\4\62;\2"+
		"*)\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\64\3\2\2\2.\60\7\60\2\2/\61"+
		"\4\62;\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3"+
		"\2\2\2\64.\3\2\2\2\64\65\3\2\2\2\65\16\3\2\2\2\668\t\4\2\2\67\66\3\2\2"+
		"\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:\20\3\2\2\2;<\13\2\2\2<\22\3\2\2\2"+
		"\b\2&,\62\649";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}