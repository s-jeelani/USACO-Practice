import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, K, B;
    static int[] crossroads;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("maxcross");
        N = io.nextInt();
        K = io.nextInt();
        B = io.nextInt();
        crossroads = new int[N];
        Arrays.fill(crossroads, 0);
        for (int i=0; i<B; i++) {
            crossroads[io.nextInt()-1] = 1;
        }
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> prefixes = new ArrayList<>();
        prefixes.add(0);
        for (int i =0; i<N; i++){
            prefixes.add(prefixes.get(i)+crossroads[i]);
        }

        for (int i=0; i<N-K+1; i++) {
            int count = 0;
            count = prefixes.get(i+K) - prefixes.get(i);
            if(count < min) min = count;
        }
        io.write(min + "");
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