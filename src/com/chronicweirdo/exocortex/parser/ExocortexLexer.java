// Generated from src\com\chronicweirdo\exocortex\parser\Exocortex.g4 by ANTLR 4.1

package com.chronicweirdo.exocortex.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExocortexLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, BOOLEAN=11, STRING=12, ID=13, NUMBER=14, WS=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "'[]'", "'[:]'", "'.'", "','", "'['", "':'", "'='", "'add'", "';'", 
		"BOOLEAN", "STRING", "ID", "NUMBER", "WS"
	};
	public static final String[] ruleNames = {
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "BOOLEAN", "STRING", "ID", "NUMBER", "WS"
	};


	public ExocortexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Exocortex.g4"; }

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
		case 14: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\21o\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fD\n\f\3\r\3\r\7\r"+
		"H\n\r\f\r\16\rK\13\r\3\r\3\r\3\16\3\16\7\16Q\n\16\f\16\16\16T\13\16\3"+
		"\17\7\17W\n\17\f\17\16\17Z\13\17\3\17\3\17\6\17^\n\17\r\17\16\17_\3\17"+
		"\6\17c\n\17\r\17\16\17d\5\17g\n\17\3\20\6\20j\n\20\r\20\16\20k\3\20\3"+
		"\20\2\21\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25"+
		"\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\2\3\2\6\3\2$$\5\2C\\aac|\6\2"+
		"\62;C\\aac|\5\2\13\f\17\17\"\"v\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7&\3\2\2\2\t*\3\2\2\2\13,\3\2\2\2"+
		"\r.\3\2\2\2\17\60\3\2\2\2\21\62\3\2\2\2\23\64\3\2\2\2\258\3\2\2\2\27C"+
		"\3\2\2\2\31E\3\2\2\2\33N\3\2\2\2\35f\3\2\2\2\37i\3\2\2\2!\"\7_\2\2\"\4"+
		"\3\2\2\2#$\7]\2\2$%\7_\2\2%\6\3\2\2\2&\'\7]\2\2\'(\7<\2\2()\7_\2\2)\b"+
		"\3\2\2\2*+\7\60\2\2+\n\3\2\2\2,-\7.\2\2-\f\3\2\2\2./\7]\2\2/\16\3\2\2"+
		"\2\60\61\7<\2\2\61\20\3\2\2\2\62\63\7?\2\2\63\22\3\2\2\2\64\65\7c\2\2"+
		"\65\66\7f\2\2\66\67\7f\2\2\67\24\3\2\2\289\7=\2\29\26\3\2\2\2:;\7v\2\2"+
		";<\7t\2\2<=\7w\2\2=D\7g\2\2>?\7h\2\2?@\7c\2\2@A\7n\2\2AB\7u\2\2BD\7g\2"+
		"\2C:\3\2\2\2C>\3\2\2\2D\30\3\2\2\2EI\7$\2\2FH\n\2\2\2GF\3\2\2\2HK\3\2"+
		"\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7$\2\2M\32\3\2\2\2NR\t"+
		"\3\2\2OQ\t\4\2\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\34\3\2\2\2T"+
		"R\3\2\2\2UW\4\62;\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2"+
		"ZX\3\2\2\2[]\7\60\2\2\\^\4\62;\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2"+
		"\2\2`g\3\2\2\2ac\4\62;\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2"+
		"\2\2fX\3\2\2\2fb\3\2\2\2g\36\3\2\2\2hj\t\5\2\2ih\3\2\2\2jk\3\2\2\2ki\3"+
		"\2\2\2kl\3\2\2\2lm\3\2\2\2mn\b\20\2\2n \3\2\2\2\13\2CIRX_dfk";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}