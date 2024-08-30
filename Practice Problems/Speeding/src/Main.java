import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, M, max;
    static int counterN = 0, counterM = 0;
    static Queue<Pair> segments = new LinkedList<>();
    static Queue<Pair> tractorSpeed = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("speeding");
        N = io.nextInt(); M = io.nextInt();
        for (int i=0; i<N; i++){
            segments.add(new Pair(io.nextInt(), io.nextInt()));
        }
        for (int i=0; i<M; i++){
            tractorSpeed.add(new Pair(io.nextInt(), io.nextInt()));
        }
        for (int i=0; i<100; i++){
            if(segments.peek().length == counterN){
                segments.poll();
                counterN = 0;
            }
            if(tractorSpeed.peek().length == counterM){
                tractorSpeed.poll();
                counterM = 0;
            }
            if(tractorSpeed.peek().speed > segments.peek().speed && max < (tractorSpeed.peek().speed-segments.peek().speed)) max = (tractorSpeed.peek().speed-segments.peek().speed);
            counterN++; counterM++;
        }
        io.write(String.valueOf(max));
        io.close();







    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}






class Pair{
    int length;
    int speed;

    public Pair(int length, int speed){
        this.length = length;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "length=" + length +
                ", speed=" + speed +
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