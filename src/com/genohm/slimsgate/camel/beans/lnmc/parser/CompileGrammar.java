package com.genohm.slimsgate.camel.beans.lnmc.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.antlr.runtime.RecognitionException;
import org.antlr.v4.Tool;
import org.antlr.v4.tool.Grammar;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

public class CompileGrammar {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, RecognitionException {
		String path = "src/com/genohm/slimsgate/camel/beans/lnmc/parser/filter/SlimsFilter.g4";
		//compileGrammar(path);
		oldCompileGrammar(path);
	}
	
	private static void oldCompileGrammar(String path) {
		Tool.main(new String[] {path});
		System.out.println("done"); // not printed because antlr exits the system itself
	}
	
	private static void compileGrammar(String path) throws FileNotFoundException, RecognitionException {
		String grammar = readFile(path);
		Tool antlr = new Tool();
		antlr.process(new Grammar(grammar), true);
		System.out.println("done");
	}
	
	public static String readFile(String path) throws FileNotFoundException {
		return new Scanner(new File(path)).useDelimiter("\\Z").next();
	}

}
