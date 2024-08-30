import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, K;
    static int[][] barn = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("paintbarn");
        N = io.nextInt();
        K = io.nextInt();

        for (int i=0; i<N; i++){
            int x1 = io.nextInt();
            int x2 = io.nextInt();
            int y1 = io.nextInt();
            int y2 = io.nextInt();
            barn[x1][x2]++;
            barn[x1][y2]--;
            barn[y1][x2]--;
            barn[y1][y2]++;

        }


        int count = 0;
        for(int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (i != 0) barn[i][j] += barn[i - 1][j];
                if (j != 0) barn[i][j] += barn[i][j - 1];
                if (i != 0 && j != 0) barn[i][j] -= barn[i - 1][j - 1];
                if (barn[i][j] == K) count++;
            }

        }
        io.write(count + "");
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