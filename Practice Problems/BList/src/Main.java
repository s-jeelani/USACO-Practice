import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static int bucketsAvailable = 0;
    static int bucketsUsed = 0;
    static HashMap<Integer, Pair> cows = new HashMap<>();
    static TreeMap<Integer, Pair> startedMilking = new TreeMap<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("blist");
		N = io.nextInt();
		for (int i = 0; i<N; i++){
			cows.put(io.nextInt(), new Pair(io.nextInt(), io.nextInt()));
		}
		TreeMap<Integer, Pair> cowsSorted = new TreeMap<>(cows);
		for (int i=1; i<1001; i++){
		    if(cowsSorted.isEmpty()) break;
			if(cowsSorted.firstKey() == i){
				bucketsAvailable -= cowsSorted.get(cowsSorted.firstKey()).b;
				if(bucketsAvailable < 0){
					bucketsUsed += -1 * bucketsAvailable;
					bucketsAvailable = 0;
				}
                Map.Entry<Integer, Pair> e = cowsSorted.pollFirstEntry();
				startedMilking.put(e.getKey(), e.getValue());
			}
            TreeMap<Integer, Pair> newSet = new TreeMap<>();
			for (Map.Entry<Integer, Pair> e : startedMilking.entrySet()){
				if(e.getValue().t == i) bucketsAvailable += e.getValue().b;
				else newSet.put(e.getKey(), e.getValue());
			}
			startedMilking = newSet;
		}
		io.write(String.valueOf(bucketsUsed));
		io.close();









    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Pair{
	int t;
	int b;

	public Pair(int t, int b){
		this.t = t;
		this.b = b;
	}

    @Override
    public String toString() {
        return "Pair{" +
                "t=" + t +
                ", b=" + b +
                '}';
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