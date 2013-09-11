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
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, STRING=6, ID=7, NUMBER=8, BLOCK_COMMENT=9, 
		LINE_COMMENT=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "','", "'['", "':'", "';'", "STRING", "ID", "NUMBER", "BLOCK_COMMENT", 
		"LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "STRING", "ID", "NUMBER", "BLOCK_COMMENT", 
		"LINE_COMMENT", "WS"
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
		case 8: BLOCK_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 9: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 10: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\rX\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\7\7&\n\7\f"+
		"\7\16\7)\13\7\3\7\3\7\3\b\3\b\7\b/\n\b\f\b\16\b\62\13\b\3\t\6\t\65\n\t"+
		"\r\t\16\t\66\3\n\3\n\3\n\3\n\7\n=\n\n\f\n\16\n@\13\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\7\13K\n\13\f\13\16\13N\13\13\3\13\3\13\3\f\6\f"+
		"S\n\f\r\f\16\fT\3\f\3\f\3>\r\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t"+
		"\1\21\n\1\23\13\2\25\f\3\27\r\4\3\2\b\3\2$$\4\2C\\c|\6\2\62;C\\aac|\4"+
		"\2\60\60\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"]\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2"+
		"\2\7\35\3\2\2\2\t\37\3\2\2\2\13!\3\2\2\2\r#\3\2\2\2\17,\3\2\2\2\21\64"+
		"\3\2\2\2\238\3\2\2\2\25F\3\2\2\2\27R\3\2\2\2\31\32\7_\2\2\32\4\3\2\2\2"+
		"\33\34\7.\2\2\34\6\3\2\2\2\35\36\7]\2\2\36\b\3\2\2\2\37 \7<\2\2 \n\3\2"+
		"\2\2!\"\7=\2\2\"\f\3\2\2\2#\'\7$\2\2$&\n\2\2\2%$\3\2\2\2&)\3\2\2\2\'%"+
		"\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\7$\2\2+\16\3\2\2\2,\60\t\3"+
		"\2\2-/\t\4\2\2.-\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\20\3"+
		"\2\2\2\62\60\3\2\2\2\63\65\t\5\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66\64\3"+
		"\2\2\2\66\67\3\2\2\2\67\22\3\2\2\289\7\61\2\29:\7,\2\2:>\3\2\2\2;=\13"+
		"\2\2\2<;\3\2\2\2=@\3\2\2\2>?\3\2\2\2><\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\7"+
		",\2\2BC\7\61\2\2CD\3\2\2\2DE\b\n\2\2E\24\3\2\2\2FG\7\61\2\2GH\7\61\2\2"+
		"HL\3\2\2\2IK\n\6\2\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2"+
		"NL\3\2\2\2OP\b\13\3\2P\26\3\2\2\2QS\t\7\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2"+
		"\2\2TU\3\2\2\2UV\3\2\2\2VW\b\f\4\2W\30\3\2\2\2\t\2\'\60\66>LT";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}