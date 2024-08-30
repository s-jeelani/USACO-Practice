import java.io.*;
import java.util.*;

public class Main {
    static int N, T, X;
    static ArrayList<Rect> targets = new ArrayList<>();
    static int[] slopes;
    static

    public static void main(String[] args) throws IOException {
            Kattio io = new Kattio();
            T = io.nextInt();
            for (int i=0; i<T; i++){
                N = io.nextInt();
                X = io.nextInt();
                slopes = new int[N];
                for (int j=0; j<N; j++){
                    targets.add(new Rect(j, io.nextInt(), io.nextInt(), io.nextInt()));
                }
                for (int j=0; j<N; j++){
                    slopes[j] = io.nextInt();
                }




            }

    }

}

class Rect{
    int n;
    int x2;
    int y1;
    int y2; //top right y


    public Rect(int n, int y1, int y2, int x2){
        this.n = n;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

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