// Generated from src/com/chronicweirdo/makeitso/grammar/mediawiki/Mediawiki.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.mediawiki;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MediawikiLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, SPACE=5, WORD=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'}}'", "'='", "'{{'", "'|'", "SPACE", "WORD"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "SPACE", "WORD"
	};


	public MediawikiLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mediawiki.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\b#\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4"+
		"\3\5\3\5\3\6\6\6\33\n\6\r\6\16\6\34\3\7\6\7 \n\7\r\7\16\7!\2\b\3\3\1\5"+
		"\4\1\7\5\1\t\6\1\13\7\1\r\b\1\3\2\4\5\2\13\f\17\17\"\"\7\2\13\f\17\17"+
		"\"\"??}\177$\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\22\3\2\2\2\7\24\3\2\2\2\t\27\3\2\2\2\13"+
		"\32\3\2\2\2\r\37\3\2\2\2\17\20\7\177\2\2\20\21\7\177\2\2\21\4\3\2\2\2"+
		"\22\23\7?\2\2\23\6\3\2\2\2\24\25\7}\2\2\25\26\7}\2\2\26\b\3\2\2\2\27\30"+
		"\7~\2\2\30\n\3\2\2\2\31\33\t\2\2\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3"+
		"\2\2\2\34\35\3\2\2\2\35\f\3\2\2\2\36 \n\3\2\2\37\36\3\2\2\2 !\3\2\2\2"+
		"!\37\3\2\2\2!\"\3\2\2\2\"\16\3\2\2\2\5\2\34!";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}