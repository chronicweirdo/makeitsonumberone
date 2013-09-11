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
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, STRING=9, 
		ID=10, NUMBER=11, BLOCK_COMMENT=12, LINE_COMMENT=13, WS=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "'.'", "','", "'['", "'print'", "':'", "'='", "';'", "STRING", 
		"ID", "NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "STRING", 
		"ID", "NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
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
		case 11: BLOCK_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 12: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 13: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\20h\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\7\n\66\n\n"+
		"\f\n\16\n9\13\n\3\n\3\n\3\13\3\13\7\13?\n\13\f\13\16\13B\13\13\3\f\6\f"+
		"E\n\f\r\f\16\fF\3\r\3\r\3\r\3\r\7\rM\n\r\f\r\16\rP\13\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\7\16[\n\16\f\16\16\16^\13\16\3\16\3\16\3\17"+
		"\6\17c\n\17\r\17\16\17d\3\17\3\17\3N\20\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1"+
		"\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\2\33\17\3\35\20\4\3\2"+
		"\b\3\2$$\4\2C\\c|\6\2\62;C\\aac|\4\2\60\60\62;\4\2\f\f\17\17\5\2\13\f"+
		"\17\17\"\"m\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2"+
		"\2\7#\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r-\3\2\2\2\17/\3\2\2\2\21\61\3\2"+
		"\2\2\23\63\3\2\2\2\25<\3\2\2\2\27D\3\2\2\2\31H\3\2\2\2\33V\3\2\2\2\35"+
		"b\3\2\2\2\37 \7_\2\2 \4\3\2\2\2!\"\7\60\2\2\"\6\3\2\2\2#$\7.\2\2$\b\3"+
		"\2\2\2%&\7]\2\2&\n\3\2\2\2\'(\7r\2\2()\7t\2\2)*\7k\2\2*+\7p\2\2+,\7v\2"+
		"\2,\f\3\2\2\2-.\7<\2\2.\16\3\2\2\2/\60\7?\2\2\60\20\3\2\2\2\61\62\7=\2"+
		"\2\62\22\3\2\2\2\63\67\7$\2\2\64\66\n\2\2\2\65\64\3\2\2\2\669\3\2\2\2"+
		"\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:;\7$\2\2;\24\3\2\2\2"+
		"<@\t\3\2\2=?\t\4\2\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\26\3\2\2"+
		"\2B@\3\2\2\2CE\t\5\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\30\3\2"+
		"\2\2HI\7\61\2\2IJ\7,\2\2JN\3\2\2\2KM\13\2\2\2LK\3\2\2\2MP\3\2\2\2NO\3"+
		"\2\2\2NL\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7,\2\2RS\7\61\2\2ST\3\2\2\2TU\b"+
		"\r\2\2U\32\3\2\2\2VW\7\61\2\2WX\7\61\2\2X\\\3\2\2\2Y[\n\6\2\2ZY\3\2\2"+
		"\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\b\16\3\2`\34"+
		"\3\2\2\2ac\t\7\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2f"+
		"g\b\17\4\2g\36\3\2\2\2\t\2\67@FN\\d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}