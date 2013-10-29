// Generated from src/com/chronicweirdo/jon/grammar/Jon.g4 by ANTLR 4.1

package com.chronicweirdo.jon.grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JonLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		TRUE=10, FALSE=11, STRING=12, ID=13, NUMBER=14, WS=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "'{'", "'.'", "')'", "','", "'['", "'('", "':'", "'}'", "'true'", 
		"'false'", "STRING", "ID", "NUMBER", "WS"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"TRUE", "FALSE", "STRING", "ID", "NUMBER", "WS"
	};


	public JonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Jon.g4"; }

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
		case 0: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\21k\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\rA\n\r\f\r\16\rD\13\r\3\r\3"+
		"\r\3\r\7\rI\n\r\f\r\16\rL\13\r\3\r\5\rO\n\r\3\16\3\16\7\16S\n\16\f\16"+
		"\16\16V\13\16\3\17\6\17Y\n\17\r\17\16\17Z\3\17\3\17\6\17_\n\17\r\17\16"+
		"\17`\5\17c\n\17\3\20\6\20f\n\20\r\20\16\20g\3\20\3\20\2\21\3\3\1\5\4\1"+
		"\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1"+
		"\33\17\1\35\20\1\37\21\2\3\2\7\3\2$$\4\2))^^\4\2C\\c|\6\2\62;C\\aac|\5"+
		"\2\13\f\17\17\"\"r\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3"+
		"!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13)\3\2\2\2\r+\3\2\2\2\17"+
		"-\3\2\2\2\21/\3\2\2\2\23\61\3\2\2\2\25\63\3\2\2\2\278\3\2\2\2\31N\3\2"+
		"\2\2\33P\3\2\2\2\35X\3\2\2\2\37e\3\2\2\2!\"\7_\2\2\"\4\3\2\2\2#$\7}\2"+
		"\2$\6\3\2\2\2%&\7\60\2\2&\b\3\2\2\2\'(\7+\2\2(\n\3\2\2\2)*\7.\2\2*\f\3"+
		"\2\2\2+,\7]\2\2,\16\3\2\2\2-.\7*\2\2.\20\3\2\2\2/\60\7<\2\2\60\22\3\2"+
		"\2\2\61\62\7\177\2\2\62\24\3\2\2\2\63\64\7v\2\2\64\65\7t\2\2\65\66\7w"+
		"\2\2\66\67\7g\2\2\67\26\3\2\2\289\7h\2\29:\7c\2\2:;\7n\2\2;<\7u\2\2<="+
		"\7g\2\2=\30\3\2\2\2>B\7$\2\2?A\n\2\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2B"+
		"C\3\2\2\2CE\3\2\2\2DB\3\2\2\2EO\7$\2\2FJ\7)\2\2GI\n\3\2\2HG\3\2\2\2IL"+
		"\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MO\7)\2\2N>\3\2\2\2NF"+
		"\3\2\2\2O\32\3\2\2\2PT\t\4\2\2QS\t\5\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2"+
		"TU\3\2\2\2U\34\3\2\2\2VT\3\2\2\2WY\4\62;\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2"+
		"\2Z[\3\2\2\2[b\3\2\2\2\\^\7\60\2\2]_\4\62;\2^]\3\2\2\2_`\3\2\2\2`^\3\2"+
		"\2\2`a\3\2\2\2ac\3\2\2\2b\\\3\2\2\2bc\3\2\2\2c\36\3\2\2\2df\t\6\2\2ed"+
		"\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\b\20\2\2j \3\2\2\2"+
		"\13\2BJNTZ`bg";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}