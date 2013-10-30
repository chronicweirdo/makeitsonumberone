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
	 * Enter a parse tree produced by {@link JonParser#p_long}.
	 * @param ctx the parse tree
	 */
	void enterP_long(@NotNull JonParser.P_longContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#p_long}.
	 * @param ctx the parse tree
	 */
	void exitP_long(@NotNull JonParser.P_longContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#p_boolean}.
	 * @param ctx the parse tree
	 */
	void enterP_boolean(@NotNull JonParser.P_booleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#p_boolean}.
	 * @param ctx the parse tree
	 */
	void exitP_boolean(@NotNull JonParser.P_booleanContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#p_string}.
	 * @param ctx the parse tree
	 */
	void enterP_string(@NotNull JonParser.P_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#p_string}.
	 * @param ctx the parse tree
	 */
	void exitP_string(@NotNull JonParser.P_stringContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#p_double}.
	 * @param ctx the parse tree
	 */
	void enterP_double(@NotNull JonParser.P_doubleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#p_double}.
	 * @param ctx the parse tree
	 */
	void exitP_double(@NotNull JonParser.P_doubleContext ctx);

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
	 * Enter a parse tree produced by {@link JonParser#p_int}.
	 * @param ctx the parse tree
	 */
	void enterP_int(@NotNull JonParser.P_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#p_int}.
	 * @param ctx the parse tree
	 */
	void exitP_int(@NotNull JonParser.P_intContext ctx);

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
	 * Enter a parse tree produced by {@link JonParser#p_char}.
	 * @param ctx the parse tree
	 */
	void enterP_char(@NotNull JonParser.P_charContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#p_char}.
	 * @param ctx the parse tree
	 */
	void exitP_char(@NotNull JonParser.P_charContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(@NotNull JonParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(@NotNull JonParser.EntryContext ctx);

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
	 * Enter a parse tree produced by {@link JonParser#p_float}.
	 * @param ctx the parse tree
	 */
	void enterP_float(@NotNull JonParser.P_floatContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#p_float}.
	 * @param ctx the parse tree
	 */
	void exitP_float(@NotNull JonParser.P_floatContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive(@NotNull JonParser.PrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive(@NotNull JonParser.PrimitiveContext ctx);

	/**
	 * Enter a parse tree produced by {@link JonParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(@NotNull JonParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JonParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(@NotNull JonParser.KeyContext ctx);
}