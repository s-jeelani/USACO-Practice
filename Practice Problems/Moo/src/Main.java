import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] values = new int[64];
    static char ans;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        N = io.nextInt();
        values[0] = 3;
        int index = 1;
        while (N > values[index-1]){
            values[index] = 2*values[index-1] + index+3;
            index++;
        }
        index--;
        while(true){
            if(index == 0){
                if(N == 1) ans = 'm';
                else ans = 'o';
                break;
            }
            N -= values[index-1];
            if(N-(index+3) < 0){
                if(N == 1) ans = 'm';
                else ans = 'o';
                break;
            }
            N -= (index+3);
            index = findLength(N);
        }

        io.write(ans);
        io.close();








    }

    private static int findLength(int val){
        int k=0;
        while (true){
            if(val < values[k]) return k;
            k++;
        }
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