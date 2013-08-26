package com.chronicweirdo.makeitso.grammar.wsp;

import org.antlr.v4.runtime.misc.NotNull;

import com.chronicweirdo.makeitso.grammar.wsp.WspParser.UploadContext;

public class WspListenerImpl extends WspBaseListener {

	@Override
	public void exitUpload(@NotNull UploadContext ctx) {
		System.out.println("uploading");
	}

	
}
