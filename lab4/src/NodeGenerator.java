import java.io.*;
import java.util.*;

public class NodeGenerator {
    public static LinkedHashSet<String> generateNode(ArrayList<NTerm> nonTerminalRules) {
        LinkedHashSet<String> synthAttrs = new LinkedHashSet<>();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/gen/Node.java"));
            StringBuilder attrs = new StringBuilder();
            LinkedHashSet<String> allAttrs = new LinkedHashSet<>();
            for (NTerm x : nonTerminalRules) {
                for (String xx : x.synthArg.split("[,\\[\\]]")) {
                    String r = xx.trim();
                    if (!r.matches("\\s*")) {
                        if (!allAttrs.contains(r))
                            attrs.append("\t" + r + ";\n");
                        allAttrs.add(r);
                        String[] str = r.split("\\s+");
                        synthAttrs.add(str[str.length - 1]);
                    }
                }
            }
            writer.write("package gen;\n" +
                    "\n" +
                    "import java.util.ArrayList;\n" +
                    "\n" +
                    "public class Node {\n" +
                    "    public String type;\n" +
                    "    public String text;\n" +
                    "    public ArrayList<Node> children = new ArrayList<>();\n" +
                    attrs.toString() + "\n" +
                    "\n" +
                    "    Node(String t) {\n" +
                    "        type = t;\n" +
                    "    }\n" +
                    "\n" +
                    "    Node(String t, String v) {\n" +
                    "        type = t;\n" +
                    "        text = v;\n" +
                    "    }\n" +
                    "\n" +
                    "    void addChild(Node x) {\n" +
                    "        children.add(x);\n" +
                    "    }\n" +
                    "}");
            writer.close();
        } catch (Exception e) {
            System.err.println("Some problems while writing to file" + e.getMessage());
        }
        return synthAttrs;
    }
}
