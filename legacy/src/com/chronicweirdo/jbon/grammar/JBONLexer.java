// Generated from src/com/chronicweirdo/jbon/grammar/JBON.g4 by ANTLR 4.1

package com.chronicweirdo.jbon.grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JBONLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, NULL=16, TRUE=17, 
		FALSE=18, STRING=19, CHAR=20, ID=21, FLOAT=22, INTEGER=23, HEXADECIMAL=24, 
		BINARY=25, WS=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "')'", "'.'", "','", "'D'", "'['", "':'", "'('", "'d'", "'f'", 
		"'l'", "'{'", "'F'", "'}'", "'L'", "'null'", "'true'", "'false'", "STRING", 
		"CHAR", "ID", "FLOAT", "INTEGER", "HEXADECIMAL", "BINARY", "WS"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NULL", "TRUE", "FALSE", 
		"STRING", "ESC", "UNICODE", "HEX", "CHAR", "ID", "FLOAT", "INTEGER", "HEXADECIMAL", 
		"BINARY", "WS"
	};


	public JBONLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JBON.g4"; }

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
		case 28: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\34\u00cd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\7\24o\n\24\f\24\16\24r\13\24\3\24\3\24\3\25\3\25\3\25\5\25y\n\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\7\30\u0085\n\30\f\30\16"+
		"\30\u0088\13\30\3\30\3\30\3\31\3\31\7\31\u008e\n\31\f\31\16\31\u0091\13"+
		"\31\3\32\5\32\u0094\n\32\3\32\6\32\u0097\n\32\r\32\16\32\u0098\3\32\3"+
		"\32\6\32\u009d\n\32\r\32\16\32\u009e\3\32\3\32\6\32\u00a3\n\32\r\32\16"+
		"\32\u00a4\5\32\u00a7\n\32\3\33\5\33\u00aa\n\33\3\33\6\33\u00ad\n\33\r"+
		"\33\16\33\u00ae\3\34\5\34\u00b2\n\34\3\34\3\34\3\34\3\34\6\34\u00b8\n"+
		"\34\r\34\16\34\u00b9\3\35\5\35\u00bd\n\35\3\35\3\35\3\35\3\35\6\35\u00c3"+
		"\n\35\r\35\16\35\u00c4\3\36\6\36\u00c8\n\36\r\36\16\36\u00c9\3\36\3\36"+
		"\2\37\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f"+
		"\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\2"+
		"\1+\2\1-\2\1/\26\1\61\27\1\63\30\1\65\31\1\67\32\19\33\1;\34\2\3\2\n\4"+
		"\2$$^^\13\2$$))\61\61^^ddhhppttvv\5\2\62;CHch\4\2))^^\4\2C\\c|\6\2\62"+
		";C\\aac|\4\2--//\5\2\13\f\17\17\"\"\u00da\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\tC\3\2\2\2\13E\3\2\2"+
		"\2\rG\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27Q\3\2"+
		"\2\2\31S\3\2\2\2\33U\3\2\2\2\35W\3\2\2\2\37Y\3\2\2\2![\3\2\2\2#`\3\2\2"+
		"\2%e\3\2\2\2\'k\3\2\2\2)u\3\2\2\2+z\3\2\2\2-\u0080\3\2\2\2/\u0082\3\2"+
		"\2\2\61\u008b\3\2\2\2\63\u0093\3\2\2\2\65\u00a9\3\2\2\2\67\u00b1\3\2\2"+
		"\29\u00bc\3\2\2\2;\u00c7\3\2\2\2=>\7_\2\2>\4\3\2\2\2?@\7+\2\2@\6\3\2\2"+
		"\2AB\7\60\2\2B\b\3\2\2\2CD\7.\2\2D\n\3\2\2\2EF\7F\2\2F\f\3\2\2\2GH\7]"+
		"\2\2H\16\3\2\2\2IJ\7<\2\2J\20\3\2\2\2KL\7*\2\2L\22\3\2\2\2MN\7f\2\2N\24"+
		"\3\2\2\2OP\7h\2\2P\26\3\2\2\2QR\7n\2\2R\30\3\2\2\2ST\7}\2\2T\32\3\2\2"+
		"\2UV\7H\2\2V\34\3\2\2\2WX\7\177\2\2X\36\3\2\2\2YZ\7N\2\2Z \3\2\2\2[\\"+
		"\7p\2\2\\]\7w\2\2]^\7n\2\2^_\7n\2\2_\"\3\2\2\2`a\7v\2\2ab\7t\2\2bc\7w"+
		"\2\2cd\7g\2\2d$\3\2\2\2ef\7h\2\2fg\7c\2\2gh\7n\2\2hi\7u\2\2ij\7g\2\2j"+
		"&\3\2\2\2kp\7$\2\2lo\5)\25\2mo\n\2\2\2nl\3\2\2\2nm\3\2\2\2or\3\2\2\2p"+
		"n\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\7$\2\2t(\3\2\2\2ux\7^\2\2vy"+
		"\t\3\2\2wy\5+\26\2xv\3\2\2\2xw\3\2\2\2y*\3\2\2\2z{\7w\2\2{|\5-\27\2|}"+
		"\5-\27\2}~\5-\27\2~\177\5-\27\2\177,\3\2\2\2\u0080\u0081\t\4\2\2\u0081"+
		".\3\2\2\2\u0082\u0086\7)\2\2\u0083\u0085\n\5\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7)\2\2\u008a\60\3\2\2\2\u008b\u008f"+
		"\t\6\2\2\u008c\u008e\t\7\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\62\3\2\2\2\u0091\u008f\3\2\2"+
		"\2\u0092\u0094\t\b\2\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096"+
		"\3\2\2\2\u0095\u0097\4\62;\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\7\60"+
		"\2\2\u009b\u009d\4\62;\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a6\3\2\2\2\u00a0\u00a2\7g"+
		"\2\2\u00a1\u00a3\4\62;\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a0\3\2"+
		"\2\2\u00a6\u00a7\3\2\2\2\u00a7\64\3\2\2\2\u00a8\u00aa\t\b\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00ad\4\62;\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\66\3\2\2\2\u00b0\u00b2\t\b\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\62\2\2\u00b4\u00b5\7z\2\2\u00b5"+
		"\u00b7\3\2\2\2\u00b6\u00b8\5-\27\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba8\3\2\2\2\u00bb\u00bd"+
		"\t\b\2\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bf\7\62\2\2\u00bf\u00c0\7d\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00c3\4\62"+
		"\63\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5:\3\2\2\2\u00c6\u00c8\t\t\2\2\u00c7\u00c6\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\u00cc\b\36\2\2\u00cc<\3\2\2\2\24\2npx\u0086\u008f\u0093"+
		"\u0098\u009e\u00a4\u00a6\u00a9\u00ae\u00b1\u00b9\u00bc\u00c4\u00c9";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}