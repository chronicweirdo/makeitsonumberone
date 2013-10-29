// Generated from src/com/chronicweirdo/jon/grammar/Jon.g4 by ANTLR 4.1

package com.chronicweirdo.jon.grammar;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JonParser}.
 */
public interface JonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JonParser#typeString}.
	 * @param ctx the parse tree
	 */
	void enterTypeString(@NotNull JonParser.TypeStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#typeString}.
	 * @param ctx the parse tree
	 */
	void exitTypeString(@NotNull JonParser.TypeStringContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#listEntry}.
	 * @param ctx the parse tree
	 */
	void enterListEntry(@NotNull JonParser.ListEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#listEntry}.
	 * @param ctx the parse tree
	 */
	void exitListEntry(@NotNull JonParser.ListEntryContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull JonParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull JonParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#mapEntry}.
	 * @param ctx the parse tree
	 */
	void enterMapEntry(@NotNull JonParser.MapEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#mapEntry}.
	 * @param ctx the parse tree
	 */
	void exitMapEntry(@NotNull JonParser.MapEntryContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(@NotNull JonParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(@NotNull JonParser.MapContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#mapEntryValue}.
	 * @param ctx the parse tree
	 */
	void enterMapEntryValue(@NotNull JonParser.MapEntryValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#mapEntryValue}.
	 * @param ctx the parse tree
	 */
	void exitMapEntryValue(@NotNull JonParser.MapEntryValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(@NotNull JonParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(@NotNull JonParser.ListContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(@NotNull JonParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(@NotNull JonParser.ObjectContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull JonParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull JonParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#mapEntryKey}.
	 * @param ctx the parse tree
	 */
	void enterMapEntryKey(@NotNull JonParser.MapEntryKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#mapEntryKey}.
	 * @param ctx the parse tree
	 */
	void exitMapEntryKey(@NotNull JonParser.MapEntryKeyContext ctx);
}