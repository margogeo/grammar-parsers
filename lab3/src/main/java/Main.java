public class Main {
	public static void main(String[] args) throws Exception {
		String inp = "def f(a):\n" +
				"\treturn __g__(a)\n" +
				"\n" +
				"print(f(1))\n" +
				"\n" +
				"def __g__(b):\n" +
				"\treturn f(b)\n" +
				"\n" +
				"print(__g__(2))\n" +
				"bb = int(input())\n" +
				"\n" +
				"ab = f(1) + __g__(2) + f(__g__(bb))\n" +
				"print(ab)";
		System.out.println(InputParser.parseString(inp));
	}
}
