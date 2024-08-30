import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int[] numbers = new int[7];
    static int abc, a, b , c;

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		for (int i=0; i<7; i++){
			numbers[i] = io.nextInt();
		}
		Arrays.sort(numbers);
		abc = numbers[6];
		a = numbers[0];
		b = numbers[1];
		c = abc-a-b;
        System.out.println(a + " " + b + " " + c);




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