package com.chronicweirdo.jbon.grammar

import java.lang.reflect.Constructor

import com.chronicweirdo.jbon.grammar.JBONParser.KeyContext
import com.chronicweirdo.jbon.grammar.JBONParser.ListContext
import com.chronicweirdo.jbon.grammar.JBONParser.MapContext
import com.chronicweirdo.jbon.grammar.JBONParser.ObjectContext
import com.chronicweirdo.jbon.grammar.JBONParser.P_booleanContext
import com.chronicweirdo.jbon.grammar.JBONParser.P_charContext
import com.chronicweirdo.jbon.grammar.JBONParser.P_doubleContext
import com.chronicweirdo.jbon.grammar.JBONParser.P_floatContext
import com.chronicweirdo.jbon.grammar.JBONParser.P_intContext
import com.chronicweirdo.jbon.grammar.JBONParser.P_longContext
import com.chronicweirdo.jbon.grammar.JBONParser.P_stringContext
import com.chronicweirdo.jbon.grammar.JBONParser.PrimitiveContext
import com.chronicweirdo.jbon.grammar.JBONParser.TypeContext

class JBONListenerImpl extends JBONBaseListener {

	@Override
	public void exitObject(ObjectContext ctx) {
		Object o = parse(ctx);
		println o.toString() + " " + o.getClass().getCanonicalName()
	}
	
	Object parse(ObjectContext ctx) {
		if (ctx.type() && ctx.map()) {
			// we are parsing a java object
			Map map = parse(ctx.map());
			Class cls = Class.forName(parse(ctx.type()));
			Constructor constructor = cls.getConstructor();
			Object o = constructor.newInstance();
			map.each { property, value ->
				o[property] = value
			}
			return o;
		} else if (ctx.type() && ctx.list()) {
			// we are parsing a java collection other than list
			List list = parse(ctx.list())
			Class cls = Class.forName(parse(ctx.type()));
			if (!Collection.class.isAssignableFrom(cls)) throw new Exception("Not a collection")
			Constructor constructor = cls.getConstructor(Collection.class);
			return constructor.newInstance(list);
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
		// TODO: implement to directly create object
		return null;
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
	
	Object parse(ListContext ctx) {
		List list = [];
		ctx.object().each {
			list.add(parse(it))
		}
		return list;
	}

	Integer parse(P_intContext ctx) {
		return Integer.decode(ctx.getText());
	}
	Long parse(P_longContext ctx) {
		return Long.parseLong(ctx.INTEGER().getText());
	}
	Float parse(P_floatContext ctx) {
		return Float.parseFloar(ctx.FLOAT().getText());
	}
	Double parse(P_doubleContext ctx) {
		return Double.parseDouble(ctx.FLOAT().getText());
	}
	Character parse(P_charContext ctx) {
		return new Character(removeQuotes(ctx.getText()).charAt(0));
	}
	String parse(P_stringContext ctx) {
		return removeQuotes(ctx.getText());
	}
	Boolean parse(P_booleanContext ctx) {
		return Boolean.parseBoolean(ctx.getText());
	}
/*
primitive
	: p_int
	| p_long
	| p_float
	| p_double
	| p_string
	| p_char
	| p_boolean
	;

p_int
	: INTEGER
	| HEXADECIMAL
	| BINARY
	;
p_long : INTEGER ('l'|'L') ;
p_float : FLOAT ('f'|'F') ;
p_double : FLOAT ('d'|'D')? ;
p_char : CHAR ;
p_string : STRING ;
p_boolean : TRUE | FALSE ;
*/
	Object parse(PrimitiveContext ctx) {
		if (ctx.p_int() != null) return parse(ctx.p_int());
		if (ctx.p_long() != null) return parse(ctx.p_long());
		if (ctx.p_float() != null) return parse(ctx.p_float());
		if (ctx.p_double() != null) return parse(ctx.p_double());
		if (ctx.p_string() != null) return parse(ctx.p_string());
		if (ctx.p_char() != null) return parse(ctx.p_char());
		if (ctx.p_boolean() != null) return parse(ctx.p_boolean());
		return null;
	}
	
	private String removeQuotes(String s) {
		if (s.startsWith("\"") && s.endsWith("\"")) {
			return s.substring(1, s.length() - 1);
		} else if (s.startsWith("'") && s.endsWith("'")) {
			return s.substring(1, s.length() - 1);
		}
		return s;
	}
	
}
