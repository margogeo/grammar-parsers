import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class LexerGenerator {
    public static void generateLexer(ArrayList<Term> terms) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/gen/Lexer.java"));
            StringBuilder tokens = new StringBuilder();
            for (var x : terms) {
                tokens.append("\t\ttput(\"" + x.name + "\", \"" + x.regex.substring(2, x.regex.length() - 2) + "\");\n");
            }
            writer.write("package gen;\n" +
                    "\n" +
                    "import java.io.*;\n" +
                    "import java.text.ParseException;\n" +
                    "import java.util.*;\n" +
                    "import java.util.regex.Pattern;\n" +
                    "\n" +
                    "public class Lexer {\n" +
                    "    public final InputStream is;\n" +
                    "    public int curChar;\n" +
                    "    public int curPos;\n" +
                    "    public String curToken;\n" +
                    "    public String curStr;\n" +
                    "    public final Map<String, Pattern> lexTokens = new LinkedHashMap<>();\n" +
                    "\n" +
                    "\tprivate void tput(String k, String v) {\n" +
                    "\t\tlexTokens.put(k, Pattern.compile(v));\n" +
                    "\t}\n\n" +
                    "    public Lexer(InputStream is) throws ParseException {\n" +
                    "        this.is = is;\n" +
                    "        curPos = 0;\n" +
                    "        nextChar();\n" +
                    "" + tokens.toString() + "\n" +
                    "    }\n" +
                    "\n" +
                    "    private void nextChar() throws ParseException {\n" +
                    "        curPos++;\n" +
                    "        try {\n" +
                    "            curChar = is.read();\n" +
                    "        } catch (IOException e) {\n" +
                    "            throw new ParseException(e.getMessage(), curPos);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    public void nextToken() throws ParseException {\n" +
                    "        while (Character.isWhitespace(curChar))\n" +
                    "            nextChar();\n" +
                    "        if (curChar == -1) {\n" +
                    "            curToken = \"EOF\";\n" +
                    "            curStr = \"\";\n" +
                    "            return;\n" +
                    "        }\n" +
                    "        StringBuilder sb = new StringBuilder();\n" +
                    "        String resTokenName = \"\";\n" +
                    "        boolean flag;\n" +
                    "        while (true) {\n" +
                    "            sb.append((char) curChar);\n" +
                    "            flag = false;\n" +
                    "            for (var s : lexTokens.entrySet()) {\n" +
                    "                Pattern p = s.getValue();\n" +
                    "                if (p.matcher(sb.toString()).matches()) {\n" +
                    "                    resTokenName = s.getKey();\n" +
                    "                    flag = true;\n" +
                    "                    break;\n" +
                    "                }\n" +
                    "            }\n" +
                    "            nextChar();\n" +
                    "            if (flag) break;\n" +
                    "            if (curChar == -1)\n" +
                    "                throw new ParseException(\"Unknown token \" + sb.toString(), curPos);\n" +
                    "        }\n" +
                    "\n" +
                    "        while (true) {\n" +
                    "\t\t\tsb.append((char) curChar);\n" +
                    "\t\t\tflag = false;\n" +
                    "\t\t\tfor (var s : lexTokens.entrySet()) {\n" +
                    "\t\t\t\tPattern p = s.getValue();\n" +
                    "\t\t\t\tif (p.matcher(sb.toString()).matches()) {\n" +
                    "\t\t\t\t\tresTokenName = s.getKey();\n" +
                    "\t\t\t\t\tflag = true;\n" +
                    "\t\t\t\t\tbreak;\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t}\n" +
                    "\t\t\tif (!flag) {\n" +
                    "\t\t\t\tsb.deleteCharAt(sb.length() - 1);\n" +
                    "\t\t\t\tbreak;\n" +
                    "\t\t\t}\n" +
                    "\t\t\tnextChar();\n" +
                    "\t\t}\n" +
                    "\n" +
                    "        curToken = resTokenName;\n" +
                    "        curStr = sb.toString();\n" +
                    "    }\n" +
                    "}");
            writer.close();
        }
        catch (Exception e) {
            System.err.println("Some problems while writing to file" + e.getMessage());
        }
    }
}
