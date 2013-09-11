package com.chronicweirdo.makeitso.grammar.maps;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.chronicweirdo.makeitso.ConsoleUtils;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.AssignmentContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.EntryContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.KeyContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.MapContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.PrintContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.ValueContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.VariableContext;

public class MapsListenerImpl extends MapsBaseListener {

	private Object database = new HashMap();
	
	
	
	@Override
	public void exitAssignment(@NotNull AssignmentContext ctx) {
		Object value = parse(ctx.value());
		if (value != null) {
			if (ctx.variable().ID() == null || ctx.variable().ID().size() == 0) {
				// replace whole database with value
				database = value;
			} else {
				Object variable = database;
				for (int i = 0; i < ctx.variable().ID().size()-1; i++) {
					TerminalNode id = ctx.variable().ID(i);
					if (variable instanceof Map) {
						Map map = (Map) variable;
						if (map.containsKey(id.getText())) {
							variable = map.get(id.getText());
						} else {
							Map newmap = new HashMap();
							map.put(id.getText(), newmap);
							variable = newmap;
						}
					}
				}
				// for last one, try to set new value in variable
				if (variable instanceof Map) {
					Map map = (Map) variable;
					map.put(ctx.variable().ID(ctx.variable().ID().size()-1).getText(), value);
				}
			}
		}
	}

	@Override
	public void exitPrint(@NotNull PrintContext ctx) {
		Object value = parse(ctx.value());
		if (value instanceof Map) {
			ConsoleUtils.print((Map) value);
		} else {
			ConsoleUtils.print(value);
		}
	}
	
	public Object parse(@NotNull MapContext ctx) {
		Map map = new HashMap();
		if (ctx.entry() != null && ctx.entry().size() > 0) {
			for (EntryContext entry: ctx.entry()) {
				Object key = parse(entry.key());
				Object value = parse(entry.value());
				map.put(key, value);
			}
		}
		return map;
	}

	public Object parse(@NotNull KeyContext ctx) {
		return parse(ctx.value());
	}

	public Object parse(@NotNull ValueContext ctx) {
		if (ctx.STRING() != null) {
			return removeQuotes(ctx.STRING().getText());
		} else if (ctx.ID() != null) {
			return ctx.ID().getText();
		} else if (ctx.NUMBER() != null) {
			try {
				return Long.parseLong(ctx.NUMBER().getText());
			} catch (NumberFormatException e) {
				try {
					return Double.parseDouble(ctx.NUMBER().getText());
				} catch (NumberFormatException ee) {
					return null;
				}
			}
		} else if (ctx.map() != null) {
			return parse(ctx.map());
		} else if (ctx.variable() != null) {
			return parse(ctx.variable());
		}
		return null;
	}
	
	private Object parse(@NotNull VariableContext ctx) {
		Object value = database;
		for (TerminalNode id: ctx.ID()) {
			if (value instanceof Map) {
				Map map = (Map) value;
				if (map.containsKey(id.getText())) {
					value = map.get(id.getText());
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
		return value;
	}
	
	private String removeQuotes(String s) {
		if (s.startsWith("\"") && s.endsWith("\"")) {
			return s.substring(1, s.length() - 1);
		}
		return s;
	}
}
