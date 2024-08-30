import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static int counter = 0;

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		N = io.nextInt();
		String string = io.next();
		int length = string.length();
		for(int i=0; i<length-2; i++){
		    int g = 0, h = 0;
            if(string.charAt(i) == 'G') g++;
            else h++;
            if(string.charAt(i+1) == 'G') g++;
            else h++;
			for(int j=3; j<length-i+1; j++){
			    if(g > 1 && h > 1) break;
				if(string.charAt(i+j-1) == 'G') g++;
				else h++;
				if(g == 1 || h == 1) counter++;
			}
		}
		System.out.println(counter);



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