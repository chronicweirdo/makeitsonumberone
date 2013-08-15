package com.chronicweirdo.exocortex.prototype0.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.antlr.v4.runtime.misc.NotNull;

import com.chronicweirdo.exocortex.prototype0.Fields;
import com.chronicweirdo.exocortex.prototype0.Types;
import com.chronicweirdo.exocortex.prototype0.parser.ExocortexParser.AddContext;
import com.chronicweirdo.exocortex.prototype0.parser.ExocortexParser.ArrayContext;
import com.chronicweirdo.exocortex.prototype0.parser.ExocortexParser.DefineContext;
import com.chronicweirdo.exocortex.prototype0.parser.ExocortexParser.EntryContext;
import com.chronicweirdo.exocortex.prototype0.parser.ExocortexParser.MapContext;
import com.chronicweirdo.exocortex.prototype0.parser.ExocortexParser.ReferenceContext;
import com.chronicweirdo.exocortex.prototype0.parser.ExocortexParser.ReferenceElementContext;
import com.chronicweirdo.exocortex.prototype0.parser.ExocortexParser.StatementContext;
import com.chronicweirdo.exocortex.prototype0.parser.ExocortexParser.ValueContext;

public class ExocortexListenerImpl extends ExocortexBaseListener {

	private Map<String, Object> variables = new HashMap<String, Object>();
	
	public Map<String, Object> getVariables() {
		return variables;
	}

	@Override
	public void exitDefine(@NotNull DefineContext ctx) {
		String name = ctx.ID().getText();
		if (ctx.value() != null) {
			Object value = parseValue(ctx.value());
			variables.put(name, value);
		} else if (ctx.reference() != null) {
			Object value = parseReference(ctx.reference());
			variables.put(name, value);
		}
	}

	@Override
	public void exitAdd(@NotNull AddContext ctx) {
		Map value = parseMap(ctx.map());
		if (ctx.ID() != null) {
			variables.put(ctx.ID().getText(), value);
		} else {
			variables.put(UUID.randomUUID().toString(), value);
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
	private Map<String, Object> parseArray(ArrayContext ctx) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer index = 0;
		for (ValueContext ectx: ctx.value()) {
			Object value = parseValue(ectx);
			map.put(index.toString(), value);
			index++;
		}
		map.put(Fields.SIZE, index);
		map.put(Fields.TYPE, Types.ARRAY);
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
		} else if (ctx.map() != null) {
			return parseMap(ctx.map());
		} else if (ctx.array() != null) {
			return parseArray(ctx.array());
		}
		return null;
	}
	
	private String insides(String string) {
		if (string.startsWith("\"") && string.endsWith("\"")) {
			return string.substring(1, string.length()-1);
		}
		return string;
	}

	@Override
	public void exitValue(@NotNull ValueContext ctx) {
		if (ctx.getParent() instanceof StatementContext) {
			Object value = parseValue(ctx);
			if (value != null) {
				System.out.println(value.toString());
			} else {
				System.out.println("null");
			}
		}
	}
	@Override
	public void exitReference(@NotNull ReferenceContext ctx) {
		if (ctx.getParent() instanceof StatementContext) {
			Object value = parseReference(ctx);
			if (value != null) {
				System.out.println(value.toString());
			} else {
				System.out.println("null");
			}
		}
	}
	
	private Object parseReference(ReferenceContext ctx) {
		String variable = ctx.ID().getText();
		Object result = variables.get(variable);
		for (ReferenceElementContext e: ctx.referenceElement()) {
			if (result instanceof Map) {
				if (e.ID() != null) {
					result = ((Map)result).get(e.ID().getText());
				} else {
					result = ((Map)result).get(e.NUMBER().getText());
				}
			} else {
				return result;
			}
		}
		return result;
	}
}
