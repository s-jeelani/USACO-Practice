import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static String x;
    static ArrayList<Character> a = new ArrayList<>();
	static ArrayList<Character> b = new ArrayList<>();
	static ArrayList<Integer> sub = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("breedflip");
		N = io.nextInt();
		x = io.next();
		for (char c: x.toCharArray()){
			a.add(c);
		}
		x = io.next();
		for (char c: x.toCharArray()){
			b.add(c);
		}
		for (int i=0; i<N; i++){
			int length=0;
			for (int j=i; j<N; j++){
				if(a.get(j) != b.get(j)) length++;
				else break;
			}
			sub.add(length);
		}
		int changes = 0;
		while (checkZers()){
		    int counter=0, index=-1, max = Integer.MIN_VALUE;
		    for (Integer i: sub){
		        if(i > max){
		            max = i;
		            index = counter;
                }
		        counter++;
            }
		    String s = "";
		    for (int i=index; i<index+max; i++){
                sub.set(i, 0);
            }

		    changes++;
        }
		io.write(changes+"");
		io.close();









	}

	private static boolean checkZers(){
        for (Integer i: sub){
            if(i != 0) return true;
        }
        return false;
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