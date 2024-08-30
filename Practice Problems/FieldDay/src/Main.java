import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, C;
    static ArrayList<String> teams = new ArrayList<>();
    static Count[][] prefix;


    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("fieldday");
        C = io.nextInt();
        N = io.nextInt();
        prefix = new Count[C+1][N+1];
        for (int i=0; i<N; i++){
            teams.add(io.next());
        }
        for (Count[] c: prefix){
            Arrays.fill(c, new Count(0, 0));
        }
        for (int i=0; i<C; i++){
            Count[] arr = new Count[N+1];
            arr[0] = new Count(0, 0);
            for (int j=1; j<N+1; j++){
                if(teams.get(j-1).charAt(i) == 'G') arr[j] = new Count(arr[j-1].G+1, arr[j-1].H);
                else arr[j] = new Count(arr[j-1].G, arr[j-1].H+1);
            }
            prefix[i] = arr;
        }
        for (Count[] c: prefix){
            System.out.println(Arrays.toString(c));
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<C; j++){


            }
        }



    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Count{
    int G;
    int H;

    public Count(int G, int H){
        this.G = G;
        this.H = H;
    }

    @Override
    public String toString() {
        return "(" + G + ", " + H + ")";
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