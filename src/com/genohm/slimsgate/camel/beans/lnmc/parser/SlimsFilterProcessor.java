package com.genohm.slimsgate.camel.beans.lnmc.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

import com.genohm.slims.common.request.SlimsOrder;
import com.genohm.slims.server.dao.criterion.SlimsJunction;
import com.genohm.slims.server.dao.criterion.SlimsRestrictions;
import com.genohm.slims.server.dao.request.FetchRequest;
import com.genohm.slims.server.dao.request.FetchRequestImpl;
import com.genohm.slimsgate.camel.beans.lnmc.mrna.DB;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterBaseListener;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.DatatypeSelectionContext;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.FetchQueryContext;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.FilterTermContext;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.FormatAttributeContext;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.FormatExpressionContext;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.FormatLinkContext;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.FormatQueryTermContext;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.FromContext;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.LimitContext;
import com.genohm.slimsgate.camel.beans.lnmc.parser.filter.SlimsFilterParser.OrderTermContext;

public class SlimsFilterProcessor extends SlimsFilterBaseListener {
	
	// required slims data and beans
	private DB db;
	private Map<String, Object> step;
	private Map<String, Object> experiment;
	private List<Long> stepPKs;

	// internal state variables
	private List<FetchRequest> fetchQueries = new ArrayList<FetchRequest>();
	private FetchRequest currentFetchRequest;
	private SlimsJunction currentSlimsJunction;
	private List<String> formatNames = new ArrayList<String>();
	private List<List<FormatTerm>> formatTerms = new ArrayList<List<FormatTerm>>();
	private List<FormatTerm> currentTerms;
	
	private static interface FormatTerm { String getValue(Map<String, Object> content); }
	private static class FormatAttribute implements FormatTerm {
		private String name;
		
		

		public FormatAttribute(String name) {
			super();
			this.name = name;
		}



		@Override
		public String getValue(Map<String, Object> content) {
			return content.get(name).toString();
		}
		
	}
	private static class FormatKeyword implements FormatTerm {
		private static List<String> KEYWORDS = Arrays.asList(new String[] { "type" });
		
		private String keyword;
		
		public FormatKeyword(String keyword) {
			super();
			this.keyword = keyword;
		}

		@Override
		public String getValue(Map<String, Object> content) {
			return "";
		}
	}
	private static class FormatLink implements FormatTerm {
		private String value;

		public FormatLink(String value) {
			super();
			this.value = value;
		}

		@Override
		public String getValue(Map<String, Object> content) {
			return value;
		}
	}
	
	@Override
	public void enterFetchQuery(@NotNull FetchQueryContext ctx) {
		currentFetchRequest = new FetchRequestImpl();
		currentSlimsJunction = SlimsRestrictions.and();
	}

	@Override
	public void exitFetchQuery(@NotNull FetchQueryContext ctx) {
		currentFetchRequest.setCriterion(currentSlimsJunction);
		fetchQueries.add(currentFetchRequest);
	}

	@Override
	public void exitDatatypeSelection(@NotNull DatatypeSelectionContext ctx) {
		String datatypeName = ctx.datatypeName().ID().getText();
		System.out.println("content should be of data type " + datatypeName);
		//ContentType type = db.loadType(datatypeName);
		//currentSlimsJunction.add(SlimsRestrictions.equals("cntn_fk_contentType", type.getCntp_pk()));
	}

	@Override
	public void exitFrom(@NotNull FromContext ctx) {
		System.out.println("select from step");
		//currentSlimsJunction.add(SlimsRestrictions.in("cntn_pk", stepPKs));
	}

	@Override
	public void exitFilterTerm(@NotNull FilterTermContext ctx) {
		String attributeName = ctx.attribute().ID().getText();
		System.out.print("attribute " + attributeName);
		if (ctx.attributeValue().source() != null) {
			// we are taking the attribute from the step or experiment
			String source = ctx.attributeValue().source().ID().getText();
			String sourceAttribute = ctx.attributeValue().attribute().ID().getText();
			System.out.print(" should be equal to the " + sourceAttribute
					+ " attribute from " + source);
			if (source.equals("experiment")) {
				System.out.println(" - using the experiment as source");
				//currentSlimsJunction.add(SlimsRestrictions.equals(attributeName, experiment.get(sourceAttribute)));
			} else if (source.equals("step")) {
				System.out.println(" - using the step as source");
				//currentSlimsJunction.add(SlimsRestrictions.equals(attributeName, step.get(sourceAttribute)));
			}
		} else {
			// we are giving a strict value to the attribute
			String attributeValue = ctx.attributeValue().STRING().getText();
			System.out.println(" should be equal to " + attributeValue);
			//currentSlimsJunction.add(SlimsRestrictions.equals(attributeName, attributeValue));
		}
	}

	@Override
	public void exitOrderTerm(@NotNull OrderTermContext ctx) {
		String fieldName = ctx.ID().getText();
		String direction = ctx.direction().getText();
		if (direction.equals("asc")) {
			System.out.println("ascending by " + fieldName);
			//currentFetchRequest.addOrder(SlimsOrder.asc(fieldName));
		} else if (direction.equals("desc")) {
			System.out.println("descending by " + fieldName);
			currentFetchRequest.addOrder(SlimsOrder.desc(fieldName));
		}
	}

	@Override
	public void exitLimit(@NotNull LimitContext ctx) {
		Long limit = Long.parseLong(ctx.INT().getText());
		System.out.println("limiting to " + limit + " results");
		//currentFetchRequest.setBatchSize(limit);
		//currentFetchRequest.setStartRow(0l);
	}

	@Override
	public void exitFormatAttribute(@NotNull FormatAttributeContext ctx) {
		System.out.println(ctx.getText());
		String value = ctx.ID().getText();
		if (FormatKeyword.KEYWORDS.contains(value)) {
			System.out.println("adding format keyword " + value);
			currentTerms.add(new FormatKeyword(value));
		} else {
			System.out.println("adding format attribute " + value);
			currentTerms.add(new FormatAttribute(value));
		}
	}

	@Override
	public void exitFormatLink(@NotNull FormatLinkContext ctx) {
		String value = ctx.STRING().getText();
		System.out.println("adding format link " + value);
		currentTerms.add(new FormatLink(value));
	}

	@Override
	public void exitFormatQueryTerm(@NotNull FormatQueryTermContext ctx) {
		String name = ctx.formatName().STRING().getText();
		System.out.println("adding format terms for " + name);
		formatNames.add(name);
		formatTerms.add(currentTerms);
	}

	@Override
	public void enterFormatExpression(@NotNull FormatExpressionContext ctx) {
		currentTerms = new ArrayList<FormatTerm>();
	}
	
	
	
	
}
