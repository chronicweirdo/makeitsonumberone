package com.chronicweirdo.jbon.grammar

import java.lang.reflect.Constructor

import com.chronicweirdo.jbon.grammar.JBONParser.FileContext
import com.chronicweirdo.jbon.grammar.JBONParser.KeyContext
import com.chronicweirdo.jbon.grammar.JBONParser.ListContext
import com.chronicweirdo.jbon.grammar.JBONParser.MapContext
import com.chronicweirdo.jbon.grammar.JBONParser.ObjectContext
import com.chronicweirdo.jbon.grammar.JBONParser.PBooleanContext
import com.chronicweirdo.jbon.grammar.JBONParser.PCharContext
import com.chronicweirdo.jbon.grammar.JBONParser.PDoubleContext
import com.chronicweirdo.jbon.grammar.JBONParser.PFloatContext
import com.chronicweirdo.jbon.grammar.JBONParser.PIntContext
import com.chronicweirdo.jbon.grammar.JBONParser.PLongContext
import com.chronicweirdo.jbon.grammar.JBONParser.PStringContext
import com.chronicweirdo.jbon.grammar.JBONParser.PrimitiveContext
import com.chronicweirdo.jbon.grammar.JBONParser.TypeContext

class JBONListenerImpl extends JBONBaseListener {

	Object object;
	
	@Override
	public void exitFile(FileContext ctx) {
		object = parse(ctx.object());
	}
	
	Object parse(ObjectContext ctx) {
		if (ctx.type() && ctx.map()) {
			return parse(ctx.type(), ctx.map());
		} else if (ctx.type() && ctx.list()) {
			// we are parsing a java collection other than list
			return parse(ctx.type(), ctx.list())
		} else if (ctx.map()) {
			// simple java map
			return parse(ctx.map())
		} else if (ctx.list()) {
			// simple java list
			return parse(ctx.list())
		} else if (ctx.primitive()) {
			// java basic value
			return parse(ctx.primitive())
		}
		return null;
	}
	
	String parse(TypeContext ctx) {
		StringBuilder b = new StringBuilder();
		String prefix = "";
		ctx.ID().each{
			b.append(prefix).append(it);
			prefix = "."
		}
		return b.toString();
	}
	
	Object parse(KeyContext ctx) {
		if (ctx.object()) {
			return parse(ctx.object());
		} else {
			return ctx.ID().getText();
		}
	}
	Object parse(TypeContext tctx, MapContext ctx) {
		// we are parsing a java object
		Class cls = Class.forName(parse(tctx));
		Constructor constructor = cls.getConstructor();
		Object o = constructor.newInstance();
		
		ctx.entry().each { entry ->
			Object key = parse(entry.key());
			Object value = parse(entry.value().object());
			o[key] = value;
		}
		
		return o;
	}
	Object parse(MapContext ctx) {
		Map map = [:]
		ctx.entry().each { entry ->
			Object key = parse(entry.key());
			Object value = parse(entry.value().object());
			map[key] = value;
		}
		return map;
	}
	
	Object parse(TypeContext tctx, ListContext ctx) {
		Class cls = Class.forName(parse(tctx));
		if (!Collection.class.isAssignableFrom(cls)) throw new Exception("Not a collection")
		Constructor constructor = cls.getConstructor();
		Collection collection = constructor.newInstance()
		ctx.object().each {
			collection.add(parse(it))
		}
		return collection;
	}
	
	Object parse(ListContext ctx) {
		List list = [];
		ctx.object().each {
			list.add(parse(it))
		}
		return list;
	}

	Integer parse(PIntContext ctx) {
		return Integer.decode(ctx.getText());
	}
	Long parse(PLongContext ctx) {
		return Long.parseLong(ctx.INTEGER().getText());
	}
	Float parse(PFloatContext ctx) {
		return Float.parseFloat(ctx.FLOAT().getText());
	}
	Double parse(PDoubleContext ctx) {
		return Double.parseDouble(ctx.FLOAT().getText());
	}
	Character parse(PCharContext ctx) {
		return new Character(removeQuotes(ctx.getText()).charAt(0));
	}
	String parse(PStringContext ctx) {
		return treatString(ctx.getText());
	}
	Boolean parse(PBooleanContext ctx) {
		return Boolean.parseBoolean(ctx.getText());
	}

	Object parse(PrimitiveContext ctx) {
		if (ctx.pInt() != null) return parse(ctx.pInt());
		if (ctx.pLong() != null) return parse(ctx.pLong());
		if (ctx.pFloat() != null) return parse(ctx.pFloat());
		if (ctx.pDouble() != null) return parse(ctx.pDouble());
		if (ctx.pString() != null) return parse(ctx.pString());
		if (ctx.pChar() != null) return parse(ctx.pChar());
		if (ctx.pBoolean() != null) return parse(ctx.pBoolean());
		if (ctx.pNull() != null) return null;
		return null;
	}
	
	private String treatString(String s) {
		String n = removeQuotes(s);
		n = replaceQuotes(n);
		return n;
	}
	
	private String removeQuotes(String s) {
		if (s.startsWith("\"") && s.endsWith("\"")) {
			return s.substring(1, s.length() - 1);
		} else if (s.startsWith("'") && s.endsWith("'")) {
			return s.substring(1, s.length() - 1);
		}
		return s;
	}
	
	private String replaceQuotes(String s) {
		// TODO: handle all escape characters		
		String n = s;
		n = n.replace("\\t", "\t");
		n = n.replace("\\b", "\b");
		n = n.replace("\\n", "\n");
		n = n.replace("\\r", "\r");
		n = n.replace("\\f", "\f");
		n = n.replace("\\'", "\'");
		n = n.replace("\\\"", "\"");
		n = n.replace("\\\\", "\\");
		return n;
	}
}
