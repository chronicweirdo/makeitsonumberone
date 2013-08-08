package com.chronicweirdo.exocortex.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

import com.chronicweirdo.exocortex.parser.ExocortexParser.EntryContext;
import com.chronicweirdo.exocortex.parser.ExocortexParser.MapContext;

public class ExocortexListenerImpl extends ExocortexBaseListener {

	private List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
	
	public List<Map<String, Object>> getMaps() {
		return maps;
	}

	@Override
	public void exitMap(@NotNull MapContext ctx) {
		maps.add(parseMap(ctx));
	}

	private Map<String, Object> parseMap(MapContext ctx) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (EntryContext ectx: ctx.entry()) {
			String key = insides(ectx.STRING().getText());
			map.put(key, key);
		}
		return map;
	}
	
	private String insides(String string) {
		if (string.startsWith("\"") && string.endsWith("\"")) {
			return string.substring(1, string.length()-1);
		}
		return string;
	}
}
