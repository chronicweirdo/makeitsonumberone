package com.chronicweirdo.exocortex.prototype0;

import org.antlr.v4.Tool;

public class Compile {

	public static void execute(String path) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
		    public void run() {
		    	System.out.println("done");
		    }
		});
		Tool.main(new String[] {path});
	}
	
	public static void main(String[] args) {
		execute("src\\com\\chronicweirdo\\exocortex\\prototype0\\parser\\Exocortex.g4");
		//execute("src/com/chronicweirdo/exocortex/parser/Exocortex.g4");
	}
}
