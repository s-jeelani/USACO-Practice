import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<Cow> Cows = new ArrayList<>();
    static int curYLow1 = Integer.MAX_VALUE;
    static int curYHigh1 = Integer.MIN_VALUE;
    static ArrayList<Integer> secondBox = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("split");
        N = io.nextInt();

        for (int i=0; i<N; i++){
            int x = io.nextInt();
            int y = io.nextInt();
            Cows.add(new Cow(x, y));
            secondBox.add(y);
        }
        Collections.sort(Cows);
        Collections.sort(secondBox);

        int one = getArea(0, N-1);
        int val = Integer.MAX_VALUE, num=0;

        for (int i=0; i<N-1; i++){
            if(Cows.get(i).y < curYLow1) curYLow1 = Cows.get(i).y;
            if(Cows.get(i).y > curYHigh1) curYHigh1 = Cows.get(i).y;
            

            num = getArea(0, i) + getArea(i+1, N-1);
            if(num < val) val = num;
        }
        io.write(one-val+"");
        io.close();

    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }

    private static int getArea(int indexStart, int indexEnd){

        if(indexStart == 0){
            return (Cows.get(indexEnd).x-Cows.get(indexStart).x) * (curYHigh1-curYLow1);
        }
        return (Cows.get(indexEnd).x-Cows.get(indexStart).x) * (secondBox.get(indexMAX)-secondBox.get(indexMIN));

    }
}


class Cow implements Comparable<Cow>{
    int x;
    int y;

    public Cow(int x, int y){
        this.x = x;
        this.y = y;

    }

    @Override
    public String toString() {
        return "Cow{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Cow o) {
        if(o.x != x) return Integer.compare(x, o.x);
        return Integer.compare(y, o.y);
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