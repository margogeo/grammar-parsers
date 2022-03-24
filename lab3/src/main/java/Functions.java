import java.util.stream.Collectors;

public class Functions {
	static String sc = "O0I1";
	static String opList = "+-*/";

	public static String encode(String vname) {
		String ret = "O";
		for (int i = 0; i < vname.length(); i++) {
			int k = vname.charAt(i);
			while (k > 0) {
				int e = k & 3;
				ret = ret + sc.substring(e, e + 1);
				k >>= 2;
			}
		}
		return ret;
	}

	static int iRand(int iMin, int iMax) {
	  return iMin + (int)(Math.random() * (iMax - iMin));
	}

	static String randName() {
		int nameLength = iRand(2,4);
		String ret = "";
		for (int i = 0; i < nameLength; i++) {
			int c = iRand('0', 'z');
			while (c > 0) {
				int e = c & 3;
				ret = ret + sc.substring(e, e + 1);
				c >>= 2;
			}
		}
		return ret;
	}

	public static String fake(int tabs) {
		double check = Math.random();
		String add1 = "\n";
		String add = "\n";
		if (tabs > 0) {
			add += "\t";
			add1 = "\t";
		}
		if (tabs > 1) {
			add += "\t";
			add1 = "\t\t";
		}
		if (tabs == 3) {
			add1 = "\n\t";
			add = add1;
		}
		if (check < 0.5)
			return add1;
		String leftVal = "I" + randName();
		int op = iRand(0,7);
		String firstOp = ((op & 1) > 0) ? "O" + randName() :  String.valueOf(iRand(1, 9999));
		int iOp = iRand(0,3);
		String sOp = opList.substring(iOp,iOp + 1);
		String secondOp = ((op & 4) > 0) ? "I" + randName() :  String.valueOf(iRand(1, 9999));
		return  add1 + leftVal + " = " + firstOp + sOp + secondOp + add;
	}
}
