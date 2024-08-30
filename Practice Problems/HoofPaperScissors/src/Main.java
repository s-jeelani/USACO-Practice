import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<HPSCount> prefixes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("hps");
        N = io.nextInt();
        prefixes.add(new HPSCount(0,0,0));
        int h, p, s;
        String l;
        for (int i =0; i<N; i++){
            h = prefixes.get(i).h;
            p = prefixes.get(i).p;
            s = prefixes.get(i).s;
            l = io.next();
            switch (l) {
                case "P":
                    p++;
                    break;
                case "H":
                    h++;
                    break;
                case "S":
                    s++;
                    break;
            }
            prefixes.add(new HPSCount(h, p, s));
        }
        int maxamount = Integer.MIN_VALUE;
        prefixes.remove(0);
        for (int i=0; i<N; i++){
            int c = findAmount(i);
            if(maxamount < c) maxamount = c;

        }
        io.write(maxamount + "");
        io.close();



    }

    static int findAmount(int x){
        int first = Math.max(prefixes.get(x).h, Math.max(prefixes.get(x).s, prefixes.get(x).p));
        HPSCount secondCount = new HPSCount(prefixes.get(N-1).h-prefixes.get(x).h, prefixes.get(N-1).p-prefixes.get(x).p, prefixes.get(N-1).s-prefixes.get(x).s);
        int second = Math.max(secondCount.h, Math.max(secondCount.s, secondCount.p));
        return first+second;
    }





    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}




class HPSCount{
    int h;
    int p;
    int s;

    public HPSCount(int h, int p, int s){
        this.h = h;
        this.p = p;
        this.s = s;
    }

    @Override
    public String toString() {
        return "HPSCount{" +
                "h=" + h +
                ", p=" + p +
                ", s=" + s +
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