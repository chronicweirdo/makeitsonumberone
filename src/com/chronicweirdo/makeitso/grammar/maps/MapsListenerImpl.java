package com.chronicweirdo.makeitso.grammar.maps;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

import com.chronicweirdo.makeitso.ConsoleUtils;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.EntryContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.KeyContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.MapContext;
import com.chronicweirdo.makeitso.grammar.maps.MapsParser.ValueContext;

public class MapsListenerImpl extends MapsBaseListener {

	
	@Override
	public void exitMap(@NotNull MapContext ctx) {
		ConsoleUtils.print("result map", parse(ctx));
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
		}
		return null;
	}
	
	private String removeQuotes(String s) {
		if (s.startsWith("\"") && s.endsWith("\"")) {
			return s.substring(1, s.length() - 1);
		}
		return s;
	}
}
