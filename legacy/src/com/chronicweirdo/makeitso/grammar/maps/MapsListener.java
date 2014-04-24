// Generated from src/com/chronicweirdo/makeitso/grammar/maps/Maps.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.maps;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MapsParser}.
 */
public interface MapsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MapsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull MapsParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull MapsParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#get}.
	 * @param ctx the parse tree
	 */
	void enterGet(@NotNull MapsParser.GetContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#get}.
	 * @param ctx the parse tree
	 */
	void exitGet(@NotNull MapsParser.GetContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(@NotNull MapsParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(@NotNull MapsParser.SetContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull MapsParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull MapsParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(@NotNull MapsParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(@NotNull MapsParser.EntryContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(@NotNull MapsParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(@NotNull MapsParser.MapContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#base}.
	 * @param ctx the parse tree
	 */
	void enterBase(@NotNull MapsParser.BaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#base}.
	 * @param ctx the parse tree
	 */
	void exitBase(@NotNull MapsParser.BaseContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull MapsParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull MapsParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(@NotNull MapsParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(@NotNull MapsParser.ListContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(@NotNull MapsParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(@NotNull MapsParser.KeyContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull MapsParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull MapsParser.FunctionContext ctx);
}