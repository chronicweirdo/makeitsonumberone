// Generated from src/com/chronicweirdo/makeitso/grammar/mediawiki/Mediawiki.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.mediawiki;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MediawikiParser}.
 */
public interface MediawikiListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MediawikiParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(@NotNull MediawikiParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediawikiParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(@NotNull MediawikiParser.TemplateContext ctx);

	/**
	 * Enter a parse tree produced by {@link MediawikiParser#templatePropertyValue}.
	 * @param ctx the parse tree
	 */
	void enterTemplatePropertyValue(@NotNull MediawikiParser.TemplatePropertyValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediawikiParser#templatePropertyValue}.
	 * @param ctx the parse tree
	 */
	void exitTemplatePropertyValue(@NotNull MediawikiParser.TemplatePropertyValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link MediawikiParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(@NotNull MediawikiParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediawikiParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(@NotNull MediawikiParser.PageContext ctx);

	/**
	 * Enter a parse tree produced by {@link MediawikiParser#templateProperty}.
	 * @param ctx the parse tree
	 */
	void enterTemplateProperty(@NotNull MediawikiParser.TemplatePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediawikiParser#templateProperty}.
	 * @param ctx the parse tree
	 */
	void exitTemplateProperty(@NotNull MediawikiParser.TemplatePropertyContext ctx);

	/**
	 * Enter a parse tree produced by {@link MediawikiParser#templatePropertyName}.
	 * @param ctx the parse tree
	 */
	void enterTemplatePropertyName(@NotNull MediawikiParser.TemplatePropertyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediawikiParser#templatePropertyName}.
	 * @param ctx the parse tree
	 */
	void exitTemplatePropertyName(@NotNull MediawikiParser.TemplatePropertyNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link MediawikiParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(@NotNull MediawikiParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediawikiParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(@NotNull MediawikiParser.SectionContext ctx);

	/**
	 * Enter a parse tree produced by {@link MediawikiParser#templateName}.
	 * @param ctx the parse tree
	 */
	void enterTemplateName(@NotNull MediawikiParser.TemplateNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediawikiParser#templateName}.
	 * @param ctx the parse tree
	 */
	void exitTemplateName(@NotNull MediawikiParser.TemplateNameContext ctx);
}