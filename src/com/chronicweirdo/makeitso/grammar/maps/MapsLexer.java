// Generated from src/com/chronicweirdo/makeitso/grammar/maps/Maps.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.maps;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MapsLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, STRING=12, ID=13, NUMBER=14, BLOCK_COMMENT=15, LINE_COMMENT=16, 
		WS=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "')'", "'.'", "','", "'['", "'print'", "':'", "'('", "'='", "';'", 
		"'find'", "STRING", "ID", "NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "STRING", "ID", "NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", 
		"WS"
	};


	public MapsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Maps.g4"; }

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
		case 14: BLOCK_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 15: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 16: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void BLOCK_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = HIDDEN;  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: _channel = HIDDEN;  break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\23w\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\rE\n\r\f\r"+
		"\16\rH\13\r\3\r\3\r\3\16\3\16\7\16N\n\16\f\16\16\16Q\13\16\3\17\6\17T"+
		"\n\17\r\17\16\17U\3\20\3\20\3\20\3\20\7\20\\\n\20\f\20\16\20_\13\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21j\n\21\f\21\16\21m\13"+
		"\21\3\21\3\21\3\22\6\22r\n\22\r\22\16\22s\3\22\3\22\3]\23\3\3\1\5\4\1"+
		"\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1"+
		"\33\17\1\35\20\1\37\21\2!\22\3#\23\4\3\2\b\3\2$$\4\2C\\c|\6\2\62;C\\a"+
		"ac|\4\2\60\60\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"|\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5\'"+
		"\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r/\3\2\2\2\17\65\3\2\2\2\21"+
		"\67\3\2\2\2\239\3\2\2\2\25;\3\2\2\2\27=\3\2\2\2\31B\3\2\2\2\33K\3\2\2"+
		"\2\35S\3\2\2\2\37W\3\2\2\2!e\3\2\2\2#q\3\2\2\2%&\7_\2\2&\4\3\2\2\2\'("+
		"\7+\2\2(\6\3\2\2\2)*\7\60\2\2*\b\3\2\2\2+,\7.\2\2,\n\3\2\2\2-.\7]\2\2"+
		".\f\3\2\2\2/\60\7r\2\2\60\61\7t\2\2\61\62\7k\2\2\62\63\7p\2\2\63\64\7"+
		"v\2\2\64\16\3\2\2\2\65\66\7<\2\2\66\20\3\2\2\2\678\7*\2\28\22\3\2\2\2"+
		"9:\7?\2\2:\24\3\2\2\2;<\7=\2\2<\26\3\2\2\2=>\7h\2\2>?\7k\2\2?@\7p\2\2"+
		"@A\7f\2\2A\30\3\2\2\2BF\7$\2\2CE\n\2\2\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2"+
		"FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7$\2\2J\32\3\2\2\2KO\t\3\2\2LN\t\4\2"+
		"\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\34\3\2\2\2QO\3\2\2\2RT\t\5"+
		"\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V\36\3\2\2\2WX\7\61\2\2XY"+
		"\7,\2\2Y]\3\2\2\2Z\\\13\2\2\2[Z\3\2\2\2\\_\3\2\2\2]^\3\2\2\2][\3\2\2\2"+
		"^`\3\2\2\2_]\3\2\2\2`a\7,\2\2ab\7\61\2\2bc\3\2\2\2cd\b\20\2\2d \3\2\2"+
		"\2ef\7\61\2\2fg\7\61\2\2gk\3\2\2\2hj\n\6\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2"+
		"\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\b\21\3\2o\"\3\2\2\2pr\t\7\2\2qp\3"+
		"\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\b\22\4\2v$\3\2\2\2\t"+
		"\2FOU]ks";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}