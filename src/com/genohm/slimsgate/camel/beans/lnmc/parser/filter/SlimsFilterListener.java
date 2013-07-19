// Generated from src/com/genohm/slimsgate/camel/beans/lnmc/parser/filter/SlimsFilter.g4 by ANTLR 4.1

package com.genohm.slimsgate.camel.beans.lnmc.parser.filter;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SlimsFilterParser}.
 */
public interface SlimsFilterListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#limit}.
	 * @param ctx the parse tree
	 */
	void enterLimit(@NotNull SlimsFilterParser.LimitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#limit}.
	 * @param ctx the parse tree
	 */
	void exitLimit(@NotNull SlimsFilterParser.LimitContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#formatExpression}.
	 * @param ctx the parse tree
	 */
	void enterFormatExpression(@NotNull SlimsFilterParser.FormatExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#formatExpression}.
	 * @param ctx the parse tree
	 */
	void exitFormatExpression(@NotNull SlimsFilterParser.FormatExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(@NotNull SlimsFilterParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(@NotNull SlimsFilterParser.QueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#direction}.
	 * @param ctx the parse tree
	 */
	void enterDirection(@NotNull SlimsFilterParser.DirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#direction}.
	 * @param ctx the parse tree
	 */
	void exitDirection(@NotNull SlimsFilterParser.DirectionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(@NotNull SlimsFilterParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(@NotNull SlimsFilterParser.AttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#orderTerm}.
	 * @param ctx the parse tree
	 */
	void enterOrderTerm(@NotNull SlimsFilterParser.OrderTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#orderTerm}.
	 * @param ctx the parse tree
	 */
	void exitOrderTerm(@NotNull SlimsFilterParser.OrderTermContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#from}.
	 * @param ctx the parse tree
	 */
	void enterFrom(@NotNull SlimsFilterParser.FromContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#from}.
	 * @param ctx the parse tree
	 */
	void exitFrom(@NotNull SlimsFilterParser.FromContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#formatAttribute}.
	 * @param ctx the parse tree
	 */
	void enterFormatAttribute(@NotNull SlimsFilterParser.FormatAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#formatAttribute}.
	 * @param ctx the parse tree
	 */
	void exitFormatAttribute(@NotNull SlimsFilterParser.FormatAttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#formatQuery}.
	 * @param ctx the parse tree
	 */
	void enterFormatQuery(@NotNull SlimsFilterParser.FormatQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#formatQuery}.
	 * @param ctx the parse tree
	 */
	void exitFormatQuery(@NotNull SlimsFilterParser.FormatQueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#formatName}.
	 * @param ctx the parse tree
	 */
	void enterFormatName(@NotNull SlimsFilterParser.FormatNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#formatName}.
	 * @param ctx the parse tree
	 */
	void exitFormatName(@NotNull SlimsFilterParser.FormatNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#datatypeSelection}.
	 * @param ctx the parse tree
	 */
	void enterDatatypeSelection(@NotNull SlimsFilterParser.DatatypeSelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#datatypeSelection}.
	 * @param ctx the parse tree
	 */
	void exitDatatypeSelection(@NotNull SlimsFilterParser.DatatypeSelectionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(@NotNull SlimsFilterParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(@NotNull SlimsFilterParser.SourceContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#order}.
	 * @param ctx the parse tree
	 */
	void enterOrder(@NotNull SlimsFilterParser.OrderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#order}.
	 * @param ctx the parse tree
	 */
	void exitOrder(@NotNull SlimsFilterParser.OrderContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttributeValue(@NotNull SlimsFilterParser.AttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttributeValue(@NotNull SlimsFilterParser.AttributeValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#filterTerm}.
	 * @param ctx the parse tree
	 */
	void enterFilterTerm(@NotNull SlimsFilterParser.FilterTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#filterTerm}.
	 * @param ctx the parse tree
	 */
	void exitFilterTerm(@NotNull SlimsFilterParser.FilterTermContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#fetchQuery}.
	 * @param ctx the parse tree
	 */
	void enterFetchQuery(@NotNull SlimsFilterParser.FetchQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#fetchQuery}.
	 * @param ctx the parse tree
	 */
	void exitFetchQuery(@NotNull SlimsFilterParser.FetchQueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#formatLink}.
	 * @param ctx the parse tree
	 */
	void enterFormatLink(@NotNull SlimsFilterParser.FormatLinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#formatLink}.
	 * @param ctx the parse tree
	 */
	void exitFormatLink(@NotNull SlimsFilterParser.FormatLinkContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#datatypeName}.
	 * @param ctx the parse tree
	 */
	void enterDatatypeName(@NotNull SlimsFilterParser.DatatypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#datatypeName}.
	 * @param ctx the parse tree
	 */
	void exitDatatypeName(@NotNull SlimsFilterParser.DatatypeNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter(@NotNull SlimsFilterParser.FilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter(@NotNull SlimsFilterParser.FilterContext ctx);

	/**
	 * Enter a parse tree produced by {@link SlimsFilterParser#formatQueryTerm}.
	 * @param ctx the parse tree
	 */
	void enterFormatQueryTerm(@NotNull SlimsFilterParser.FormatQueryTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SlimsFilterParser#formatQueryTerm}.
	 * @param ctx the parse tree
	 */
	void exitFormatQueryTerm(@NotNull SlimsFilterParser.FormatQueryTermContext ctx);
}