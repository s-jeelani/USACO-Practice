import java.io.*;
import java.util.*;

import static java.lang.Math.floor;

public class Main {
    static double a, b, m, T;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        T = io.nextDouble();
        for(int i=0; i<T; i++){
           a = io.nextDouble();
           b = io.nextDouble();
           m = io.nextDouble();
           if()
           System.out.println((long)(floor(m/a) + floor(m/b))+2L);
        }

    }

}


@SuppressWarnings("ALL")
class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;

    public Kattio() {
        this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(String problemName) throws IOException {
        super(new FileWriter(problemName + ".out"));
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }

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