package gen;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Main {

    static StringBuilder build(Node node, long c, StringBuilder res) {
        res.append("a" + c + " [label=\"" + node.type + "\"];\n");
        for (int i = 0; i < node.children.size(); i++) {
            long newIdx = c * 4 + i;
            build(node.children.get(i), newIdx, res);
            res.append("a" + c + " -- a" + newIdx + ";\n");
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 4; i++) {
            try {
                String inp = Files.readString(Path.of("test/calc/in/" + i + ".in"));
                Node ans = new Parser(new Lexer(new ByteArrayInputStream(inp.getBytes(StandardCharsets.UTF_8)))).parse();
                FileWriter writer = new FileWriter("test/calc/out/" + i + ".dot");
                writer.write("graph example {\n" + build(ans, 1, new StringBuilder()).toString() + "}");
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("All tests completed");
    }
}