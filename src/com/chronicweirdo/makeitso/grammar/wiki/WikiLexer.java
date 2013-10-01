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
		T__0=1, SPACE=2, HASH=3, COLON=4, WORD=5;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'http'", "SPACE", "'#'", "':'", "WORD"
	};
	public static final String[] ruleNames = {
		"T__0", "SPACE", "HASH", "COLON", "WORD"
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\7 \b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\3\6\3\24\n\3\r\3"+
		"\16\3\25\3\4\3\4\3\5\3\5\3\6\6\6\35\n\6\r\6\16\6\36\2\7\3\3\1\5\4\1\7"+
		"\5\1\t\6\1\13\7\1\3\2\4\5\2\13\f\17\17\"\"\7\2\13\f\17\17\"\"%%<<!\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\r\3\2\2\2"+
		"\5\23\3\2\2\2\7\27\3\2\2\2\t\31\3\2\2\2\13\34\3\2\2\2\r\16\7j\2\2\16\17"+
		"\7v\2\2\17\20\7v\2\2\20\21\7r\2\2\21\4\3\2\2\2\22\24\t\2\2\2\23\22\3\2"+
		"\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\6\3\2\2\2\27\30\7%\2"+
		"\2\30\b\3\2\2\2\31\32\7<\2\2\32\n\3\2\2\2\33\35\n\3\2\2\34\33\3\2\2\2"+
		"\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\f\3\2\2\2\5\2\25\36";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}