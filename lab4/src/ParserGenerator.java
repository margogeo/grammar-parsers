import java.io.*;
import java.util.*;

public class ParserGenerator {
    public static void generateParser(ArrayList<NTerm> nTerms, LinkedHashMap<String, LinkedHashSet<String>> FIRST,
                                      LinkedHashSet<String> attrs, LinkedHashMap<String, LinkedHashSet<String>> FOLLOW,
                                      String start) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/gen/Parser.java"));
            StringBuilder methods = new StringBuilder();
            for (var x : nTerms) {
                StringBuilder method = new StringBuilder();
                String args = x.inhArg.isEmpty() ? "" : x.inhArg.substring(1, x.inhArg.length() - 1);
                method.append("public Node " + x.name + "(" + args + ") throws ParseException {\n");
                method.append("\tNode res = new Node(\"" + x.name + "\");\n\tswitch (lex.curToken) {\n");
                boolean check = false;
                StringBuilder epsCode = new StringBuilder();
                for (var y : x.opts) {
                    StringBuilder tokens = new StringBuilder();
                    LinkedHashSet<String> ts = new LinkedHashSet<>();
                    for (var z : y) {
                        if (z.type == 2) {
                            ts.add(z.name);
                            if (!z.name.equals("EPS"))
                                break;
                        } else if (z.type == 1) {
                            ts.addAll(FIRST.get(z.name));
                            if (!FIRST.get(z.name).contains("EPS"))
                                break;
                        }
                    }
                    int c = 0;
                    for (var t : ts) {
                        if (t.equals("EPS")) {
                            check = true;
                            continue;
                        }
                        if (c != 0)
                            tokens.append(", ");
                        tokens.append("\"" + t + "\"");
                        c++;
                    }
                    if (tokens.isEmpty()) {
                        for (var z : y) {
                            if (z.type == 0) {
                                String code = z.name.substring(2, z.name.length() - 2);
                                for (var argName : attrs)
                                    code = code.replace("$" + argName, "res." + argName);
                                epsCode.append(code + "\n");
                            }
                        }
                        continue;
                    }
                    method.append("\t\tcase " + tokens + " -> {\n");
                    for (var z : y) {
                        if (z.type == 1) {
                            String arg = z.arg.isEmpty() ? "" : z.arg.substring(1, z.arg.length() - 1);
                            method.append("\t\t\tNode $" + z.name + " = " + z.name + "(" + arg + ");\n\t\t\tres.addChild($" + z.name + ");\n");
                        } else if (z.type == 0) {
                            String code = z.name.substring(2, z.name.length() - 2);
                            for (var argName : attrs) {
                                code = code.replace("$" + argName, "res." + argName);
                            }
                            method.append("\t\t\t" + code + "\n");
                        } else {
                            method.append("\t\t\tNode $" + z.name + " = new Node(\"" + z.name + "\", lex.curStr);\n\t\t\tres.addChild($" + z.name+ ");\n\t\t\tlex.nextToken();\n");
                        }
                    }
                    method.append("\t\t}\n");
                }
                if (check) {
                    StringBuilder tokens = new StringBuilder();
                    int c = 0;
                    for (var t : FOLLOW.get(x.name)) {
                        if (t.equals("EPS")) {
                            continue;
                        }
                        if (c != 0)
                            tokens.append(", ");
                        tokens.append("\"" + t + "\"");
                        c++;
                    }
                    method.append("\t\tcase " + tokens + " -> {\n\t\t\tres.addChild(new Node(\"EPS\"));\n\t\t\t" + epsCode + "\t\t}\n");
                }
                method.append("\t\tdefault -> throw new ParseException(\"Unexpected token \" + lex.curToken, lex.curPos);\n\t}\n\treturn res;\n}\n");
                methods.append(method + "\n");
            }
            writer.write("package gen;\n" +
                    "\n" +
                    "import java.text.ParseException;\n"
                    + "\n" +
                    "public class Parser {\n" +
                    "    public final Lexer lex;\n" +
                    "\t" + "\n" +
                    "\tpublic Parser(Lexer lex) {\n" +
                    "\t\tthis.lex = lex;\n" +
                    "\t}\n" +
                    "\n" +
                    "    " + methods.toString() + "\n" +
                    "\n" +
                    "    public Node parse() throws ParseException {\n" +
                    "        lex.nextToken();\n" +
                    "        return " + start + "();\n" +
                    "    }\n" +
                    "}");
            writer.close();
        }
        catch (Exception e) {
            System.err.println("Some problems while writing to file" + e.getMessage());
        }
    }
}
