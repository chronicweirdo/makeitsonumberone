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
	 * Enter a parse tree produced by {@link JBONParser#pChar}.
	 * @param ctx the parse tree
	 */
	void enterPChar(@NotNull JBONParser.PCharContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#pChar}.
	 * @param ctx the parse tree
	 */
	void exitPChar(@NotNull JBONParser.PCharContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#pDouble}.
	 * @param ctx the parse tree
	 */
	void enterPDouble(@NotNull JBONParser.PDoubleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#pDouble}.
	 * @param ctx the parse tree
	 */
	void exitPDouble(@NotNull JBONParser.PDoubleContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#pFloat}.
	 * @param ctx the parse tree
	 */
	void enterPFloat(@NotNull JBONParser.PFloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#pFloat}.
	 * @param ctx the parse tree
	 */
	void exitPFloat(@NotNull JBONParser.PFloatContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#pInt}.
	 * @param ctx the parse tree
	 */
	void enterPInt(@NotNull JBONParser.PIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#pInt}.
	 * @param ctx the parse tree
	 */
	void exitPInt(@NotNull JBONParser.PIntContext ctx);

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
	 * Enter a parse tree produced by {@link JBONParser#pBoolean}.
	 * @param ctx the parse tree
	 */
	void enterPBoolean(@NotNull JBONParser.PBooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#pBoolean}.
	 * @param ctx the parse tree
	 */
	void exitPBoolean(@NotNull JBONParser.PBooleanContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#pNull}.
	 * @param ctx the parse tree
	 */
	void enterPNull(@NotNull JBONParser.PNullContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#pNull}.
	 * @param ctx the parse tree
	 */
	void exitPNull(@NotNull JBONParser.PNullContext ctx);

	/**
	 * Enter a parse tree produced by {@link JBONParser#pString}.
	 * @param ctx the parse tree
	 */
	void enterPString(@NotNull JBONParser.PStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#pString}.
	 * @param ctx the parse tree
	 */
	void exitPString(@NotNull JBONParser.PStringContext ctx);

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
	 * Enter a parse tree produced by {@link JBONParser#pLong}.
	 * @param ctx the parse tree
	 */
	void enterPLong(@NotNull JBONParser.PLongContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBONParser#pLong}.
	 * @param ctx the parse tree
	 */
	void exitPLong(@NotNull JBONParser.PLongContext ctx);

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