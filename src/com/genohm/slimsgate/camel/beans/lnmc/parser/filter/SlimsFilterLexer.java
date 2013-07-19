// Generated from src/com/genohm/slimsgate/camel/beans/lnmc/parser/filter/SlimsFilter.g4 by ANTLR 4.1

package com.genohm.slimsgate.camel.beans.lnmc.parser.filter;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SlimsFilterLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, STRING=13, ID=14, INT=15, WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"' '", "' limit '", "'format '", "'.'", "' filter '", "','", "' order '", 
		"' from step'", "'='", "'desc'", "';'", "'asc'", "STRING", "ID", "INT", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "STRING", "ID", "INT", "WS"
	};


	public SlimsFilterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SlimsFilter.g4"; }

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
		case 15: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\22w\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\6\17h\n"+
		"\17\r\17\16\17i\3\20\6\20m\n\20\r\20\16\20n\3\21\6\21r\n\21\r\21\16\21"+
		"s\3\21\3\21\2\22\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23"+
		"\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\2\3\2\5\3\2$$"+
		"\5\2C\\aac|\5\2\13\f\17\17\"\"y\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7-\3\2\2\2\t\65\3\2\2\2"+
		"\13\67\3\2\2\2\r@\3\2\2\2\17B\3\2\2\2\21J\3\2\2\2\23U\3\2\2\2\25W\3\2"+
		"\2\2\27\\\3\2\2\2\31^\3\2\2\2\33b\3\2\2\2\35g\3\2\2\2\37l\3\2\2\2!q\3"+
		"\2\2\2#$\7\"\2\2$\4\3\2\2\2%&\7\"\2\2&\'\7n\2\2\'(\7k\2\2()\7o\2\2)*\7"+
		"k\2\2*+\7v\2\2+,\7\"\2\2,\6\3\2\2\2-.\7h\2\2./\7q\2\2/\60\7t\2\2\60\61"+
		"\7o\2\2\61\62\7c\2\2\62\63\7v\2\2\63\64\7\"\2\2\64\b\3\2\2\2\65\66\7\60"+
		"\2\2\66\n\3\2\2\2\678\7\"\2\289\7h\2\29:\7k\2\2:;\7n\2\2;<\7v\2\2<=\7"+
		"g\2\2=>\7t\2\2>?\7\"\2\2?\f\3\2\2\2@A\7.\2\2A\16\3\2\2\2BC\7\"\2\2CD\7"+
		"q\2\2DE\7t\2\2EF\7f\2\2FG\7g\2\2GH\7t\2\2HI\7\"\2\2I\20\3\2\2\2JK\7\""+
		"\2\2KL\7h\2\2LM\7t\2\2MN\7q\2\2NO\7o\2\2OP\7\"\2\2PQ\7u\2\2QR\7v\2\2R"+
		"S\7g\2\2ST\7r\2\2T\22\3\2\2\2UV\7?\2\2V\24\3\2\2\2WX\7f\2\2XY\7g\2\2Y"+
		"Z\7u\2\2Z[\7e\2\2[\26\3\2\2\2\\]\7=\2\2]\30\3\2\2\2^_\7c\2\2_`\7u\2\2"+
		"`a\7e\2\2a\32\3\2\2\2bc\7$\2\2cd\n\2\2\2de\7$\2\2e\34\3\2\2\2fh\t\3\2"+
		"\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\36\3\2\2\2km\4\62;\2lk\3\2"+
		"\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2o \3\2\2\2pr\t\4\2\2qp\3\2\2\2rs\3\2"+
		"\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\b\21\2\2v\"\3\2\2\2\6\2ins";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}