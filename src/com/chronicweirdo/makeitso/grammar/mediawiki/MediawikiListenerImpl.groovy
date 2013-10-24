package com.chronicweirdo.makeitso.grammar.mediawiki

import com.chronicweirdo.makeitso.grammar.mediawiki.MediawikiParser.TemplateContext;

class MediawikiListenerImpl extends MediawikiBaseListener {

	@Override
	public void exitTemplate(TemplateContext ctx) {
		println "template: " + ctx.getText();
	}

	/*@Override
	public void exitText(TextContext ctx) {
		println "text: " + ctx.getText();
	}*/

	
}
