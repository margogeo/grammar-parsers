package gen;

import java.util.ArrayList;

public class Node {
    public String type;
    public String text;
    public ArrayList<Node> children = new ArrayList<>();
	int val;


    Node(String t) {
        type = t;
    }

    Node(String t, String v) {
        type = t;
        text = v;
    }

    void addChild(Node x) {
        children.add(x);
    }
}