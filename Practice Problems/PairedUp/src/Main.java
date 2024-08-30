import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, l, r, t=Integer.MIN_VALUE;
    static ArrayList<Cow> cows = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("pairup");
		N = io.nextInt();
		for (int i=0; i<N; i++){
            int x = io.nextInt();
            int y = io.nextInt();
            cows.add(new Cow(x, y));


		}
        Collections.sort(cows);
        l = 0;
        r = cows.size() -1;
        Cow L, R;
        while (r-l > 0){
            L = cows.get(l);
            R = cows.get(r);
            if(R.val + L.val > t) t= R.val + L.val;
            R.count--;
            L.count--;
            if(L.count == 0) l++;
            if(R.count == 0) r--;
        }
        io.write(t+"");
        io.close();

    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Cow implements Comparable<Cow>{
    int count;
    int val;

    public Cow(int x, int y){
        this.count = x;
        this.val = y;
    }


    @Override
    public int compareTo(Cow o) {
        return Integer.compare(val, o.val);
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