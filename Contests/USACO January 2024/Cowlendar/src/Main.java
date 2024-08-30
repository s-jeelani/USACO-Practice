import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] cows;
    static long min = Long.MAX_VALUE;
    static HashSet<Long> set = new HashSet<>();
    static HashSet<Long> rem = new HashSet<>();
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        N = io.nextInt();
        cows = new long[N];
        for (int i=0; i<N; i++){
            long l = io.nextLong();
            min = Math.min(min, l);
            cows[i] = l;
        }
        for (int i=0; i<N; i++){
            cows[i] -= min;
            rem.add(cows[i]);
        }

        for (int i=0; i<N-1; i++){
            for (int j=1; j<N; j++){
                set.add((Math.abs(cows[j]-cows[i])));
            }
        }
        for (Long i : set){
            sum += i;
        }
        System.out.println(sum);

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