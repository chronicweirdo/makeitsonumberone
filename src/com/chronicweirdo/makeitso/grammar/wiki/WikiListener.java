// Generated from src/com/chronicweirdo/makeitso/grammar/wiki/Wiki.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.wiki;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WikiParser}.
 */
public interface WikiListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WikiParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull WikiParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikiParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull WikiParser.TextContext ctx);

	/**
	 * Enter a parse tree produced by {@link WikiParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(@NotNull WikiParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikiParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(@NotNull WikiParser.PageContext ctx);

	/**
	 * Enter a parse tree produced by {@link WikiParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(@NotNull WikiParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikiParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(@NotNull WikiParser.TagContext ctx);

	/**
	 * Enter a parse tree produced by {@link WikiParser#link}.
	 * @param ctx the parse tree
	 */
	void enterLink(@NotNull WikiParser.LinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikiParser#link}.
	 * @param ctx the parse tree
	 */
	void exitLink(@NotNull WikiParser.LinkContext ctx);

	/**
	 * Enter a parse tree produced by {@link WikiParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull WikiParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikiParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull WikiParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link WikiParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull WikiParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikiParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull WikiParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link WikiParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(@NotNull WikiParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikiParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(@NotNull WikiParser.SectionContext ctx);
}