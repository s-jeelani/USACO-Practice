import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<Pair> map = new ArrayList<>();

    static class Pair implements Comparable<Pair> {
        String k; int v;
        public Pair(String k, int v) { this.k = k; this.v = v;}
        public int compareTo(Pair y) { return Integer.compare(v, y.v); }

        @Override
        public String toString() {
            return "Pair{" +
                    "k='" + k + '\'' +
                    ", v=" + v +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("notlast");
        N = io.nextInt();
        for (int i=0; i<N; i++){
            for (Pair p: map){
                if(p.k ==)
            }
            map.add(new Pair(io.next(), io.nextInt()));
        }
        Collections.sort(map);
        boolean first = true;
        int min = -1;
        Pair x = null;
        for(Pair p: map){
            if(first){
                min = p.v;
                first=false;
            } else{
                if(min != p.v){
                   x = p;
                }
            }
        }
        assert x != null;
        io.write(x.k);
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