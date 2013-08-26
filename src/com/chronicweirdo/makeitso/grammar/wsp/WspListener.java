// Generated from /Users/cacovean/Documents/workspace/makeitso/src/com/chronicweirdo/makeitso/grammar/wsp/Wsp.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.wsp;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WspParser}.
 */
public interface WspListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WspParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull WspParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WspParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull WspParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link WspParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull WspParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link WspParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull WspParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link WspParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(@NotNull WspParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link WspParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(@NotNull WspParser.QueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link WspParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull WspParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link WspParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull WspParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link WspParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(@NotNull WspParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link WspParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(@NotNull WspParser.LineContext ctx);

	/**
	 * Enter a parse tree produced by {@link WspParser#upload}.
	 * @param ctx the parse tree
	 */
	void enterUpload(@NotNull WspParser.UploadContext ctx);
	/**
	 * Exit a parse tree produced by {@link WspParser#upload}.
	 * @param ctx the parse tree
	 */
	void exitUpload(@NotNull WspParser.UploadContext ctx);

	/**
	 * Enter a parse tree produced by {@link WspParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(@NotNull WspParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link WspParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(@NotNull WspParser.DeclareContext ctx);
}