// Generated from src\com\chronicweirdo\exocortex\parser\Exocortex.g4 by ANTLR 4.1

package com.chronicweirdo.exocortex.prototype0.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExocortexParser}.
 */
public interface ExocortexListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExocortexParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull ExocortexParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull ExocortexParser.StatementContext ctx);

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
	 * Enter a parse tree produced by {@link ExocortexParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull ExocortexParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull ExocortexParser.ProgramContext ctx);

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
	 * Enter a parse tree produced by {@link ExocortexParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(@NotNull ExocortexParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(@NotNull ExocortexParser.AddContext ctx);

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
	 * Enter a parse tree produced by {@link ExocortexParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(@NotNull ExocortexParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(@NotNull ExocortexParser.ReferenceContext ctx);

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

	/**
	 * Enter a parse tree produced by {@link ExocortexParser#referenceElement}.
	 * @param ctx the parse tree
	 */
	void enterReferenceElement(@NotNull ExocortexParser.ReferenceElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#referenceElement}.
	 * @param ctx the parse tree
	 */
	void exitReferenceElement(@NotNull ExocortexParser.ReferenceElementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ExocortexParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(@NotNull ExocortexParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExocortexParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(@NotNull ExocortexParser.ArrayContext ctx);
}