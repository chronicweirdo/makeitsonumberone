package com.chronicweirdo.jon.grammar

import java.lang.reflect.Constructor

import com.chronicweirdo.jon.grammar.JonParser.ListContext
import com.chronicweirdo.jon.grammar.JonParser.MapContext
import com.chronicweirdo.jon.grammar.JonParser.ObjectContext
import com.chronicweirdo.jon.grammar.JonParser.TypeContext
import com.chronicweirdo.jon.grammar.JonParser.ValueContext

class JonListenerImpl extends JonBaseListener {

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
		} else if (ctx.value()) {
			// java basic value
			return parse(ctx.value())
		}
		return null;
	}
	
	String parse(TypeContext ctx) {
		return ctx.typeString().getText();
	}
	
	Object parse(MapContext ctx) {
		Map map = [:]
		ctx.mapEntry().each { mapEntry ->
			Object key = parse(mapEntry.mapEntryKey().object());
			Object value = parse(mapEntry.mapEntryValue().object());
			map[key] = value;
		}
		return map;
	}
	
	Object parse(ListContext ctx) {
		List list = [];
		ctx.listEntry().each {
			list.add(parse(it.object()))
		}
		return list;
	}

	Object parse(ValueContext ctx) {
		if (ctx.STRING()) {
			// this is a string
			return removeQuotes(ctx.getText())
		} else if (ctx.NUMBER()) {
			// find out what kind of number it is
			try {
				Integer n = Integer.parseInt(ctx.getText());
				return n;
			} catch (NumberFormatException e) {}
			try {
				Long n = Long.parseLong(ctx.getText());
				return n;
			} catch (NumberFormatException e) {}
			try {
				Float n = Float.parseFloat(ctx.getText());
				return n;
			} catch (NumberFormatException e) {}
			try {
				Double n = Double.parseDouble(ctx.getText());
				return n;
			} catch (NumberFormatException e) {}
		}
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
