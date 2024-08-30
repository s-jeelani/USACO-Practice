import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, K, X=0;
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("gymnastics");
		K = io.nextInt(); N = io.nextInt();
		for (int i=0; i<K; i++){
			ArrayList<Integer> ar = new ArrayList<>();
			for (int j=0; j<N; j++){
				ar.add(io.nextInt());
			}
			lists.add(ar);
		}


		for (int i=1; i<N+1; i++){
			for (int j=i+1; j<N+1; j++){
				checkLists(i, j);
			}
		}
		io.write(X + "");
		io.close();







    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }

    private static void checkLists(int i1, int i2){
    	boolean consistent = true;
    	//greater = 1, less than = 0
		int signChange = -1;
		boolean first = true;
    	for (ArrayList<Integer> ar : lists){
    		if(first){
				if(ar.indexOf(i1) > ar.indexOf(i2)) signChange = 1;
				if(ar.indexOf(i1) < ar.indexOf(i2)) signChange = 0;
				first = false;
			}
    		if(signChange == 0){
				if(ar.indexOf(i1) > ar.indexOf(i2)){
					consistent = false;
					break;
				}
			}
    		else if(signChange == 1){
				if(ar.indexOf(i1) < ar.indexOf(i2)){
					consistent = false;
					break;
				}
			}

		}
    	if(consistent){
    	    System.out.println(i1 + " " + i2);
    	    X++;
        }
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