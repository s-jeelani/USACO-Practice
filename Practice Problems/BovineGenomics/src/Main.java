import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, M, counter=0;
    static ArrayList<ArrayList<Character>> spotted = new ArrayList<>();
	static ArrayList<ArrayList<Character>> plain = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("cownomics");
		N = io.nextInt(); M = io.nextInt();
		for (int i=0; i<N; i++){
			ArrayList<Character> ar = new ArrayList<>();
			for (int j=0; j<M; j++){
				ar.add(io.nextChar());
			}
			spotted.add(ar);
		}
		for (int i=0; i<N; i++){
			ArrayList<Character> ar = new ArrayList<>();
			for (int j=0; j<M; j++){
				ar.add(io.nextChar());
			}
			plain.add(ar);
		}
		for (int i=0; i<M; i++){
			ArrayList<Character> spots = new ArrayList<>();
			ArrayList<Character> plains = new ArrayList<>();
			for (ArrayList<Character> ar : spotted){
				spots.add(ar.get(i));
			}
			for (ArrayList<Character> ar : plain){
				plains.add(ar.get(i));
			}
			if(possibleLocation(spots, plains)) counter++;
		}

		io.write(counter + "");
		io.close();





    }



    private static boolean possibleLocation(ArrayList<Character> ar1, ArrayList<Character> ar2){
    	boolean possible = true;
    	for(Character c: ar1){
    		if(!possible) break;
    		for (Character c1 : ar2){
				if (c == c1) {
					possible = false;
					break;
				}
			}
		}
    	return possible;





	}



    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}











@SuppressWarnings("ALL")
class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    private String curString = "";
    private int index = -1;

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

    public Character nextChar() throws IOException {
        index++;
        if(curString.equals("") || ((index+1) > curString.length())){
            index = 0;
            curString = r.readLine();
        }
        return curString.charAt(index);


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