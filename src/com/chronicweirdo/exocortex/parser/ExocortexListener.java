// Generated from src\com\chronicweirdo\exocortex\parser\Exocortex.g4 by ANTLR 4.1

package com.chronicweirdo.exocortex.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExocortexParser}.
 */
public interface ExocortexListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExocortexParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(@NotNull ExocortexParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(@NotNull ExocortexParser.DefineContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExocortexParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(@NotNull ExocortexParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(@NotNull ExocortexParser.QueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExocortexParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(@NotNull ExocortexParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(@NotNull ExocortexParser.EntryContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExocortexParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull ExocortexParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull ExocortexParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExocortexParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(@NotNull ExocortexParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(@NotNull ExocortexParser.MapContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExocortexParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive(@NotNull ExocortexParser.PrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive(@NotNull ExocortexParser.PrimitiveContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExocortexParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(@NotNull ExocortexParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(@NotNull ExocortexParser.KeyContext ctx);
}