package com.chronicweirdo.makeitso.grammar.wsp;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import com.chronicweirdo.makeitso.grammar.Util;

public class TestWsp {

	public static void main(String[] args) throws Exception {
		String file = Util.readFile("/Users/cacovean/Documents/workspace/makeitso/src/com/chronicweirdo/makeitso/grammar/wsp/test1");
		Util.test(WspLexer.class, WspParser.class, 
				new WspListenerImpl(), "query", 
				file);
	}

}
