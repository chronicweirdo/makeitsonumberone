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
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		STRING=10, ID=11, NUMBER=12, BLOCK_COMMENT=13, LINE_COMMENT=14, WS=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "'.'", "')'", "','", "'['", "':'", "'('", "'='", "';'", "STRING", 
		"ID", "NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"STRING", "ID", "NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
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
		case 12: BLOCK_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 13: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 14: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\21y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\7\13\66"+
		"\n\13\f\13\16\139\13\13\3\13\3\13\3\13\7\13>\n\13\f\13\16\13A\13\13\3"+
		"\13\5\13D\n\13\3\f\3\f\7\fH\n\f\f\f\16\fK\13\f\3\r\6\rN\n\r\r\r\16\rO"+
		"\3\r\3\r\6\rT\n\r\r\r\16\rU\5\rX\n\r\3\16\3\16\3\16\3\16\7\16^\n\16\f"+
		"\16\16\16a\13\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\7\17l\n"+
		"\17\f\17\16\17o\13\17\3\17\3\17\3\20\6\20t\n\20\r\20\16\20u\3\20\3\20"+
		"\3_\21\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f"+
		"\1\27\r\1\31\16\1\33\17\2\35\20\3\37\21\4\3\2\b\3\2$$\4\2))^^\4\2C\\c"+
		"|\6\2\62;C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u0082\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2"+
		"\t\'\3\2\2\2\13)\3\2\2\2\r+\3\2\2\2\17-\3\2\2\2\21/\3\2\2\2\23\61\3\2"+
		"\2\2\25C\3\2\2\2\27E\3\2\2\2\31M\3\2\2\2\33Y\3\2\2\2\35g\3\2\2\2\37s\3"+
		"\2\2\2!\"\7_\2\2\"\4\3\2\2\2#$\7\60\2\2$\6\3\2\2\2%&\7+\2\2&\b\3\2\2\2"+
		"\'(\7.\2\2(\n\3\2\2\2)*\7]\2\2*\f\3\2\2\2+,\7<\2\2,\16\3\2\2\2-.\7*\2"+
		"\2.\20\3\2\2\2/\60\7?\2\2\60\22\3\2\2\2\61\62\7=\2\2\62\24\3\2\2\2\63"+
		"\67\7$\2\2\64\66\n\2\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3"+
		"\2\2\28:\3\2\2\29\67\3\2\2\2:D\7$\2\2;?\7)\2\2<>\n\3\2\2=<\3\2\2\2>A\3"+
		"\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BD\7)\2\2C\63\3\2\2\2C;"+
		"\3\2\2\2D\26\3\2\2\2EI\t\4\2\2FH\t\5\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2J\30\3\2\2\2KI\3\2\2\2LN\4\62;\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2"+
		"\2OP\3\2\2\2PW\3\2\2\2QS\7\60\2\2RT\4\62;\2SR\3\2\2\2TU\3\2\2\2US\3\2"+
		"\2\2UV\3\2\2\2VX\3\2\2\2WQ\3\2\2\2WX\3\2\2\2X\32\3\2\2\2YZ\7\61\2\2Z["+
		"\7,\2\2[_\3\2\2\2\\^\13\2\2\2]\\\3\2\2\2^a\3\2\2\2_`\3\2\2\2_]\3\2\2\2"+
		"`b\3\2\2\2a_\3\2\2\2bc\7,\2\2cd\7\61\2\2de\3\2\2\2ef\b\16\2\2f\34\3\2"+
		"\2\2gh\7\61\2\2hi\7\61\2\2im\3\2\2\2jl\n\6\2\2kj\3\2\2\2lo\3\2\2\2mk\3"+
		"\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\b\17\3\2q\36\3\2\2\2rt\t\7\2\2"+
		"sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\b\20\4\2x \3\2\2"+
		"\2\r\2\67?CIOUW_mu";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}