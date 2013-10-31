package com.chronicweirdo.jbon.test

import com.chronicweirdo.jbon.grammar.JBONLexer
import com.chronicweirdo.jbon.grammar.JBONListenerImpl
import com.chronicweirdo.jbon.grammar.JBONParser
import com.chronicweirdo.makeitso.grammar.Util

class Test2 {

	static main(args) {
		grammarTest();
	}
	static grammarTest() {
	String text = """\
		{
			"node": (com.chronicweirdo.graph.element.Node) {
				"value": {
					"type": "line",
					"path": ["bbp", "slimsgate.txt"],
					"line": 74
				}
			},
			"list": ["val1", 2, 44.4],
			"set": (java.util.HashSet) ["val1", "val2", "val1"],
			"string": "a simple string",
			"double": 33.4,
			"boolean": true,
			"falseBoolean": false,
			"hashMap": (java.util.HashMap) {}
		}
		"""
	Util.test(JBONLexer.class, JBONParser.class,
			new JBONListenerImpl(), "object",
			text);
	}
}
