import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class FirstFollow extends GrammarBaseListener {

    public ArrayList<NTerm> nTerms = new ArrayList<>();
    public ArrayList<Term> terms = new ArrayList<>();
    public String start = "";
    public LinkedHashMap<String, LinkedHashSet<String>> FIRST = new LinkedHashMap<>();
    public LinkedHashMap<String, LinkedHashSet<String>> FOLLOW = new LinkedHashMap<>();

    @Override public void exitStart(GrammarParser.StartContext ctx) {
        for (NTerm x : nTerms) {
                FIRST.put(x.name, new LinkedHashSet<>());
                FOLLOW.put(x.name, new LinkedHashSet<>());
                if (start.length() == 0)
                    start = x.name;
            }
        generateFirst();
        generateFollow();

        LinkedHashSet<String> attrs = NodeGenerator.generateNode(nTerms);
        LexerGenerator.generateLexer(terms);
        ParserGenerator.generateParser(nTerms, FIRST, attrs, FOLLOW, start);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/gen/Main.java"));
            writer.write("package gen;\n" +
                    "\n" +
                    "import java.io.*;\n" +
                    "import java.nio.charset.StandardCharsets;\n" +
                    "import java.nio.file.*;\n" +
                    "\n" +
                    "public class Main {\n" +
                    "\n" +
                    "    static StringBuilder build(Node node, long c, StringBuilder res) {\n" +
                    "        res.append(\"a\" + c + \" [label=\\\"\" + node.type + \"\\\"];\\n\");\n" +
                    "        for (int i = 0; i < node.children.size(); i++) {\n" +
                    "            long newIdx = c * 4 + i;\n" +
                    "            build(node.children.get(i), newIdx, res);\n" +
                    "            res.append(\"a\" + c + \" -- a\" + newIdx + \";\\n\");\n" +
                    "        }\n" +
                    "        return res;\n" +
                    "    }\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "        for (int i = 1; i < 4; i++) {\n" +
                    "            try {\n" +
                    "                String inp = Files.readString(Path.of(\"test/calc/in/\" + i + \".in\"));\n" +
                    "                Node ans = new Parser(new Lexer(new ByteArrayInputStream(inp.getBytes(StandardCharsets.UTF_8)))).parse();\n" +
                    "                FileWriter writer = new FileWriter(\"test/calc/out/\" + i + \".dot\");\n" +
                    "                writer.write(\"graph example {\\n\" + build(ans, 1, new StringBuilder()).toString() + \"}\");\n" +
                    "                writer.close();\n" +
                    "            } catch (Exception e) {\n" +
                    "                e.printStackTrace();\n" +
                    "            }\n" +
                    "        }\n" +
                    "        System.out.println(\"All tests completed\");\n" +
                    "    }\n" +
                    "}");
            writer.close();
        } catch (Exception e) {
            System.err.println("Some problems while writing to file" + e.getMessage());
        }
    }

    private void generateFirst() {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (NTerm x : nTerms) {
                for (ArrayList<Opt> y : x.opts) {
                    for (Opt z : y) {
                        if (z.type == 2) {
                            int old = FIRST.get(x.name).size();
                            LinkedHashSet<String> newlst = FIRST.get(x.name);
                            newlst.add(z.name);
                            FIRST.replace(x.name, newlst);
                            if (newlst.size() != old)
                                changed = true;
                            if (!z.name.equals("EPS"))
                                break;
                        }
                        else if (z.type == 1) {
                            int old = FIRST.get(x.name).size();
                            LinkedHashSet<String> newlst = FIRST.get(x.name);
                            var st = FIRST.get(z.name);
                            newlst.addAll(st);
                            FIRST.replace(x.name, newlst);
                            if (newlst.size() != old)
                                changed = true;
                            if (!st.contains("EPS"))
                                break;
                        }
                    }
                }
            }
        }
    }

    private void generateFollow() {
        LinkedHashSet<String> s = new LinkedHashSet<>();
        s.add("EOF");
        FOLLOW.replace(start, s);

        boolean changed = true;
        while (changed) {
            changed = false;
            for (NTerm x : nTerms) {
                for (ArrayList<Opt> y : x.opts) {
                    LinkedHashSet<String> g = new LinkedHashSet<>();
                    g.add("EPS");
                    ArrayList<Opt> y2 = new ArrayList<>();
                    for (Opt z : y)
                        if (z.type != 0)
                            y2.add(z);
                    for (int i = y2.size() - 1; i > -1; i--) {
                        if (y2.get(i).type == 1) {
                            int old = FOLLOW.get(y2.get(i).name).size();
                            LinkedHashSet<String> newlst = FOLLOW.get(y2.get(i).name);
                            if (!newlst.contains("EPS")) {
                                newlst.addAll(g);
                                if (g.contains("EPS"))
                                    newlst.remove("EPS");
                            } else
                                newlst.addAll(g);
                            if (g.contains("EPS"))
                                newlst.addAll(FOLLOW.get(x.name));
                            if (newlst.size() != old)
                                changed = true;
                            FOLLOW.replace(y2.get(i).name, newlst);
                        }
                        if (y2.get(i).name.equals("EPS"))
                            g.add(y2.get(i).name);
                        else if (y2.get(i).type == 1 && FIRST.get(y2.get(i).name).contains("EPS"))
                            g.addAll(FIRST.get(y2.get(i).name));
                        else {
                            g.clear();
                            if (y2.get(i).type == 1)
                                g.addAll(FIRST.get(y2.get(i).name));
                            else g.add(y2.get(i).name);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void exitNTerm(GrammarParser.NTermContext ctx) {
        nTerms.add(ctx.ntr);
    }

    @Override
    public void exitTerm(GrammarParser.TermContext ctx) {
        terms.add(ctx.tr);
    }
}