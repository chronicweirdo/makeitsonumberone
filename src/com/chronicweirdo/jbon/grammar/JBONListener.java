// Generated from src/com/chronicweirdo/jbon/grammar/JBON.g4 by ANTLR 4.1

package com.chronicweirdo.jbon.grammar;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JBONParser}.
 */
public interface JBONListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JBONParser#p_long}.
	 * @param ctx the parse tree
	 */
	void enterP_long(@NotNull JBONParser.P_longContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#p_long}.
	 * @param ctx the parse tree
	 */
	void exitP_long(@NotNull JBONParser.P_longContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#p_boolean}.
	 * @param ctx the parse tree
	 */
	void enterP_boolean(@NotNull JBONParser.P_booleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#p_boolean}.
	 * @param ctx the parse tree
	 */
	void exitP_boolean(@NotNull JBONParser.P_booleanContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#p_string}.
	 * @param ctx the parse tree
	 */
	void enterP_string(@NotNull JBONParser.P_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#p_string}.
	 * @param ctx the parse tree
	 */
	void exitP_string(@NotNull JBONParser.P_stringContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#p_double}.
	 * @param ctx the parse tree
	 */
	void enterP_double(@NotNull JBONParser.P_doubleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#p_double}.
	 * @param ctx the parse tree
	 */
	void exitP_double(@NotNull JBONParser.P_doubleContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(@NotNull JBONParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(@NotNull JBONParser.ListContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(@NotNull JBONParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(@NotNull JBONParser.ObjectContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#p_int}.
	 * @param ctx the parse tree
	 */
	void enterP_int(@NotNull JBONParser.P_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#p_int}.
	 * @param ctx the parse tree
	 */
	void exitP_int(@NotNull JBONParser.P_intContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull JBONParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull JBONParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#p_char}.
	 * @param ctx the parse tree
	 */
	void enterP_char(@NotNull JBONParser.P_charContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#p_char}.
	 * @param ctx the parse tree
	 */
	void exitP_char(@NotNull JBONParser.P_charContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull JBONParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull JBONParser.FileContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(@NotNull JBONParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(@NotNull JBONParser.EntryContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(@NotNull JBONParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(@NotNull JBONParser.MapContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull JBONParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull JBONParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#p_float}.
	 * @param ctx the parse tree
	 */
	void enterP_float(@NotNull JBONParser.P_floatContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#p_float}.
	 * @param ctx the parse tree
	 */
	void exitP_float(@NotNull JBONParser.P_floatContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive(@NotNull JBONParser.PrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive(@NotNull JBONParser.PrimitiveContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(@NotNull JBONParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(@NotNull JBONParser.KeyContext ctx);
}