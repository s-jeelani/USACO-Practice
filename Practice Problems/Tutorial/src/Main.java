import java.io.*;
import java.util.*;


public class Main {
    static long initL;
    static long N;
    static String s;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        s = io.next();
        N = io.nextLong();
        initL = s.length();
        long L = initL;
        while (L < N){
            L *= 2;
        }

        io.write(s.charAt((int) recursive(N-1, L)));
        io.close();
    }

    public static long recursive(long pos, long length){
        if(pos < initL) return pos;
        if(pos < (length/2)) return recursive(pos, length/2);
        return recursive((pos-1) % (length/2), length/2);
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