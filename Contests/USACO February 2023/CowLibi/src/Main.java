import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, G, count=0;
    static ArrayList<coordTime> grazings = new ArrayList<>();
    static ArrayList<coordTime> alibis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("libi");
        G = io.nextInt();
        N = io.nextInt();
        for (int i=0; i<G; i++){
            grazings.add(new coordTime(io.nextInt(), io.nextInt(), io.nextInt()));
        }
        for (int i=0; i<N; i++){
            alibis.add(new coordTime(io.nextInt(), io.nextInt(), io.nextInt()));
        }
        Collections.sort(grazings);
        Collections.sort(alibis);
        for (coordTime a: alibis){
            int index = binarySearch(grazings, a.t, 0, G-1);
            if(!testIfCanReach(a, grazings.get(index))) {
                count++;
            }
            //System.out.println("---------");
        }
        System.out.println(count);


    }

    private static int binarySearch(ArrayList<coordTime> grazings, int x, int left, int right) {
        if (right > left) {
            int mid = (int) Math.floor(left + (right - left) / 2);

            // If the element is present at the
            // middle itself
            if (grazings.get(mid).t < x && grazings.get(mid+1).t > x) return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (grazings.get(mid).t > x)
                return binarySearch(grazings, x, left, mid - 1);

            // Else the element can only be present
            // in right subarray
            return binarySearch(grazings, x, mid + 1, right);
        }
        else if(right == left){
            return right;
        }

        // We reach here when element is not present
        // in array
        return 0;
    }



    private static boolean testIfCanReach(coordTime a, coordTime g){
        /* System.out.println(Math.abs(Math.pow(a.x,2) - Math.pow(g.x,2)));
        System.out.println(Math.abs(Math.pow(a.y,2) - Math.pow(g.y,2)));
        System.out.println(Math.pow(Math.abs(a.t - g.t), 2));
        System.out.println("~~~~~~"); */
        return Math.pow(a.x -g.x,2) + Math.pow(a.y-g.y,2) <= Math.pow(a.t - g.t, 2);
        /*System.out.println(Math.abs(a.x-g.x));
        System.out.println(Math.abs(a.y-g.y));
        System.out.println(Math.abs(a.t-g.t) + " " + a.t + " " + g.t);
        System.out.println("~~~~~~");*/
        //return Math.abs(a.x-g.x) + Math.abs(a.y-g.y) <= Math.abs(a.t-g.t);
    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class coordTime implements Comparable<coordTime>{
    int x;
    int y;
    int t;

    public coordTime(int x, int y, int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }

    @Override
    public String toString() {
        return "coordTime{" +
                "x=" + x +
                ", y=" + y +
                ", t=" + t +
                '}';
    }

    @Override
    public int compareTo(coordTime o) {
        return Integer.compare(this.t ,o.t);
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