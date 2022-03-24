package p2;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class LexicalAnalyzer{
    String is;
    int curChar;
    int curPos;
    Token curToken;

    public LexicalAnalyzer(String is) throws ParseException {
        this.is = is;
        curPos = 0;
        nextChar();
    }
	
	public int pos() {
		return curPos;
	}

    private boolean isBlank(int c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    private void nextChar() {
        curPos++;
        curChar = curPos < is.length() ? is.charAt(curPos - 1) : -1;
    }

    public Token nextToken() throws ParseException {
        while (isBlank(curChar)) {
            nextChar();
        }
        switch (curChar) {
            case '(':
                nextChar();
                curToken = Token.L;
                break;
            case ')':
                nextChar();
                curToken = Token.R;
                break;
            case '*':
                nextChar();
                curToken = Token.CLINI;
                break;
            case '|':
                nextChar();
                curToken = Token.OR;
                break;
			case '?':
                nextChar();
                curToken = Token.QUESTION;
                break;
            case -1:
                curToken = Token.END;
                break;
            default:
                if ('a' <= curChar && curChar <= 'z') {
                    nextChar();
                    curToken = Token.LETTER;
                    break;
                }
                throw new ParseException("Illegal character " + (char)curChar, curPos);
        }
        return curToken;
    }

    public Token curToken() {
        return curToken;
    }

    public int curPos() {
        return curPos;
    }
}
