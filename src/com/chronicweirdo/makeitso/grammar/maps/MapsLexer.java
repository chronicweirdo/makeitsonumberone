// Generated from src\com\chronicweirdo\makeitso\grammar\maps\Maps.g4 by ANTLR 4.1

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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, STRING=8, ID=9, 
		NUMBER=10, BLOCK_COMMENT=11, LINE_COMMENT=12, WS=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "','", "'_'", "'['", "':'", "';'", "'|'", "STRING", "ID", "NUMBER", 
		"BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "STRING", "ID", 
		"NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
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
		case 10: BLOCK_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 11: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 12: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\17`\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\7\t.\n\t\f\t\16\t\61\13\t\3\t\3\t\3\n\3\n\7\n"+
		"\67\n\n\f\n\16\n:\13\n\3\13\6\13=\n\13\r\13\16\13>\3\f\3\f\3\f\3\f\7\f"+
		"E\n\f\f\f\16\fH\13\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\rS\n\r\f\r"+
		"\16\rV\13\r\3\r\3\r\3\16\6\16[\n\16\r\16\16\16\\\3\16\3\16\3F\17\3\3\1"+
		"\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\2\31"+
		"\16\3\33\17\4\3\2\b\3\2$$\4\2C\\c|\6\2\62;C\\aac|\4\2\60\60\62;\4\2\f"+
		"\f\17\17\5\2\13\f\17\17\"\"e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37"+
		"\3\2\2\2\7!\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r\'\3\2\2\2\17)\3\2\2\2\21"+
		"+\3\2\2\2\23\64\3\2\2\2\25<\3\2\2\2\27@\3\2\2\2\31N\3\2\2\2\33Z\3\2\2"+
		"\2\35\36\7_\2\2\36\4\3\2\2\2\37 \7.\2\2 \6\3\2\2\2!\"\7a\2\2\"\b\3\2\2"+
		"\2#$\7]\2\2$\n\3\2\2\2%&\7<\2\2&\f\3\2\2\2\'(\7=\2\2(\16\3\2\2\2)*\7~"+
		"\2\2*\20\3\2\2\2+/\7$\2\2,.\n\2\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60"+
		"\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7$\2\2\63\22\3\2\2\2\648\t\3"+
		"\2\2\65\67\t\4\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\24"+
		"\3\2\2\2:8\3\2\2\2;=\t\5\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?"+
		"\26\3\2\2\2@A\7\61\2\2AB\7,\2\2BF\3\2\2\2CE\13\2\2\2DC\3\2\2\2EH\3\2\2"+
		"\2FG\3\2\2\2FD\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7,\2\2JK\7\61\2\2KL\3\2\2"+
		"\2LM\b\f\2\2M\30\3\2\2\2NO\7\61\2\2OP\7\61\2\2PT\3\2\2\2QS\n\6\2\2RQ\3"+
		"\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\b\r\3\2X\32"+
		"\3\2\2\2Y[\t\7\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2"+
		"\2^_\b\16\4\2_\34\3\2\2\2\t\2/8>FT\\";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}