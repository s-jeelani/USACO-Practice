import java.io.*;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
	static ArrayList<Segment> segments = new ArrayList<>();
    static ArrayList<Segment> newSegments = new ArrayList<>();
    static int min, max;
    static ArrayList<Segment> currentRamps = new ArrayList<>();
    static ArrayList<Segment> currentNones = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("traffic");
        N = io.nextInt();
        for (int i = 0; i < N; i++) {
            segments.add(new Segment(io.next(), io.nextInt(), io.nextInt()));
        }


        for (Segment s : segments) {
            combine(s);
        }
        Segment lastSegment = segments.get(segments.size()-1);
        combine(new Segment((lastSegment.part.equals("none")) ? "on" : "none" , 0, 0));
        int a = Integer.MIN_VALUE, b = Integer.MAX_VALUE;
        for (int i=0; i<newSegments.size(); i++){
            Segment s = newSegments.get(i);
            if(i==0 && s.part.equals("on/off")) {
                a = newSegments.get(1).start;
                b = newSegments.get(1).end;

                continue;
            } if(s.part.equals("none")){

                a = Math.max(a, s.start);
                b = Math.min(b, s.end);

            } else{
                a += s.start;
                b += s.end;
            }
        }
        int a1 = Integer.MIN_VALUE, b1 = Integer.MAX_VALUE;
        for (int i=newSegments.size()-1; i>=0; i--){
            Segment s = newSegments.get(i);
            if(i==newSegments.size()-1 && s.part.equals("on/off")) {
                a1 = newSegments.get(newSegments.size()-2).start;
                b1 = newSegments.get(newSegments.size()-2).end;
                continue;
            } if(s.part.equals("none")){

                a1 = Math.max(a1, s.start);
                b1 = Math.min(b1, s.end);

            } else{
                a1 -= s.end;
                b1 -= s.start;
            }
        }

        if(a1<0) a1=0;
        if(b1 < 0) b1=0;
        if(a < 0) a=0;
        if(b < 0) b=0;
        io.write(a1 + " " + b1 + "\n" + a + " " + b);
        io.close();
    }

    public static void combine(Segment s){
        if (s.part.equals("none")) {

            if (!currentRamps.isEmpty()) {
                min = 0;
                max = 0;
                for (Segment r : currentRamps) {
                    if (r.part.equals("on")) {
                        min += r.start;
                        max += r.end;
                    } else {
                        min -= r.end;
                        max -= r.start;
                    }
                }
                newSegments.add(new Segment("on/off", min, max));
                currentRamps = new ArrayList<>();

            }
            currentNones.add(s);
        } else {
            if (!currentNones.isEmpty()) {
                min = 1000;
                max = 0;
                for (Segment n : currentNones) {
                    if (n.start > max) max = n.start;
                    if (n.end < min) min = n.end;
                }
                newSegments.add(new Segment("none", max, min));
                currentNones = new ArrayList<>();
            }
            currentRamps.add(s);
        }
    }










    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Segment{
	String part;
	int start;
	int end;

	public Segment(String part, int start, int end){
		this.part = part;
		this.start = start;
		this.end = end;
	}

    @Override
    public String toString() {
        return "Segment{" +
                "part='" + part + '\'' +
                ", start=" + start +
                ", end=" + end +
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