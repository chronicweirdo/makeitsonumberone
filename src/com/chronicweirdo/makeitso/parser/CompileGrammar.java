package com.chronicweirdo.makeitso.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.antlr.v4.Tool;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

public class CompileGrammar {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws CompileException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		String path = "grammar\\Hello.g4";
		Tool.main(new String[] {path});
		/*
		 * SimpleCompiler compiler = new SimpleCompiler();
		 * compiler.cook("HelloLexer.class", new FileInputStream(new
		 * File("grammar\\HelloLexer.java")));
		 */
		// compile("grammar\\HelloLexer.java");
		/*for (File file : findClassFiles("grammar")) {
			compile(file.getAbsolutePath());
		}*/
		//compile("C:\\Users\\Silviu\\workspace\\makeitso\\grammar\\HelloParser.java");
		//compile("C:\\Users\\Silviu\\workspace\\makeitso\\grammar\\HelloListener.java");
		compile(findClassFiles("grammar"));
		loadClassFile("grammar");
	}
	
	private static void loadClassFile(String path) {
		File file = new File(path);

		try {
		    // Convert File to a URL
		    URL url = file.toURL();          // file:/c:/myclasses/
		    URL[] urls = new URL[]{url};

		    // Create a new class loader with the directory
		    ClassLoader cl = new URLClassLoader(urls);

		    // Load in the class; MyClass.class should be located in
		    // the directory file:/c:/myclasses/com/mycompany
		    Class cls = cl.loadClass("HelloBaseListener");
		    cls.newInstance();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static List<String> findClassFiles(String path) {
		IOFileFilter filter = new IOFileFilter() {

			@Override
			public boolean accept(File arg0, String arg1) {
				return accept(new File(arg0, arg1));
			}

			@Override
			public boolean accept(File arg0) {
				return FilenameUtils.getExtension(arg0.getAbsolutePath())
						.equals("java");
			}
		};
		Collection<File> files = FileUtils.listFiles(new File(path), filter,
				null);
		List<String> names = new ArrayList<String>();
		
		for (File f : files) {
			System.out.println(f.getAbsolutePath());
			names.add(f.getAbsolutePath());
		}
		return names;
	}

	private static void compile(List<String> paths) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println(System.getProperty("java.class.path"));
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("-classpath");
		arguments.add(System.getProperty("java.class.path"));
		arguments.addAll(paths);
		String[] a = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			a[i] = arguments.get(i);
		}
		int compilationResult = compiler.run(null, System.out, null, a);
		if (compilationResult == 0) {
			System.out.println("Compilation is successful");
		} else {
			System.out.println("Compilation Failed");
		}
	}

	/*private static void compile2(String path) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		List<String> optionList = new ArrayList<String>();
		// set compiler's classpath to be same as the runtime's
		optionList.addAll(Arrays.asList("-classpath",
				System.getProperty("java.class.path")));

		// any other options you want
		//optionList.addAll(Arrays.asList(options));

		JavaCompiler.CompilationTask task = compiler.getTask(null, null,
				null, optionList, null, new JavaFileObject);
	}*/

}
