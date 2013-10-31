package com.chronicweirdo.jbon.reader

import com.chronicweirdo.jbon.grammar.JBONLexer
import com.chronicweirdo.jbon.grammar.JBONListenerImpl
import com.chronicweirdo.jbon.grammar.JBONParser
import com.chronicweirdo.makeitso.grammar.Util

class JBONReader {

	static Object read(String jbon) {
		JBONListenerImpl listener = new JBONListenerImpl();
		Util.test(JBONLexer.class, JBONParser.class,
			listener, "file",
			jbon);
		return listener.object;
	}
	
	static main(args) {
	
	}

}
