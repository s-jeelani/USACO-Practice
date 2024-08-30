import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static int temp;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("bcount");
        int N = io.nextInt();
        int Q = io.nextInt();
        ArrayList<Prefix> prefixCows = new ArrayList<>();
        ArrayList<Pair>  coords = new ArrayList<>();
        prefixCows.add(new Prefix(0, 0, 0));
        for (int i=0; i<N; i++){
            int h = 0;
            int j = 0;
            int g = 0;
            temp = io.nextInt();
            if(temp == 1) h++;
            if(temp == 2) g++;
            if(temp == 3) j++;
            Prefix prefix = new Prefix(0, 0, 0);
            prefix.h = prefixCows.get(i).h + h;
            prefix.g = prefixCows.get(i).g + g;
            prefix.j = prefixCows.get(i).j + j;
            prefixCows.add(prefix);
        }
        for (int i=0; i<Q; i++){
            coords.add(new Pair(io.nextInt(), io.nextInt()));
        }
        for (Pair p : coords){
            int h = prefixCows.get(p.b).h - prefixCows.get(p.a-1).h;
            int g = prefixCows.get(p.b).g - prefixCows.get(p.a-1).g;
            int j = prefixCows.get(p.b).j - prefixCows.get(p.a-1).j;
            io.write(h + " " + g + " " + j + "\n");


        }
        io.close();


    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}


class Prefix{
    int h;
    int g;
    int j;

    public Prefix(int h, int g, int j){
        this.h = h;
        this.g = g;
        this.j = j;
    }

    @Override
    public String toString() {
        return "Prefix{" +
                "h=" + h +
                ", g=" + g +
                ", j=" + j +
                '}';
    }
}


class Pair{
    int a;
    int b;

    public Pair(int a, int b){
        this.a = a;
        this.b = b;

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