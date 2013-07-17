import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;



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
	}

}
