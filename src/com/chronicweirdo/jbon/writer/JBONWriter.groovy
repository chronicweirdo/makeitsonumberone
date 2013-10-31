package com.chronicweirdo.jbon.writer

import com.chronicweirdo.jbon.grammar.JBONLexer
import com.chronicweirdo.jbon.grammar.JBONListener
import com.chronicweirdo.jbon.grammar.JBONListenerImpl
import com.chronicweirdo.jbon.grammar.JBONParser
import com.chronicweirdo.jbon.test.PrimitiveBean
import com.chronicweirdo.makeitso.grammar.Util

class JBONWriter {

	static String tabs(int level) {
		StringBuilder t = new StringBuilder();
		for (int i = 0; i < level; i++) {
			t.append('\t')
		}
		return t.toString()
	}
	static niceWrite(StringBuilder b, int level, boolean doTabs, Object o) {
		if (o instanceof Byte) {
			if (doTabs) b.append(tabs(level))
			b.append(o)
		} else if (o instanceof Short) {
			if (doTabs) b.append(tabs(level))
			b.append(o)
		} else if (o instanceof Integer) {
			if (doTabs) b.append(tabs(level))
			b.append(o)
		} else if (o instanceof Long) {
			if (doTabs) b.append(tabs(level))
			b.append(o).append("l")
		} else if (o instanceof Float) {
			if (doTabs) b.append(tabs(level))
			b.append(o).append("f")
		} else if (o instanceof Double) {
			if (doTabs) b.append(tabs(level))
			b.append(o).append("d")
		} else if (o instanceof Character) {
			if (doTabs) b.append(tabs(level))
			b.append("'").append(o).append("'")
		} else if (o instanceof Boolean) {
			if (doTabs) b.append(tabs(level))
			b.append(o)
		} else if (o instanceof String) {
			if (doTabs) b.append(tabs(level))
			b.append('"').append(escape(o)).append('"')
		} else if (o instanceof Map) {
			if (doTabs) b.append(tabs(level))
			b.append(o.getClass().getCanonicalName()).append(' {\n')
			def prefix = null
			o.each { key, val ->
				if (prefix) b.append(prefix)
				niceWrite(b, level+1, true, key)
				b.append(': ')
				niceWrite(b, level+1, false, val)
				prefix = ',\n'
			}
			b.append('\n')
			b.append(tabs(level))
			b.append('}')
		} else if (o instanceof Collection) {
			if (doTabs) b.append(tabs(level)) 
			b.append(o.getClass().getCanonicalName()).append(' [\n')
			def prefix = null
			o.each {
				if (prefix) b.append(prefix)
				niceWrite(b, level+1, true, it)
				prefix = ',\n'
			}
			b.append('\n')
			b.append(tabs(level))
			b.append(']')
		} else {
			if (doTabs) b.append(tabs(level))
			b.append(o.getClass().getCanonicalName()).append(' {\n')
			def prefix = null
			o.metaClass.properties.each {
				if (!(it.name == "class")) {
					if (prefix) b.append(prefix)
					b.append(tabs(level+1))
					b.append(it.name).append(': ')
					niceWrite(b, level+1, false, o[it.name])
					prefix = ',\n'
				}
			}
			b.append('\n')
			b.append(tabs(level))
			b.append('}')
		}
	}
	static write(StringBuilder b, Object o) {
		if (o instanceof Byte) {
			b.append(o)
		} else if (o instanceof Short) {
			b.append(o)
		} else if (o instanceof Integer) {
			b.append(o)
		} else if (o instanceof Long) {
			b.append(o).append("l")
		} else if (o instanceof Float) {
			b.append(o).append("f")
		} else if (o instanceof Double) {
			b.append(o).append("d")
		} else if (o instanceof Character) {
			b.append("'").append(o).append("'")
		} else if (o instanceof Boolean) {
			b.append(o)
		} else if (o instanceof String) {
			b.append('"').append(escape(o)).append('"')
		} else if (o instanceof Map) {
			b.append(o.getClass().getCanonicalName()).append('{')
			def prefix = null
			o.each { key, val ->
				if (prefix) b.append(prefix)
				write(b, key)
				b.append(':')
				write(b, val)
				prefix = ','
			}
			b.append('}')
		} else if (o instanceof Collection) {
			b.append(o.getClass().getCanonicalName()).append('[')
			def prefix = null
			o.each {
				if (prefix) b.append(prefix)
				write(b, it)
				prefix = ','
			}
			b.append(']')
		} else {
			b.append(o.getClass().getCanonicalName()).append('{')
			def prefix = null
			o.metaClass.properties.each {
				if (!(it.name == "class")) {
					if (prefix) b.append(prefix)
					b.append(it.name).append(':')
					write(b, o[it.name])
					prefix = ','
				}
			}
			b.append('}')
		}
	}
	
	static String escape(String original) {
		String n = original;
		//String n = original.replaceAll("\"", "\\\\\"");
		/*
		 * \t 	Insert a tab in the text at this point.
\b 	Insert a backspace in the text at this point.
\n 	Insert a newline in the text at this point.
\r 	Insert a carriage return in the text at this point.
\f 	Insert a formfeed in the text at this point.
\' 	Insert a single quote character in the text at this point.
\" 	Insert a double quote character in the text at this point.
\\
		 */
		n = n.replace("\\", "\\\\");
		n = n.replace("\t", "\\t");
		n = n.replace("\b", "\\b");
		n = n.replace("\n", "\\n");
		n = n.replace("\r", "\\r");
		n = n.replace("\f", "\\f");
		n = n.replace("\'", "\\'");
		n = n.replace("\"", "\\\"");
		return n;
	}
	
	static study(Object o) {
		o.metaClass.properties.each {
			if (!(it.name == "class")) {
				print it.name
				print " = "
				print o[it.name]
				print " :: "
				println o[it.name].class
			}
		}
	}
	static main(args) {
		/*int x = 3;
		println x.class*/
		PrimitiveBean bean = new PrimitiveBean();
		bean.vByte = 2
		bean.vInteger = 4
		bean.vShort = 6
		bean.vCharacter = 'x'
		bean.vBoolean = true
		bean.vDouble = 22.2
		bean.vFloat = 2.2
		bean.vLong = 2222
		bean.vString = "test\t\"string\"\n\\"
		//Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki", "bbp", "semantic_mediawiki.txt");
		//bean.vString = FileUtils.readTextFile(root.toString());
		bean.vMap = ["key1":"val1", "key2":"val2", "key3": ["key4":[3, 4, 5], "key5": false]]
		bean.vList = ["elem1", "elem2"]
		bean.vSet = ["elem3", "elem4"]
		
		//println escape(bean.vString)
		
		//study(bean)
		StringBuilder b = new StringBuilder();
		niceWrite(b, 0, true, bean)
		println b.toString()
		
		JBONListenerImpl listener = new JBONListenerImpl();
		Util.test(JBONLexer.class, JBONParser.class,
			listener, "file",
			b.toString());
		
		StringBuilder bb = new StringBuilder();
		niceWrite(bb, 0, true, listener.object)
		println bb.toString()
	}

}
