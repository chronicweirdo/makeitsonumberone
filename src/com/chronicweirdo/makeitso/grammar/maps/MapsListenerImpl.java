package com.chronicweirdo.makeitso.grammar.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

import com.chronicweirdo.makeitso.ConsoleUtils;
import com.chronicweirdo.makeitso.StructureUtils;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.BaseContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.EntryContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.FunctionContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.GetContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.KeyContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.ListContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.MapContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.SetContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.StatementContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.ValueContext;

public class MapsListenerImpl extends MapsBaseListener {

	private Functions functions;
	
	public void setFunctions(Functions functions) {
		this.functions = functions;
	}
	
	@Override
	public void exitStatement(@NotNull StatementContext ctx) {
		if (ctx.base() != null) {
			Object result = parse(ctx.base());
			ConsoleUtils.print(result);
		} else if (ctx.function() != null) {
			Object result = parse(ctx.function());
			ConsoleUtils.print(result);
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
		if (ctx.value() != null) {
			return parse(ctx.value());
		}
		return null;
	}

	public Object parse(@NotNull ValueContext ctx) {
		if (ctx.base() != null) {
			return parse(ctx.base());
		} else if (ctx.function() != null) {
			return parse(ctx.function());
		}
		return null;
	}
	public Object parse(@NotNull BaseContext ctx) {
		if (ctx.ID() != null) {
			return ctx.ID().getText();
		} else if (ctx.STRING() != null) {
			return removeQuotes(ctx.STRING().getText());
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
		}
		return null;
	}
	
	private Object parse(@NotNull FunctionContext ctx) {
		try {
			if (ctx.get() != null) {
				return parse(ctx.get());
			} else if (ctx.set() != null) {
				return parse(ctx.set());
			} else {
				String name = ctx.ID().getText();
				List parameters = new ArrayList();
				for (ValueContext vctx: ctx.value()) {
					parameters.add(parse(vctx));
				}
				return functions.function(name, parameters);
			}
		} catch (Exception e) {
			String message = e.getMessage();
			if (e.getCause() != null) {
				message += "(" + e.getCause().getMessage() + ")";
			}
			ConsoleUtils.print(message);
		}
		return null;
	}
	
	private Object parse(@NotNull GetContext ctx) throws Exception {
		List path = new ArrayList();
		for (KeyContext kctx: ctx.key()) {
			path.add(parse(kctx.value()));
		}
		return functions.function(BasicFunctions.F_GET, StructureUtils.list(path));
	}
	
	private Object parse(@NotNull SetContext ctx) throws Exception {
		List path = new ArrayList();
		for (KeyContext kctx: ctx.key()) {
			path.add(parse(kctx.value()));
		}
		Object value = null;
		if (ctx.base() != null) {
			value = parse(ctx.base());
		} else {
			value = parse(ctx.function());
		}
		return functions.function(BasicFunctions.F_SET, StructureUtils.list(path, value));
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
