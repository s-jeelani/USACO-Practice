import java.io.*;
import java.util.*;
import java.util.stream.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, K;
    static ArrayList<Integer> diamonds = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("diamond");
        N = io.nextInt(); K = io.nextInt();
        for (int i=0; i<N; i++){
            diamonds.add(io.nextInt());
        }
        Collections.sort(diamonds);
        int startNum=1; int endNum=K+1;
        int max = diamonds.get(diamonds.size()-1);
        int maximum = Integer.MIN_VALUE;
        while (endNum <= max) {
            int startIndex = 0, endIndex = diamonds.size() - 1;
            for (int i = 0; i < diamonds.size(); i++) {
                if (diamonds.get(i) >= startNum) {
                    startIndex = i;
                    break;
                }
            }
            for (int i = startIndex; i < diamonds.size(); i++) {
                    if (diamonds.get(i) > endNum) {
                        endIndex = i - 1;
                        break;
                    }
            }
            if (endIndex - startIndex > maximum) maximum = endIndex - startIndex;
            startNum++;
            endNum++;
        }
        if(N == 1) maximum = 0;
        if(maximum == Integer.MIN_VALUE) maximum = diamonds.size()-1;
        io.write(maximum+1 + "");
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