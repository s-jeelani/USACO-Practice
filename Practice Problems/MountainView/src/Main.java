import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<Peak> peaks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("mountains");
        N = io.nextInt();
        for (int i=0; i<N; i++){
            peaks.add(new Peak(io.nextInt(), io.nextInt()));
        }
        Collections.sort(peaks);
        int largestEnd = peaks.get(0).b2;
        int curStart = peaks.get(0).b1;
        int num = 1;
        for (int i=1; i<peaks.size(); i++){
            if(peaks.get(i).b2 > largestEnd){
                num++;
                curStart = peaks.get(i).b1;
                largestEnd = peaks.get(i).b2;
            }
        }
        io.write(num+"");
        io.close();

    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}


class Peak implements Comparable<Peak>{
    int x;
    int y;
    int b1;
    int b2;

    public Peak(int x, int y){
        this.x = x;
        this.y = y;
        b1 = x-y;
        b2 = x+y;
    }

    @Override
    public String toString() {
        return "Peak{" +
                "x=" + x +
                ", y=" + y +
                ", b1=" + b1 +
                ", b2=" + b2 +
                '}';
    }

    @Override
    public int compareTo(Peak o) {
        if(o.b1 != b1) return Integer.compare(this.b1, o.b1);
        return -Integer.compare(b2, o.b2);
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