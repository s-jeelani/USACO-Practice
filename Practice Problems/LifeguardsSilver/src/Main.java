import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<Point> points = new ArrayList<>();
    static HashMap<Integer, Integer> spentAlone = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("lifeguards");
        N = io.nextInt();

        for (int i=0; i<N; i++){

            points.add(new Point(io.nextInt(), 1, i));
            points.add(new Point(io.nextInt(), -1, i));
            spentAlone.put(i, 0);
        }
        TreeSet<Integer> curWorking = new TreeSet<>();
        Collections.sort(points);
        int timeStoppedWorking = 0;
        boolean timeStopped = false;
        Point prevP = null;
        for (Point p: points){
            if (timeStopped) timeStoppedWorking += p.t - prevP.t;
            if(curWorking.size() == 1){


                spentAlone.replace(curWorking.first(), spentAlone.get(curWorking.first()) + p.t - prevP.t);
            }
            if(p.role == 1) curWorking.add(p.num);
            else curWorking.remove(p.num);

            timeStopped = curWorking.size() == 0;
            prevP = p;
        }


        io.write(String.valueOf((points.get(2*N-1).t - points.get(0).t) - (Collections.min(spentAlone.values()) + timeStoppedWorking)));
        io.close();

    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Point implements Comparable<Point>{
    int t;
    int role;
    int num;

    public Point(int t, int role, int num){
        // role = start or end(1 or -1)
        this.t = t;
        this.role = role;
        this.num = num;
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(t, o.t);
    }

    @Override
    public String toString() {
        return "Point{" +
                "t=" + t +
                ", role=" + role +
                ", num=" + num +
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