package com.chronicweirdo.makeitso.grammar.mediawiki

import com.chronicweirdo.makeitso.grammar.mediawiki.MediawikiParser.TemplateContext
import com.chronicweirdo.makeitso.grammar.mediawiki.MediawikiParser.TemplateNameContext
import com.chronicweirdo.makeitso.grammar.mediawiki.MediawikiParser.TemplatePropertyContext
import com.chronicweirdo.makeitso.grammar.mediawiki.MediawikiParser.TemplatePropertyNameContext
import com.chronicweirdo.makeitso.grammar.mediawiki.MediawikiParser.TemplatePropertyValueContext

class MediawikiListenerImpl extends MediawikiBaseListener {

	@Override
	public void exitTemplate(TemplateContext ctx) {
		//println "template: " + ctx.getText();
		String name = parse(ctx.templateName());
		Map properties = [:]
		ctx.templateProperty().each { pctx -> 
			String propertyName = parse(pctx.templatePropertyName());
			String propertyValue = parse(pctx.templatePropertyValue());
			properties[propertyName] = propertyValue
		}
		println name;
		println properties;
	}
	
	String parse(TemplatePropertyNameContext ctx) {
		return ctx.getText().trim();
	}
	String parse(TemplatePropertyValueContext ctx) {
		return ctx.getText().trim();
	}
	String parse(TemplateNameContext ctx) {
		return ctx.getText().trim();
	}

	/*@Override
	public void exitText(TextContext ctx) {
		println "text: " + ctx.getText();
	}*/

	
}
