import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static int[] positions;
    static int[] ids, newIds;

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("shuffle");
		N = io.nextInt();
		positions = new int[N]; ids = new int[N]; newIds = new int[N];
		for (int i=0; i<N; i++){
			positions[i] = io.nextInt();
		}
		for (int i=0; i<N; i++){
			ids[i] = io.nextInt();
		}
		shuffleBack();
		for (int x: ids){
		    io.write(x + "\n");
        }
		io.close();





    }

    public static void shuffleBack(){
    	for (int k=0; k<3; k++){
			for (int i=0; i<N; i++){
				newIds[i] = ids[positions[i]-1];
			}
			ids = newIds;
			newIds = new int[N];
		}

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