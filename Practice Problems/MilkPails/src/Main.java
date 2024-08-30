import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int X, Y, M, min= Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("pails");
		X = io.nextInt(); Y = io.nextInt(); M = io.nextInt();
		for (int i=0; i<Math.floorDiv(M, Y)+1; i++){
			if(((M-Y*i) % X) < min) min = ((M-Y*i) % X);
		}
		io.write(M-min + "");
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