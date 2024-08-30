import java.io.*;
import java.util.*;
import java.awt.*;


/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, B;
    static int M = Integer.MAX_VALUE;
    static ArrayList<Integer> xs = new ArrayList<>();
    static ArrayList<Integer> ys = new ArrayList<>();
    static ArrayList<Point> coords = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("balancing");
		N = io.nextInt();
		B = io.nextInt();
		int l, x, y;
		Point q = null;
		for (int i=0; i<N; i++){
			coords.add(new Point(((x=io.nextInt())), (y=io.nextInt())));
			xs.add(x);
			ys.add(y);
		}
		for(int a=0; a<N; a++){
		    for (int b=0; b<N; b++) {
                if((l=checkPoint(xs.get(a)+1, ys.get(b)+1)) < M) M = l;
            }
        }


		io.write(M + "");
		io.close();














    }

    private static int checkPoint(double x, double y){
    	int q1=0, q2=0, q3=0, q4=0;
    	for (Point c: coords){
    		if(c.getX() - x < 0 && c.getY() - y < 0) q3++;
			else if(c.getX() - x > 0 && c.getY() - y < 0) q4++;
			else if(c.getX() - x < 0 && c.getY() - y > 0) q2++;
			else if(c.getX() - x > 0 && c.getY() - y > 0) q1++;
		}
    	return Math.max(Math.max(q1, q2), Math.max(q3, q4));
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