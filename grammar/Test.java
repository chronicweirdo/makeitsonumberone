import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;



public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloLexer l = new HelloLexer(new ANTLRInputStream("hello bunny"));
		CommonTokenStream tokens = new CommonTokenStream(l);
		//tokens.setTokenSource(l);
		HelloParser p = new HelloParser(tokens);
		p.setBuildParseTree(true);
	    p.addParseListener(new HelloBaseListener() {
			@Override
			public void visitTerminal(@NotNull TerminalNode node) {
				super.visitTerminal(node);
				System.out.println("visiting terminal node");
			}
	    	
	    });
	    
        ParserRuleContext tree = p.r();
	    
        //int result = visitor.visit(tree);
        //System.out.println("Result: " + result);
	    
	    //p.
		System.out.println("done");
	}

}
