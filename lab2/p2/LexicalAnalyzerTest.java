package p2;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import p2.*;

import java.util.List;

public class LexicalAnalyzerTest {

    public static void test(String input) {
		try {
			if (checkResult(new LexicalAnalyzer(input)))
				System.err.println("Lexic analyser. Accepted input : " + input); 
			else 
				System.err.println("Lexic analyser. Wrong output for : " + input); 
		} catch(ParseException e) {
			System.err.println("Parse test unexpected exception: " + e + " on input: " +  input);
		}		
    }

    public static void errorTest(String input) {
		try {	
			checkResult(new LexicalAnalyzer(input));
		}	catch(ParseException e) {
			System.err.println("Lexic analyser expected exception: " + e + " on wrong input: " +  input);
		}				
    }

    private static boolean checkResult(LexicalAnalyzer a) throws ParseException {
        a.nextToken();
        for (var token : List.of(Token.L, Token.LETTER, Token.CLINI, Token.LETTER, Token.OR, Token.LETTER, Token.R, Token.END)) {
            if(a.curToken() != token) {
				System.err.println("Lexic analyser, expected: " + token + " but found: " +  a.curToken());
				return false;
			}
            a.nextToken();
        }
		return true;
    }
	
	public static void main(String[] args) {
		test("(a*b|a)*");
		test("\t  (a  *\n b| a) *");
		errorTest("&(\t  (a  bc*\n B| a) *a b( aa\n| b* ) b)*");
	}
}