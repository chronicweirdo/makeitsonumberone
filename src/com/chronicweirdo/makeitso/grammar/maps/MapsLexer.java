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
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, STRING=7, ID=8, NUMBER=9, 
		BLOCK_COMMENT=10, LINE_COMMENT=11, WS=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "','", "'['", "':'", "';'", "'|'", "STRING", "ID", "NUMBER", "BLOCK_COMMENT", 
		"LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "STRING", "ID", "NUMBER", 
		"BLOCK_COMMENT", "LINE_COMMENT", "WS"
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
		case 9: BLOCK_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 10: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 11: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\16\\\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\7\b*\n\b\f\b\16\b-\13\b\3\b\3\b\3\t\3\t\7\t\63\n\t\f\t\16\t\66"+
		"\13\t\3\n\6\n9\n\n\r\n\16\n:\3\13\3\13\3\13\3\13\7\13A\n\13\f\13\16\13"+
		"D\13\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\fO\n\f\f\f\16\fR\13"+
		"\f\3\f\3\f\3\r\6\rW\n\r\r\r\16\rX\3\r\3\r\3B\16\3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\2\27\r\3\31\16\4\3\2\b\3\2"+
		"$$\4\2C\\c|\6\2\62;C\\aac|\4\2\60\60\62;\4\2\f\f\17\17\5\2\13\f\17\17"+
		"\"\"a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2"+
		"\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\13"+
		"#\3\2\2\2\r%\3\2\2\2\17\'\3\2\2\2\21\60\3\2\2\2\238\3\2\2\2\25<\3\2\2"+
		"\2\27J\3\2\2\2\31V\3\2\2\2\33\34\7_\2\2\34\4\3\2\2\2\35\36\7.\2\2\36\6"+
		"\3\2\2\2\37 \7]\2\2 \b\3\2\2\2!\"\7<\2\2\"\n\3\2\2\2#$\7=\2\2$\f\3\2\2"+
		"\2%&\7~\2\2&\16\3\2\2\2\'+\7$\2\2(*\n\2\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2"+
		"\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7$\2\2/\20\3\2\2\2\60\64\t\3\2\2"+
		"\61\63\t\4\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2"+
		"\65\22\3\2\2\2\66\64\3\2\2\2\679\t\5\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2"+
		"\2:;\3\2\2\2;\24\3\2\2\2<=\7\61\2\2=>\7,\2\2>B\3\2\2\2?A\13\2\2\2@?\3"+
		"\2\2\2AD\3\2\2\2BC\3\2\2\2B@\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7,\2\2FG\7"+
		"\61\2\2GH\3\2\2\2HI\b\13\2\2I\26\3\2\2\2JK\7\61\2\2KL\7\61\2\2LP\3\2\2"+
		"\2MO\n\6\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2"+
		"\2ST\b\f\3\2T\30\3\2\2\2UW\t\7\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2"+
		"\2\2YZ\3\2\2\2Z[\b\r\4\2[\32\3\2\2\2\t\2+\64:BPX";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}