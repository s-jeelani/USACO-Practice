import java.io.*;
import java.util.*;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

public class Main {
    static int a,b,c, tents, T;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        T = io.nextInt();
        for (int i =0; i<T; i++){
            System.out.println(ans(io));
        }

    }

    private static int ans(Kattio io){
        tents = 0;
        a = io.nextInt();
        b = io.nextInt();
        c = io.nextInt();
        tents += a;
        tents += (b - (b % 3))/3;
        b = b % 3;
        if(b + c < 3 && b != 0) return -1;
        tents += ceil((b+c)/3.0000);
        return tents;
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