package p2;
import java.io.InputStream;
import java.text.ParseException;
import p2.*;

public class ParserTest {
	static void test() {
		correct("((abc*b|a)*ab(aa|b*)b)*");
		correct("((abc*b|a)*ab(aa|b*)b)*");
		correct("(a|b)*");
		correct("(a)*");
		correct("(a)?");
		
		incorrect("*");
		incorrect("|");
		incorrect("((abc*b|a)*ab(aa|b*)b*");
		incorrect("a|*");
		incorrect("()*");
		incorrect("(|)*");
		incorrect(")(");
		incorrect("?");
		incorrect("(a??)*");
	}

	private static void correct(String input) {
		try {
			parse(input);
			System.out.println("Parse test: " + input + " : correct");
		}
		catch(ParseException e) {
			System.err.println("Parse test unexpected exception: " + e + " on input: " +  input);
		}
	}
	
	private static void incorrect(String input) {
		try {
			parse(input);
			System.out.println("Parse test, accepted incorrect input: " + input);
		}
		catch(ParseException | AssertionError e) {
			System.err.println("Parse test true exception: " + e + " on input: " + input); 
		}
		
	}
	
	private static Tree parse(String input) throws ParseException {
		return new Parser().parse(input);
	}
	
	 public static void main(String[] args) {
		test();	
	 }
}