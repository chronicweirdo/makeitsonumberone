package com.chronicweirdo.jon.grammar.test

import com.chronicweirdo.jon.grammar.JonLexer
import com.chronicweirdo.jon.grammar.JonListenerImpl
import com.chronicweirdo.jon.grammar.JonParser
import com.chronicweirdo.makeitso.grammar.Util

class Test1 {

	static main(args) {
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
	Util.test(JonLexer.class, JonParser.class,
			new JonListenerImpl(), "object",
			text);
	}
}
