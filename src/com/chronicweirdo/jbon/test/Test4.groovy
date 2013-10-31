package com.chronicweirdo.jbon.test

import java.nio.file.Paths

import com.chronicweirdo.jbon.grammar.JBONLexer
import com.chronicweirdo.jbon.grammar.JBONListenerImpl
import com.chronicweirdo.jbon.grammar.JBONParser
import com.chronicweirdo.makeitso.file.FileUtils
import com.chronicweirdo.makeitso.grammar.Util

class Test4 {

	static main(args) {
		grammarTest();
	}
	static grammarTest() {
	String text = FileUtils.readTextFile(Paths.get("src","com","chronicweirdo","jbon","test","test4.jbon").toString());
	println text
	Util.test(JBONLexer.class, JBONParser.class,
			new JBONListenerImpl(), "object",
			text);
	}
}
