// Generated from src\com\chronicweirdo\makeitso\grammar\wsp\Wsp.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.wsp;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WspLexer extends Lexer {
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
		"'folder'", "' '", "'file'", "'upload'", "'='", "';'", "STRING", "ID", 
		"NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "STRING", "ID", "NUMBER", 
		"BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};


	public WspLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Wsp.g4"; }

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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\16i\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\7\b\67\n\b"+
		"\f\b\16\b:\13\b\3\b\3\b\3\t\3\t\7\t@\n\t\f\t\16\tC\13\t\3\n\6\nF\n\n\r"+
		"\n\16\nG\3\13\3\13\3\13\3\13\7\13N\n\13\f\13\16\13Q\13\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\\\n\f\f\f\16\f_\13\f\3\f\3\f\3\r\6\r"+
		"d\n\r\r\r\16\re\3\r\3\r\3O\16\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17"+
		"\t\1\21\n\1\23\13\1\25\f\2\27\r\3\31\16\4\3\2\b\3\2$$\4\2C\\c|\6\2\62"+
		";C\\aac|\4\2\60\60\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"n\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3"+
		"\33\3\2\2\2\5\"\3\2\2\2\7$\3\2\2\2\t)\3\2\2\2\13\60\3\2\2\2\r\62\3\2\2"+
		"\2\17\64\3\2\2\2\21=\3\2\2\2\23E\3\2\2\2\25I\3\2\2\2\27W\3\2\2\2\31c\3"+
		"\2\2\2\33\34\7h\2\2\34\35\7q\2\2\35\36\7n\2\2\36\37\7f\2\2\37 \7g\2\2"+
		" !\7t\2\2!\4\3\2\2\2\"#\7\"\2\2#\6\3\2\2\2$%\7h\2\2%&\7k\2\2&\'\7n\2\2"+
		"\'(\7g\2\2(\b\3\2\2\2)*\7w\2\2*+\7r\2\2+,\7n\2\2,-\7q\2\2-.\7c\2\2./\7"+
		"f\2\2/\n\3\2\2\2\60\61\7?\2\2\61\f\3\2\2\2\62\63\7=\2\2\63\16\3\2\2\2"+
		"\648\7$\2\2\65\67\n\2\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2"+
		"\2\29;\3\2\2\2:8\3\2\2\2;<\7$\2\2<\20\3\2\2\2=A\t\3\2\2>@\t\4\2\2?>\3"+
		"\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\22\3\2\2\2CA\3\2\2\2DF\t\5\2\2E"+
		"D\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\24\3\2\2\2IJ\7\61\2\2JK\7,\2"+
		"\2KO\3\2\2\2LN\13\2\2\2ML\3\2\2\2NQ\3\2\2\2OP\3\2\2\2OM\3\2\2\2PR\3\2"+
		"\2\2QO\3\2\2\2RS\7,\2\2ST\7\61\2\2TU\3\2\2\2UV\b\13\2\2V\26\3\2\2\2WX"+
		"\7\61\2\2XY\7\61\2\2Y]\3\2\2\2Z\\\n\6\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2"+
		"\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\b\f\3\2a\30\3\2\2\2bd\t\7\2\2cb\3\2"+
		"\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\b\r\4\2h\32\3\2\2\2\t\2"+
		"8AGO]e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}