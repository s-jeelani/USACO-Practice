import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static TreeMap<Integer, Integer> shifts = new TreeMap<>();


    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("lifeguards");
		N = io.nextInt();
		for (int i=0; i<N; i++){
			shifts.put(io.nextInt(), io.nextInt());
		}
		for(Map.Entry<Integer, Integer> e : shifts.entrySet()){

		    int counter = 0;
		    for (int t=1; t<1001; t++){
		        for (Map.Entry<Integer, Integer> e1 : shifts.entrySet()){
		            if(e.equals(e1)) continue;
		            if(e1.getKey() <= t && e1.getValue() > t){
		                counter++;
		                break;
                    }
                }
            }
		    if(counter > max) max = counter;
        }
		io.write(max + "");
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