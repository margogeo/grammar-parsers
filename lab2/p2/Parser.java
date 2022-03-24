package p2;
import java.io.InputStream;
import java.text.ParseException;
import p2.Token;

public class Parser {
    LexicalAnalyzer lex;
    Tree E() throws ParseException {
		//log("E");
		return new Tree("E", T(), EPrime());
    }
	void log(String s) {
		System.out.println(s + " " + lex.pos() + " " + lex.curToken());
	}
	
    Tree T() throws ParseException {
		//log("T");
        return new Tree("T", H(), TPrime());
    }
    Tree EPrime() throws ParseException {
		//log("EPrime");
        switch (lex.curToken()) {
            case R:
            case END:
                return new Tree("E'", new Tree("eps"));
            case OR:
                lex.nextToken();
                return new Tree("E'",new Tree("|"), T(), EPrime());
            default:
                throw new AssertionError("wrong character at " + lex.curPos());
        }
    }
    Tree TPrime() throws ParseException {
		//log("TPrime");
        switch (lex.curToken()) {
			case OR:
			case R:
            case END:
                return new Tree("T'", new Tree("eps"));
            case CLINI:
                lex.nextToken();
                return new Tree("T'", new Tree("*"), TPrime());
            default:
                return new Tree("T'", H(), TPrime());
        }
    }
	Tree H() throws ParseException {
		return new Tree("H", K(), HPrime());
	}
	Tree HPrime() throws ParseException {
		 switch (lex.curToken()) {
            case QUESTION:
                lex.nextToken();
                return new Tree("H'", new Tree("?"));
            default:
                return new Tree("H'", new Tree("eps")); 
        }
	}
    Tree K() throws ParseException {
		//log("H");
        switch (lex.curToken()) {
            case LETTER:
				lex.nextToken();
                return new Tree("K", new Tree("a"));
            case L:
                lex.nextToken();
                Tree par = E();
				Token temp = lex.curToken();
                if(temp != Token.R)
                    throw new AssertionError("Unclosed parenthese: " + temp + " instead of )");
			    lex.nextToken();
                return new Tree("K",new Tree("L"), par, new Tree("R"));
            default:
                throw new AssertionError("wrong character at " + lex.pos());
        }
    }
    Tree parse(String is) throws ParseException{
        lex = new LexicalAnalyzer(is);
        lex.nextToken();
        return E();
    }
}