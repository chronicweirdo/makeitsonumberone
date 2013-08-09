package com.chronicweirdo.exocortex.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

import com.chronicweirdo.exocortex.parser.ExocortexParser.EntryContext;
import com.chronicweirdo.exocortex.parser.ExocortexParser.MapContext;
import com.chronicweirdo.exocortex.parser.ExocortexParser.ValueContext;

public class ExocortexListenerImpl extends ExocortexBaseListener {

	private List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
	
	public List<Map<String, Object>> getMaps() {
		return maps;
	}

	@Override
	public void exitMap(@NotNull MapContext ctx) {
		if (!(ctx.getParent() instanceof ValueContext)) {
			maps.add(parseMap(ctx));
		}
	}

	private Map<String, Object> parseMap(MapContext ctx) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (EntryContext ectx: ctx.entry()) {
			String key;
			if (ectx.key().STRING() != null) {
				key = insides(ectx.key().STRING().getText());
			} else {
				key = ectx.key().ID().getText();
			}
			Object value = parseValue(ectx.value());
			map.put(key, value);
		}
		return map;
	}
	private Object parseValue(ValueContext ctx) {
		if (ctx.primitive() != null) {
			if (ctx.primitive().STRING() != null) {
				return insides(ctx.primitive().STRING().getText());
			} else if (ctx.primitive().NUMBER() != null) {
				try {
					return Long.parseLong(ctx.primitive().NUMBER().getText());
				} catch (NumberFormatException e) {
					return Double.parseDouble(ctx.primitive().NUMBER().getText());
				}
			} else {
				return Boolean.parseBoolean(ctx.primitive().BOOLEAN().getText());
			}
		} else {
			return parseMap(ctx.map());
		}
	}
	
	private String insides(String string) {
		if (string.startsWith("\"") && string.endsWith("\"")) {
			return string.substring(1, string.length()-1);
		}
		return string;
	}
}
