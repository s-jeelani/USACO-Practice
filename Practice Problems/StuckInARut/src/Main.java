import java.awt.*;
import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<Cow> CowN = new ArrayList<>();
    static ArrayList<Cow> CowE = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		N = io.nextInt();
		for (int i=0; i<N; i++){
            Cow c = new Cow(io.next(), new Point(io.nextInt(), io.nextInt()));
            if(c.d == Direction.N) CowN.add(c);
            else CowE.add(c);
        }
		CowN.sort();

    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}



class Cow{
    Direction d;
    int x;
    int y;

    public Cow(String d, Point p){
        if(d.equals("N")) this.d = Direction.N;
        else this.d = Direction.E;
        this.x = (int) p.getX();
        this.y = (int) p.getY();
    }

    public Point intersection(Cow c){
        if(this.d == Direction.N) return new Point(this.x, c.y);
        return new Point(c.x, this.y);
    }

    



}

enum Direction{
    E, N
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