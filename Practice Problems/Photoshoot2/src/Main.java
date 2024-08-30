import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<Integer> cows = new ArrayList<>();
	static ArrayList<Integer> desiredCows = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		N = io.nextInt();
		for (int i=0; i<N; i++){
			cows.add(io.nextInt());

		}
		for (int i=0; i<N; i++){
            desiredCows.add(io.nextInt());
        }
		Collections.reverse(cows);
		Collections.reverse(desiredCows);
		int counter=0, x=-1, t=cows.size()-1;
		while (check()){
			for (int i=cows.size()-1; i>-1; i--){
				if(desiredCows.get(t).equals(cows.get(i))){
					x = i;
					break;
				}
			}
			if(t == x){
				t--;
				continue;
			}
			int r = cows.get(x);
			cows.remove(x);
			cows.add(t, r);
			counter++;
			t--;

		}
		System.out.println(counter);













    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }

    private static boolean check(){
    	for (int i=0; i<N; i++){
    		if(!(cows.get(i).equals(desiredCows.get(i)))) return true;
		}
    	return false;
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