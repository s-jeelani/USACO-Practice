import java.awt.*;
import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static ArrayList<Point> points = new ArrayList<>();
    static ArrayList<Line> horiz = new ArrayList<>();
    static ArrayList<Line> verti = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("triangles");
		N = io.nextInt();
		for (int i = 0; i < N; i++) {
			points.add(new Point(io.nextInt(), io.nextInt()));
		}

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(points.get(i).x == points.get(j).x){
                    verti.add(new Line(points.get(i), points.get(j)));
                }
                else if(points.get(i).y == points.get(j).y){
                    horiz.add(new Line(points.get(i), points.get(j)));
                }
            }
        }
        int area;
        for(Line h: horiz){
            for (Line v : verti){
                if(h.p1.equals(v.p1) || h.p1.equals(v.p2) || h.p2.equals(v.p1) || h.p2.equals(v.p2)){
                    area = Math.abs(h.p1.x - h.p2.x)*Math.abs(v.p1.y - v.p2.y);
                    if(area > max) max = area;
                }
            }
        }
        io.write(max + "");
        io.close();

	}


    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}


class Line{
    Point p1;
    Point p2;

    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                "," +
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