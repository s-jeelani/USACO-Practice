import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, K;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("lazycow");
        N = io.nextInt();
        K = io.nextInt();
        grid = new int[N][N];
        for (int i = 0; i <N; i++){
            for (int j=0; j<N; j++){
                grid[i][j] = io.nextInt();
            }

        }
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){

            }
        }

    }

    private static int[][] calc2DPrefixSum(int[][] grid){
        int[][] prefix = new int[N+1][N+1];
        prefix[1][1] = grid[0][0];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(i != 0) prefix[i+1][j+1] += prefix[i][j+1] + grid[i][j];
                if(j != 0) prefix[i+1][j+1] += prefix[i+1][j] + grid[i][j];
                if(i != 0 && j != 0) prefix[i+1][j+1] -= (grid[i][j] + prefix[i][j]);
            }

        }
        return prefix;
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