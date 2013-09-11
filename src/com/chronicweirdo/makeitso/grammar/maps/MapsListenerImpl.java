package com.chronicweirdo.makeitso.grammar.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.chronicweirdo.makeitso.ConsoleUtils;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.AssignmentContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.EntryContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.FindContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.FunctionContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.KeyContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.ListContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.MapContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.PrintContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.ValueContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.VariableContext;

public class MapsListenerImpl extends MapsBaseListener {

	private Object database = new HashMap();
	
	private Object parse(@NotNull FunctionContext ctx) {
		if (ctx.find() != null) {
			return parse(ctx.find());
		}
		return null;
	}
	
	private Object parse(@NotNull FindContext ctx) {
		Pattern pattern = Pattern.compile(removeQuotes(ctx.STRING().getText()));
		Object value = parse(ctx.value());
		return find(value, pattern);
	}
	
	private List find(Object source, Pattern pattern) {
		List result = new ArrayList();
		if (source instanceof Map) {
			for (Map.Entry<Object, Object> entry: ((Map<Object, Object>) source).entrySet()) {
				Matcher matcher = pattern.matcher(entry.getKey().toString());
				if (matcher.matches()) {
					result.add(entry.getValue());
				}
				result.addAll(find(entry.getValue(), pattern));
			}
		} else if (source instanceof List) {
			for (Object entry: (List) source) {
				result.addAll(find(entry, pattern));
			}
		} else {
			Matcher matcher = pattern.matcher(source.toString());
			if (matcher.matches()) {
				result.add(source);
			}
		}
		return result;
	}
	
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
				if (key != null && value != null) {
					map.put(key, value);
				}
			}
		}
		return map;
	}
	
	public Object parse(@NotNull ListContext ctx) {
		List list = new ArrayList();
		if (ctx.value() != null && ctx.value().size() > 0) {
			for (ValueContext vctx: ctx.value()) {
				Object value = parse(vctx);
				if (value != null) {
					list.add(value);
				}
			}
		}
		return list;
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
		} else if (ctx.list() != null) {
			return parse(ctx.list());
		} else if (ctx.function() != null) {
			return parse(ctx.function());
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
