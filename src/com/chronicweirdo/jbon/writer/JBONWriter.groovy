package com.chronicweirdo.jbon.writer

import com.chronicweirdo.jbon.grammar.JBONLexer
import com.chronicweirdo.jbon.grammar.JBONListenerImpl
import com.chronicweirdo.jbon.grammar.JBONParser
import com.chronicweirdo.jbon.test.PrimitiveBean
import com.chronicweirdo.makeitso.grammar.Util

class JBONWriter {

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
			b.append('"').append(escapeQuotes(o)).append('"')
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
	
	static String escapeQuotes(String original) {
		//return original.replace("\"", "\\\"");
		return original.replaceAll("\"", "\\\\\"");
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
		bean.vString = "test \"string\""
		bean.vMap = ["key1":"val1", "key2":"val2"]
		bean.vList = ["elem1", "elem2"]
		bean.vSet = ["elem3", "elem4"]
		
		//println escapeQuotes(bean.vString)
		
		//study(bean)
		StringBuilder b = new StringBuilder();
		write(b, bean)
		println b.toString()
		
		Util.test(JBONLexer.class, JBONParser.class,
			new JBONListenerImpl(), "object",
			b.toString());
	}

}
