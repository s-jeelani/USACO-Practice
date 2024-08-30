import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int T, N, Tc, Tm, min=Integer.MAX_VALUE;
    static ArrayList<cow> Cows = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("bakery");
        T = io.nextInt();
        for (int i =0; i<T; i++){
            N = io.nextInt();
            Tc = io.nextInt();
            Tm = io.nextInt();
            int x=0, y=0, c=0, ai, bi, ci;
            for (int j=0; j<N; j++){
                ai = io.nextInt();
                bi = io.nextInt();
                ci = io.nextInt();
                cow Cow = new cow(ai, bi, ci);
                Cows.add(Cow);
                x += ai;
                y += bi;
                c += -ci + Tc * ai + Tm * bi;
            }
            for (int cx=0; cx<Tc;cx++){
                for (int cy=0; cy<Tm; cy++){
                    if (cx*x+cy*y<c) continue;
                    if(checkRun(cx, cy)){
                        if(min > cx+cy) min = cx+cy;
                    }
                }
            }
            System.out.println(min);


        }

    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }

    private static boolean checkRun(int x, int y){
        for (cow c : Cows){
            if(c.a*(Tc-x)+c.b*(Tm-y)>c.c){
                return false;
            }
        }
        return true;
    }
}

class cow{
    int a;
    int b;
    int c;

    public cow(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
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