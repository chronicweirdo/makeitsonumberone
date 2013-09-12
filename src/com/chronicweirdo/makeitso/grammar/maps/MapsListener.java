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
	 * Enter a parse tree produced by {@link MapsParser#functionLong}.
	 * @param ctx the parse tree
	 */
	void enterFunctionLong(@NotNull MapsParser.FunctionLongContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#functionLong}.
	 * @param ctx the parse tree
	 */
	void exitFunctionLong(@NotNull MapsParser.FunctionLongContext ctx);

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
	 * Enter a parse tree produced by {@link MapsParser#functionShort}.
	 * @param ctx the parse tree
	 */
	void enterFunctionShort(@NotNull MapsParser.FunctionShortContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#functionShort}.
	 * @param ctx the parse tree
	 */
	void exitFunctionShort(@NotNull MapsParser.FunctionShortContext ctx);

	/**
	 * Enter a parse tree produced by {@link MapsParser#functionSet}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSet(@NotNull MapsParser.FunctionSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#functionSet}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSet(@NotNull MapsParser.FunctionSetContext ctx);

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
	 * Enter a parse tree produced by {@link MapsParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(@NotNull MapsParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(@NotNull MapsParser.PathContext ctx);

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
	 * Enter a parse tree produced by {@link MapsParser#functionGet}.
	 * @param ctx the parse tree
	 */
	void enterFunctionGet(@NotNull MapsParser.FunctionGetContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapsParser#functionGet}.
	 * @param ctx the parse tree
	 */
	void exitFunctionGet(@NotNull MapsParser.FunctionGetContext ctx);

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
}