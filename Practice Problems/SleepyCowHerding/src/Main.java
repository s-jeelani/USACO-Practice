import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static ArrayList<Integer> cowPos = new ArrayList<>();
    static int min, max, max1;

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("herding");
        cowPos.add(io.nextInt());
        cowPos.add(io.nextInt());
        cowPos.add(io.nextInt());
        Collections.sort(cowPos);
        if(cowPos.get(0) + 1 == cowPos.get(1) && cowPos.get(1) + 1 == cowPos.get(2)){
            min = 0;
            max = 0;
        }
        else{
            //minimum
            if (cowPos.get(2) - 2 == cowPos.get(1) || cowPos.get(0) + 2 == cowPos.get(1)) min = 1;
            else min = 2;


            //maximum

            max = cowPos.get(1) - cowPos.get(0) - 1;
            max1 = cowPos.get(2) - cowPos.get(1) - 1;
            max = Math.max(max, max1);
        }
        io.write(min + "\n" + max);
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