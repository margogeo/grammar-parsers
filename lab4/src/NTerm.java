import java.util.ArrayList;

public class NTerm {
    public String name;
    public String inhArg = "";
    public String synthArg = "";
    public ArrayList<ArrayList<Opt>> opts;

    NTerm(String n) {
        name = n;
    }
}
