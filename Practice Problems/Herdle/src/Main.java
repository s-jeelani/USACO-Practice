import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int G=0, Y=0;
    static ArrayList<ArrayList<Character>> ans = new ArrayList<>();
	static ArrayList<ArrayList<Character>> guess = new ArrayList<>();
	static ArrayList<Pair> offLimits = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    	Kattio io = new Kattio();
		for (int i=0; i<3; i++){
			String s = io.next();
			ArrayList<Character> x = new ArrayList<>();
			for (char c: s.toCharArray()){
				x.add(c);
			}
			ans.add(x);
		}
		for (int i=0; i<3; i++){
			String s = io.next();
			ArrayList<Character> x = new ArrayList<>();
			for (char c: s.toCharArray()){
				x.add(c);
			}
			guess.add(x);
		}
		// count greens first
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(ans.get(i).get(j) == guess.get(i).get(j)){
                    G++;
                    offLimits.add(new Pair(i, j));
                }
            }
        }
        // now count yellows

       for (int i=0; i<3; i++){
           for (int j=0; j<3; j++){{
               if(ans.get(i).get(j) == guess.get(i).get(j)){
                   continue;
               }
               for (int a=0; a<3; a++){
                   boolean Break = false;
                   for (int b=0; b<3; b++){
                       boolean check = false;
                       for (Pair p: offLimits){
                           if(p.x == a && p.y == b){
                               check = true;
                               break;
                           }
                       }
                       if(check) continue;
                       if(ans.get(a).get(b) == guess.get(i).get(j)){
                           Y++;
                           offLimits.add(new Pair(a, b));
                           Break = true;
                           break;
                       }
                   }
                   if(Break) break;
               }

           }}
       }
        System.out.println(G + "\n" + Y);













    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}


class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
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