import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] potions;
    static int[][] adjL;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("pm");
        N = io.nextInt();
        adjL = new int[N+1][N+1];
        potions = new int[N+1];
        for (int i=1; i<N+1; i++){
            potions[i] = io.nextInt();
        }
        for (int i=1; i<N; i++){
            int a = io.nextInt();
            int b = io.nextInt();
            adjL[a][b] = 1;
            adjL[b][a] = 1;
        }
        for (int i=1; i<N+1; i++){
            System.out.println(Arrays.toString(adjL[i]));
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