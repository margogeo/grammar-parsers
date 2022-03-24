package p2;
import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main{
	static int ind = -1;
    public static void main(String[] args) {
        String ex = "((abc*b|a)?ab(aa|b?)b)*";
		try {
			Tree answer = (new Parser()).parse(ex);
			try {
				saveTree(answer);
			} catch (IOException e) {
				System.out.println(e);
			}
		} catch (ParseException e) {
			System.out.println(e);
		}
	
    }
	
	public static void saveTree(Tree root) throws IOException {
		try {
			PrintWriter fos = new PrintWriter(new FileOutputStream("Graph.dot"));
			fos.println("digraph G {");
			dfs(root, -1, fos);
			fos.println("}");
			fos.close();
		} catch (FileNotFoundException fnf){
			System.err.println("File not found error");
			return;
		}
		try {		
			Process p = Runtime.getRuntime().exec("rdot.cmd");
			p.waitFor();
		} catch (InterruptedException ex){
			System.err.println(ex);
			return;
		}
	}
	
	public static void dfs(Tree t, int pind, PrintWriter fos) {
		ind++;
		fos.println(ind + " [label = \"" + t.node + "\"]");
		if (pind > -1) 
			fos.println(pind + " -> " + ind);
		int p = ind;
		if(t.children != null)
		for (Tree ch : t.children) {
			dfs(ch, p, fos);
		}
	}
	
}