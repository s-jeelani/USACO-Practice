import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, T=0;
    static ArrayList<Pair> cows = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("cowqueue");
		N = io.nextInt();
		for (int i=0; i<N; i++){
		    cows.add(new Pair(io.nextInt(), io.nextInt()));
        }
		boolean first = true;
        int min; Pair p; int a=0;
		while (true){
            min = Integer.MAX_VALUE;
            p = null;
		    if(cows.isEmpty()) break;
            for (int i=0; i<cows.size(); i++){
                if(cows.get(i).k < min){
                    min = cows.get(i).k;
                    p = cows.get(i);
                }
            }

            assert p != null;
            if(first){

                T += p.k+p.v;
                first = false;
            } else{
                if(T < p.k) T = p.k;
                T += p.v;
            }
            cows.remove(p);
            a++;
        }





		/*
        Map.Entry<Integer, Integer> e;
        e = cows.pollLastEntry();
        T += e.getKey() + e.getValue();
		for (int i=0; i<length; i++){

		    if(cows.isEmpty()) break;
		    e = cows.pollLastEntry();
            if(T < e.getKey()) T = e.getKey();
            T += e.getValue();

        }

		 */
        io.write(T+"");
        io.close();












    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Pair{
    final int k;
    final int v;

    public Pair(int k, int v){
        this.k = k;
        this.v = v;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "k=" + k +
                ", v=" + v +
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