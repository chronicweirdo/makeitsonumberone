// Generated from src/com/chronicweirdo/makeitso/grammar/wiki/Wiki.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.wiki;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WikiLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HASH=1, COLON=2, LT=3, GT=4, BEND=5, HTTP=6, ID=7, NUMBER=8, SPACE=9, 
		WORD=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'#'", "':'", "'<'", "'>'", "'</>'", "HTTP", "ID", "NUMBER", "SPACE", 
		"WORD"
	};
	public static final String[] ruleNames = {
		"HASH", "COLON", "LT", "GT", "BEND", "HTTP", "ID", "NUMBER", "SPACE", 
		"WORD"
	};


	public WikiLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Wiki.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\fR\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\63\n\7\3\b\3\b\7\b\67\n"+
		"\b\f\b\16\b:\13\b\3\t\6\t=\n\t\r\t\16\t>\3\t\3\t\6\tC\n\t\r\t\16\tD\5"+
		"\tG\n\t\3\n\6\nJ\n\n\r\n\16\nK\3\13\6\13O\n\13\r\13\16\13P\2\f\3\3\1\5"+
		"\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\3\2\6\4\2C"+
		"\\c|\7\2\60\60\62;C\\aac|\5\2\13\f\17\17\"\"\t\2\13\f\17\17\"\"%%<<>>"+
		"@@X\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2"+
		"\2\5\31\3\2\2\2\7\33\3\2\2\2\t\35\3\2\2\2\13\37\3\2\2\2\r\62\3\2\2\2\17"+
		"\64\3\2\2\2\21<\3\2\2\2\23I\3\2\2\2\25N\3\2\2\2\27\30\7%\2\2\30\4\3\2"+
		"\2\2\31\32\7<\2\2\32\6\3\2\2\2\33\34\7>\2\2\34\b\3\2\2\2\35\36\7@\2\2"+
		"\36\n\3\2\2\2\37 \7>\2\2 !\7\61\2\2!\"\7@\2\2\"\f\3\2\2\2#$\7j\2\2$%\7"+
		"v\2\2%&\7v\2\2&\'\7r\2\2\'(\7<\2\2()\7\61\2\2)\63\7\61\2\2*+\7j\2\2+,"+
		"\7v\2\2,-\7v\2\2-.\7r\2\2./\7u\2\2/\60\7<\2\2\60\61\7\61\2\2\61\63\7\61"+
		"\2\2\62#\3\2\2\2\62*\3\2\2\2\63\16\3\2\2\2\648\t\2\2\2\65\67\t\3\2\2\66"+
		"\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\20\3\2\2\2:8\3\2\2\2;="+
		"\4\62;\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?F\3\2\2\2@B\7\60\2\2"+
		"AC\4\62;\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2F@\3\2\2\2"+
		"FG\3\2\2\2G\22\3\2\2\2HJ\t\4\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2"+
		"\2L\24\3\2\2\2MO\n\5\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\26\3"+
		"\2\2\2\n\2\628>DFKP";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}