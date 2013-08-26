// Generated from /Users/cacovean/Documents/workspace/makeitso/src/com/chronicweirdo/makeitso/grammar/wsp/Wsp.g4 by ANTLR 4.1

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
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, STRING=6, ID=7, NUMBER=8, BLOCK_COMMENT=9, 
		LINE_COMMENT=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'folder'", "'file'", "'upload'", "'='", "';'", "STRING", "ID", "NUMBER", 
		"BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "STRING", "ID", "NUMBER", "BLOCK_COMMENT", 
		"LINE_COMMENT", "WS"
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\re\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\7\7\63\n\7\f\7\16\7\66\13\7"+
		"\3\7\3\7\3\b\3\b\7\b<\n\b\f\b\16\b?\13\b\3\t\6\tB\n\t\r\t\16\tC\3\n\3"+
		"\n\3\n\3\n\7\nJ\n\n\f\n\16\nM\13\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\7\13X\n\13\f\13\16\13[\13\13\3\13\3\13\3\f\6\f`\n\f\r\f\16\fa\3"+
		"\f\3\f\3K\r\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\2"+
		"\25\f\3\27\r\4\3\2\b\3\2$$\4\2C\\c|\6\2\62;C\\aac|\4\2\60\60\62;\4\2\f"+
		"\f\17\17\5\2\13\f\17\17\"\"j\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5 \3\2\2\2\7%\3\2\2\2\t,\3\2\2"+
		"\2\13.\3\2\2\2\r\60\3\2\2\2\179\3\2\2\2\21A\3\2\2\2\23E\3\2\2\2\25S\3"+
		"\2\2\2\27_\3\2\2\2\31\32\7h\2\2\32\33\7q\2\2\33\34\7n\2\2\34\35\7f\2\2"+
		"\35\36\7g\2\2\36\37\7t\2\2\37\4\3\2\2\2 !\7h\2\2!\"\7k\2\2\"#\7n\2\2#"+
		"$\7g\2\2$\6\3\2\2\2%&\7w\2\2&\'\7r\2\2\'(\7n\2\2()\7q\2\2)*\7c\2\2*+\7"+
		"f\2\2+\b\3\2\2\2,-\7?\2\2-\n\3\2\2\2./\7=\2\2/\f\3\2\2\2\60\64\7$\2\2"+
		"\61\63\n\2\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2"+
		"\65\67\3\2\2\2\66\64\3\2\2\2\678\7$\2\28\16\3\2\2\29=\t\3\2\2:<\t\4\2"+
		"\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\20\3\2\2\2?=\3\2\2\2@B\t\5"+
		"\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\22\3\2\2\2EF\7\61\2\2FG"+
		"\7,\2\2GK\3\2\2\2HJ\13\2\2\2IH\3\2\2\2JM\3\2\2\2KL\3\2\2\2KI\3\2\2\2L"+
		"N\3\2\2\2MK\3\2\2\2NO\7,\2\2OP\7\61\2\2PQ\3\2\2\2QR\b\n\2\2R\24\3\2\2"+
		"\2ST\7\61\2\2TU\7\61\2\2UY\3\2\2\2VX\n\6\2\2WV\3\2\2\2X[\3\2\2\2YW\3\2"+
		"\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\b\13\3\2]\26\3\2\2\2^`\t\7\2\2"+
		"_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\b\f\4\2d\30\3\2\2"+
		"\2\t\2\64=CKYa";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}