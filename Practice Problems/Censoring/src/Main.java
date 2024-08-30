import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static String string;
    static String newString = "";
    static String censor;
    static int length;
    static ArrayList<Integer> q = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    	Kattio io = new Kattio("censor");
		string = io.next();
		censor = io.next();
		length = string.length();
		while (true){
		    if(string.length() == 0) break;

		    if(!string.endsWith(censor)){
		        newString += string.charAt(string.length()-1);
		        string = string.substring(0, string.length()-1);
            }
		    else string = string.substring(0, string.length()-censor.length());
		    System.out.println(string);
        }





		io.write(newString);
		io.close();









    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}







@SuppressWarnings("ALL")
class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;

    // standard input
    public Kattio() {
        this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    // USACO-style file input
    public Kattio(String problemName) throws IOException {
        super(new FileWriter(problemName + ".out"));
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }

    // returns null if no more input
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {
            return null;
        }

    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}