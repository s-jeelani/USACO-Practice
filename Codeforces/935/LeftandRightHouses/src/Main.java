import java.io.*;
import java.util.*;

import static java.lang.Math.ceil;

public class Main {
    static int N, T;
    static int[] houses;
    static int[] sumHouses;
    static char[] s;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        T = io.nextInt();
        for (int i=0; i<T; i++){
            N = io.nextInt();
            houses = new int[N+2];
            sumHouses = new int[N+2];
            s = io.next().toCharArray();
            for (int j=1; j<N+1; j++){
                houses[j] = Character.getNumericValue(s[j - 1]);
                sumHouses[j] = sumHouses[j-1] + houses[j];
            }
            int m = (N+1)/2;
            for (int j=0; j<((N+1)/2); j++){
                if(test(m-j)) System.out.println(m-j);
                else if(test(m+j)) System.out.println(m+j);



                else continue;
                break;
            }
        }



    }

    private static boolean test(int i){
        return (((i - sumHouses[i])/(i+0.0)) >= 0.5) && (((sumHouses[N] - sumHouses[i])/(N-i+0.0)) >= 0.5);
    }

}


@SuppressWarnings("ALL")
class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;

    public Kattio() {
        this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(String problemName) throws IOException {
        super(new FileWriter(problemName + ".out"));
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }

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