package com.chronicweirdo.jbon.test

import com.chronicweirdo.jbon.grammar.JBONLexer
import com.chronicweirdo.jbon.grammar.JBONListenerImpl
import com.chronicweirdo.jbon.grammar.JBONParser
import com.chronicweirdo.makeitso.grammar.Util

class Test4 {

	static main(args) {
		grammarTest();
	}
	static grammarTest() {
	String text = """\
		com.chronicweirdo.jbon.test.PrimitiveBean {
			vBoolean: true,
			"vByte": 2,
			"vShort": 4,
			"vInteger": 0x123,
			"vLong": 12345l,
			"vDouble": 112.4,
			"vFloat": 12.3,
			"vString": "test string",
			"vCharacter": 'c'
		}
		"""
	Util.test(JBONLexer.class, JBONParser.class,
			new JBONListenerImpl(), "object",
			text);
	}
}
