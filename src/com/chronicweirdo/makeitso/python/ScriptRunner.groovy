package com.chronicweirdo.makeitso.python

import java.nio.file.Path
import java.nio.file.Paths

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

import org.python.core.PyInteger
import org.python.core.PyObject
import org.python.util.PythonInterpreter

class ScriptRunner {

	static deflt() {
		PythonInterpreter interp = new PythonInterpreter();
		interp.exec("import sys");
		interp.exec("print sys");
		interp.set("a", new PyInteger(42));
		interp.exec("print a");
		interp.exec("x = 2+2");
		PyObject x = interp.get("x");
		System.out.println("x: " + x);
	}
	static jsr223() {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");
		engine.eval("import sys");
		engine.eval("print sys");
		engine.put("a", 42);
		engine.eval("print a");
		engine.eval("x = 2 + 2");
		Object x = engine.get("x");
		System.out.println("x: " + x);
	}
	static jsr223(Path path) {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");
		File file = path.toFile();
		println file.getAbsolutePath()
		if (file.exists()) {
			engine.eval(file.newReader());
		}
	}
	static main(args) {
		//def();
		//jsr223();
		jsr223(Paths.get("src", "com", "chronicweirdo", "makeitso", "python", "test.py"));
		//jsr223(Paths.get("src", "com", "chronicweirdo", "makeitso", "python", "buildCache.py"));
	}

}
