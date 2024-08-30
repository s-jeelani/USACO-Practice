import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int T;
    static ArrayList<Integer> paths = new ArrayList<>();
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		T = io.nextInt();
		int N, K;
		String[] grid;
		for(int i=0; i<T; i++){
			N = io.nextInt(); K = io.nextInt();
			grid = new String[N];
			for(int j=0; j<N; j++){
				grid[j] = io.next();
			}
			paths.add(checkCase(N, K, grid));
		}
		for(Integer i: paths){
		    System.out.println(i);
        }
    








    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }

    public static int checkCase(int N, int K, String[] grid){
    	int counter = 0;
    	if(K == 1){
    		if(simulate("D".repeat(N-1)+"R".repeat(N-1), grid)) counter++;
			if(simulate("R".repeat(N-1)+"D".repeat(N-1), grid)) counter++;
		} else if(K == 2){
            HashSet<String> set = new HashSet<>();
			for(int i=0; i<N-1; i++){
			    set.add("D".repeat(i)+"R".repeat(N-1)+"D".repeat(N-1-i));
			    set.add("R".repeat(i)+"D".repeat(N-1)+"R".repeat(N-1-i));
			}
			for(String s : set){
			    if(simulate(s, grid)) counter++;
            }
		} else{
    		//K == 3
            HashSet<String> set = new HashSet<>();
            for(int i=0; i<=N-1; i++){
                for(int j=0; j<=N-1; j++){
                    set.add("D".repeat(i)+"R".repeat(j)+"D".repeat(N-1-i)+"R".repeat(N-1-j));
                    set.add("R".repeat(i)+"D".repeat(j)+"R".repeat(N-1-i)+"D".repeat(N-1-j));
                }
            }
            for(String s : set){
                if(simulate(s, grid)) counter++;
            }

		}
    	return counter;




	}

	public static boolean simulate(String s, String[] grid){
        int x=0, y=0;
        for(char c: s.toCharArray()){
            if(c == 'D') y++;
            else x++;
            if(grid[y].charAt(x) == 'H') return false;
        }
        return x == grid.length - 1 && y == grid.length - 1;
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