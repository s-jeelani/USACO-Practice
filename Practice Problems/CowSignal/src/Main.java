import java.io.*;

import java.util.*;

/*
Cow Signal
O(n^4)
*/

public class Main {
    static int M, N, K;
    static ArrayList<ArrayList<Character>> amplifiedSignal = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("cowsignal");
		M = io.nextInt(); N = io.nextInt(); K = io.nextInt();
		for (int i=0; i<M; i++){
		    ArrayList<Character> chars = new ArrayList<>();
		    char[] s = io.next().toCharArray();
		    for (int j=0; j<N; j++){
		        Character c = s[j];
                chars.add(c);
		        for (int k=0; k<K-1; k++) chars.add(chars.size()-1,c);
            }
		    amplifiedSignal.add(chars);
            for (int k=0; k<K-1; k++) amplifiedSignal.add(amplifiedSignal.size()-1, chars);
        }
		for (ArrayList<Character> charList : amplifiedSignal){
		    for (Character c: charList){
		        io.write(c);
            }
		    io.write('\n');
        }
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