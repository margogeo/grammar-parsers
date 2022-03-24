import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) {

        GrammarLexer lexer = new GrammarLexer(CharStreams.fromString("""
start : expr {:System.out.println($expr.val);:};
expr returns [int val] : term exprP[$term.val] {:$val = $exprP.val;:};
exprP [int i] returns [int val] : EPS {:$val=i;:} | PLUS term exprP[i+$term.val] {:$val=$exprP.val;:} | SUB term exprP[i-$term.val] {:$val=$exprP.val;:};
term returns [int val] : fact termP[$fact.val] {:$val = $termP.val;:};
termP[int i] returns [int val] : EPS {:$val=i;:} | MUL fact termP[i*$fact.val] {:$val=$termP.val;:} | DIV fact termP[$fact.val] {:$val=i/$termP.val;:};
fact returns [int val] : L expr R {:$val=$expr.val;:} | NUMBER {:$val=Integer.parseInt($NUMBER.text);:};
NUMBER : [[[0-9]+]];
PLUS : [[\\\\+]];
MUL : [[\\\\*]];
SUB : [[-]];
DIV : [[/]];
L : [[\\\\(]];
R : [[\\\\)]];
				"""));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.start();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new FirstFollow(), tree);
    }
}
