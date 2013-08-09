// Generated from src\com\chronicweirdo\exocortex\parser\Exocortex.g4 by ANTLR 4.1

package com.chronicweirdo.exocortex.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExocortexLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, BOOLEAN=7, STRING=8, ID=9, 
		NUMBER=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'[]'", "']'", "','", "'['", "':'", "'='", "BOOLEAN", "STRING", "ID", 
		"NUMBER", "WS"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "BOOLEAN", "STRING", "ID", 
		"NUMBER", "WS"
	};


	public ExocortexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Exocortex.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 10: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\rV\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\60\n\b\3\t\3\t\3\t\3\t\3\n\3\n\7\n"+
		"8\n\n\f\n\16\n;\13\n\3\13\7\13>\n\13\f\13\16\13A\13\13\3\13\3\13\6\13"+
		"E\n\13\r\13\16\13F\3\13\6\13J\n\13\r\13\16\13K\5\13N\n\13\3\f\6\fQ\n\f"+
		"\r\f\16\fR\3\f\3\f\2\r\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21"+
		"\n\1\23\13\1\25\f\1\27\r\2\3\2\6\3\2$$\5\2C\\aac|\6\2\62;C\\aac|\5\2\13"+
		"\f\17\17\"\"\\\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\3\31\3\2\2\2\5\34\3\2\2\2\7\36\3\2\2\2\t \3\2\2\2\13\"\3"+
		"\2\2\2\r$\3\2\2\2\17/\3\2\2\2\21\61\3\2\2\2\23\65\3\2\2\2\25M\3\2\2\2"+
		"\27P\3\2\2\2\31\32\7]\2\2\32\33\7_\2\2\33\4\3\2\2\2\34\35\7_\2\2\35\6"+
		"\3\2\2\2\36\37\7.\2\2\37\b\3\2\2\2 !\7]\2\2!\n\3\2\2\2\"#\7<\2\2#\f\3"+
		"\2\2\2$%\7?\2\2%\16\3\2\2\2&\'\7v\2\2\'(\7t\2\2()\7w\2\2)\60\7g\2\2*+"+
		"\7h\2\2+,\7c\2\2,-\7n\2\2-.\7u\2\2.\60\7g\2\2/&\3\2\2\2/*\3\2\2\2\60\20"+
		"\3\2\2\2\61\62\7$\2\2\62\63\n\2\2\2\63\64\7$\2\2\64\22\3\2\2\2\659\t\3"+
		"\2\2\668\t\4\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\24\3\2"+
		"\2\2;9\3\2\2\2<>\4\62;\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2"+
		"\2\2A?\3\2\2\2BD\7\60\2\2CE\4\62;\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3"+
		"\2\2\2GN\3\2\2\2HJ\4\62;\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3"+
		"\2\2\2M?\3\2\2\2MI\3\2\2\2N\26\3\2\2\2OQ\t\5\2\2PO\3\2\2\2QR\3\2\2\2R"+
		"P\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\f\2\2U\30\3\2\2\2\n\2/9?FKMR";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}