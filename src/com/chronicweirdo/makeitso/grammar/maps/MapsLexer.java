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
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, STRING=11, ID=12, NUMBER=13, BLOCK_COMMENT=14, LINE_COMMENT=15, 
		WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "')'", "'.'", "','", "'['", "'('", "':'", "'='", "';'", "'|'", 
		"STRING", "ID", "NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "STRING", "ID", "NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
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
		case 13: BLOCK_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 14: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 15: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\22}\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\7\f:\n\f\f\f\16\f=\13\f\3\f\3\f\3\f\7\fB\n\f\f\f\16\fE\13"+
		"\f\3\f\5\fH\n\f\3\r\3\r\7\rL\n\r\f\r\16\rO\13\r\3\16\6\16R\n\16\r\16\16"+
		"\16S\3\16\3\16\6\16X\n\16\r\16\16\16Y\5\16\\\n\16\3\17\3\17\3\17\3\17"+
		"\7\17b\n\17\f\17\16\17e\13\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\7\20p\n\20\f\20\16\20s\13\20\3\20\3\20\3\21\6\21x\n\21\r\21\16\21"+
		"y\3\21\3\21\3c\22\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23"+
		"\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\2\37\21\3!\22\4\3\2\b\3\2$$"+
		"\4\2))^^\4\2C\\c|\6\2\62;C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u0086"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2"+
		"\2\2\5%\3\2\2\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r-\3\2\2\2\17/\3\2"+
		"\2\2\21\61\3\2\2\2\23\63\3\2\2\2\25\65\3\2\2\2\27G\3\2\2\2\31I\3\2\2\2"+
		"\33Q\3\2\2\2\35]\3\2\2\2\37k\3\2\2\2!w\3\2\2\2#$\7_\2\2$\4\3\2\2\2%&\7"+
		"+\2\2&\6\3\2\2\2\'(\7\60\2\2(\b\3\2\2\2)*\7.\2\2*\n\3\2\2\2+,\7]\2\2,"+
		"\f\3\2\2\2-.\7*\2\2.\16\3\2\2\2/\60\7<\2\2\60\20\3\2\2\2\61\62\7?\2\2"+
		"\62\22\3\2\2\2\63\64\7=\2\2\64\24\3\2\2\2\65\66\7~\2\2\66\26\3\2\2\2\67"+
		";\7$\2\28:\n\2\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2="+
		";\3\2\2\2>H\7$\2\2?C\7)\2\2@B\n\3\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD"+
		"\3\2\2\2DF\3\2\2\2EC\3\2\2\2FH\7)\2\2G\67\3\2\2\2G?\3\2\2\2H\30\3\2\2"+
		"\2IM\t\4\2\2JL\t\5\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\32\3\2"+
		"\2\2OM\3\2\2\2PR\4\62;\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T[\3\2"+
		"\2\2UW\7\60\2\2VX\4\62;\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3"+
		"\2\2\2[U\3\2\2\2[\\\3\2\2\2\\\34\3\2\2\2]^\7\61\2\2^_\7,\2\2_c\3\2\2\2"+
		"`b\13\2\2\2a`\3\2\2\2be\3\2\2\2cd\3\2\2\2ca\3\2\2\2df\3\2\2\2ec\3\2\2"+
		"\2fg\7,\2\2gh\7\61\2\2hi\3\2\2\2ij\b\17\2\2j\36\3\2\2\2kl\7\61\2\2lm\7"+
		"\61\2\2mq\3\2\2\2np\n\6\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt"+
		"\3\2\2\2sq\3\2\2\2tu\b\20\3\2u \3\2\2\2vx\t\7\2\2wv\3\2\2\2xy\3\2\2\2"+
		"yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\b\21\4\2|\"\3\2\2\2\r\2;CGMSY[cqy";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}