package com.chronicweirdo.jbon.test

import com.chronicweirdo.jbon.grammar.JBONLexer
import com.chronicweirdo.jbon.grammar.JBONListenerImpl
import com.chronicweirdo.jbon.grammar.JBONParser
import com.chronicweirdo.makeitso.grammar.Util

class Test1 {

	static main(args) {
		Class cls = Class.forName("com.chronicweirdo.graph.element.Node");
		println cls.getCanonicalName();
		grammarTest();
	}
	
	static grammarTest() {
	String text = """\
(com.chronicweirdo.graph.element.Link) {
	"from": (com.chronicweirdo.graph.element.Node) {
		"value": {
			"type": "line",
			"path": ["bbp", "slimsgate.txt"],
			"line": 74
		}
	},
	"value": {
		"type": "tag"
		},
	"to": (com.chronicweirdo.graph.element.Node) {
		"value": {
			"type":"tag",
			"tag": ["slims", "slimsgate_tests_and_results"]
			}
		}
}
		"""
	Util.test(JBONLexer.class, JBONParser.class,
			new JBONListenerImpl(), "object",
			text);
	}
}
