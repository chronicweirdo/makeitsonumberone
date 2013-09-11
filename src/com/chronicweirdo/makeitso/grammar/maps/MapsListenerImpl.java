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
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.EntryContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.KeyContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.ListContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.MapContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.PrintContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.ValueContext;

public class MapsListenerImpl extends MapsBaseListener {

	private Object database = new HashMap();
	
	/*private Object parse(@NotNull FunctionContext ctx) {
		if (ctx.find() != null) {
			return parse(ctx.find());
		}
		return null;
	}
	
	private Object parse(@NotNull FindContext ctx) {
		Pattern pattern = Pattern.compile(removeQuotes(ctx.STRING().getText()));
		Object value = parse(ctx.value());
		return find(value, pattern);
	}*/
	
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
	
	/*
	@Override
	public void exitAssignment(@NotNull AssignmentContext ctx) {
		Object value = parse(ctx.value());
		if (value != null) {
			if (ctx.variable().key() == null || ctx.variable().key().size() == 0) {
				// replace whole database with value
				database = value;
			} else {
				Object variable = database;
				for (int i = 0; i < ctx.variable().key().size()-1; i++) {
					KeyContext kctx = ctx.variable().key(i);
					Object id = parse(kctx.value());
					if (variable instanceof Map) {
						Map map = (Map) variable;
						if (map.containsKey(id)) {
							variable = map.get(id);
						} else {
							Map newmap = new HashMap();
							map.put(id, newmap);
							variable = newmap;
						}
					} else if (variable instanceof List) {
						if (id instanceof Long || id instanceof Integer) {
							Integer index = (Integer) id;
							variable = ((List) variable).get(index);
						} else {
							return;
						}
					}
				}
				// for last one, try to set new value in variable
				if (variable instanceof Map) {
					Map map = (Map) variable;
					KeyContext kctx = ctx.variable().key(ctx.variable().key().size()-1);
					Object id = parse(kctx.value());
					map.put(id, value);
				} else if (variable instanceof List) {
					KeyContext kctx = ctx.variable().key(ctx.variable().key().size()-1);
					Object id = parse(kctx.value());
					if 
				}
			}
		}
	}
	*/
	
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
		} else if (ctx.list() != null) {
			return parse(ctx.list());
		} else if (ctx.database() != null) {
			return database;
		} else if (ctx.value() != null && ctx.key() != null) {
			Object value = parse(ctx.value());
			Object key = parse(ctx.key().value());
			if (value == null) return null;
			if (key == null) return null;
			if (value instanceof List) {
				List list = (List) value;
				if (key instanceof Integer) {
					Integer index = (Integer) key;
					if (0 <= index && index < list.size()) {
						return list.get(index);
					} else {
						return null;
					}
				} else if (key instanceof Long) {
					Integer index = ((Long) key).intValue();
					if (0 <= index && index < list.size()) {
						return list.get(index);
					} else {
						return null;
					}
				} else {
					return null;
				}
			} else if (value instanceof Map) {
				Map map = (Map) value;
				if (map.containsKey(key)) {
					return map.get(key);
				} else {
					return null;
				}
			}
		}
		return null;
	}
	/*
	private Object parse(@NotNull VariableContext ctx) {
		Object value = database;
		for (KeyContext kctx: ctx.key()) {
			Object key = parse(kctx.value());
			if (value instanceof Map) {
				Map map = (Map) value;
				if (map.containsKey(key)) {
					value = map.get(key);
				} else {
					return null;
				}
			} else if (value instanceof List && ((key instanceof Integer) || (key instanceof Long))) {
				Integer index = (Integer) key;
				List list = (List) value;
				if (0 <= index && index < list.size()) {
					value = list.get(index);
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
		return value;
	}
	*/
	private String removeQuotes(String s) {
		if (s.startsWith("\"") && s.endsWith("\"")) {
			return s.substring(1, s.length() - 1);
		}
		return s;
	}
}