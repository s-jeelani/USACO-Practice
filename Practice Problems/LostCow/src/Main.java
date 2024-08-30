import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int x, y, curDist = 0, curPos, curTurn = 0, newCurPos;

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("lostcow");
		x = io.nextInt(); y = io.nextInt();
		curPos = x;
		while (!(curPos == y)){
            newCurPos = x + (int) Math.pow(-1, curTurn) * (int) Math.pow(2, curTurn);
            curDist += Math.abs(newCurPos - curPos);
            curPos = newCurPos;
            if((curPos > y && x < y) || (x > y && curPos < y)){
                curDist -= Math.abs(curPos-y);
                curPos = y;
            }
		    curTurn++;
        }
		io.write(String.valueOf(curDist));
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