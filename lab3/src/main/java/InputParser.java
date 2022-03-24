import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

public class InputParser {

	public static String parseString(String inputString) throws IOException {
		return parseStream(new ByteArrayInputStream(inputString.getBytes()));
	}

	public static String parseStream(InputStream is) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(is);
		ObfuscatorLexer lexer = new ObfuscatorLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return (new ObfuscatorParser(tokens)).program().value;
	}
}
