package com.chronicweirdo.jon.grammar.test

import com.chronicweirdo.jon.grammar.JonLexer
import com.chronicweirdo.jon.grammar.JonListenerImpl
import com.chronicweirdo.jon.grammar.JonParser
import com.chronicweirdo.makeitso.grammar.Util

class Test4 {

	static main(args) {
		grammarTest();
	}
	static grammarTest() {
	String text = """\
		com.chronicweirdo.jon.grammar.test.PrimitiveBean {
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
	Util.test(JonLexer.class, JonParser.class,
			new JonListenerImpl(), "object",
			text);
	}
}
