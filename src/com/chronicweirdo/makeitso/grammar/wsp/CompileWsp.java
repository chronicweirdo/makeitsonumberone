package com.chronicweirdo.makeitso.grammar.wsp;

import java.io.File;
import java.net.URL;

import com.chronicweirdo.makeitso.grammar.Util;

public class CompileWsp {

	public static void main(String[] args) {
		URL url = CompileWsp.class.getClassLoader().getResource("com/chronicweirdo/makeitso/grammar/wsp/Wsp.g4");
		System.out.println(url.getPath());
		//System.out.println(url.getProtocol());
		Util.compile("/Users/cacovean/Documents/workspace/makeitso/src/com/chronicweirdo/makeitso/grammar/wsp/Wsp.g4");
	}

}
