// Generated from src/com/chronicweirdo/exocortex/parser/Exocortex.g4 by ANTLR 4.1

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
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, STRING=6, ID=7, NUMBER=8, WS=9, 
		BOOLEAN=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'[]'", "']'", "','", "'['", "':'", "STRING", "ID", "NUMBER", "WS", "BOOLEAN"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "STRING", "ID", "NUMBER", "WS", 
		"BOOLEAN"
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
		case 8: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\fP\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\6"+
		"\b(\n\b\r\b\16\b)\3\t\7\t-\n\t\f\t\16\t\60\13\t\3\t\3\t\6\t\64\n\t\r\t"+
		"\16\t\65\3\t\6\t9\n\t\r\t\16\t:\5\t=\n\t\3\n\6\n@\n\n\r\n\16\nA\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13O\n\13\2\f\3\3\1\5"+
		"\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\2\25\f\1\3\2\5\3\2$"+
		"$\5\2C\\aac|\5\2\13\f\17\17\"\"V\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\32\3\2\2\2\7\34\3\2\2\2\t\36\3\2\2\2"+
		"\13 \3\2\2\2\r\"\3\2\2\2\17\'\3\2\2\2\21<\3\2\2\2\23?\3\2\2\2\25N\3\2"+
		"\2\2\27\30\7]\2\2\30\31\7_\2\2\31\4\3\2\2\2\32\33\7_\2\2\33\6\3\2\2\2"+
		"\34\35\7.\2\2\35\b\3\2\2\2\36\37\7]\2\2\37\n\3\2\2\2 !\7<\2\2!\f\3\2\2"+
		"\2\"#\7$\2\2#$\n\2\2\2$%\7$\2\2%\16\3\2\2\2&(\t\3\2\2\'&\3\2\2\2()\3\2"+
		"\2\2)\'\3\2\2\2)*\3\2\2\2*\20\3\2\2\2+-\4\62;\2,+\3\2\2\2-\60\3\2\2\2"+
		".,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\63\7\60\2\2\62\64\4\62"+
		";\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66=\3\2\2"+
		"\2\679\4\62;\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<.\3"+
		"\2\2\2<8\3\2\2\2=\22\3\2\2\2>@\t\4\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2A"+
		"B\3\2\2\2BC\3\2\2\2CD\b\n\2\2D\24\3\2\2\2EF\7v\2\2FG\7t\2\2GH\7w\2\2H"+
		"O\7g\2\2IJ\7h\2\2JK\7c\2\2KL\7n\2\2LM\7u\2\2MO\7g\2\2NE\3\2\2\2NI\3\2"+
		"\2\2O\26\3\2\2\2\n\2).\65:<AN";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}