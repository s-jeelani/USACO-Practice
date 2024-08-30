import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int o, z, a;
    static boolean adj;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        T = io.nextInt();
        for (int i=0; i<T; i++){
            N = io.nextInt();
            o = 0;
            z = 0;
            a = 0;
            adj = false;
            char[] s = io.next().toCharArray();
            for (char c : s){
                if(Character.getNumericValue(c) == 1){
                    if(adj){
                        a++;
                        adj = false;
                    }
                    else adj = true;
                    o++;
                }
                else{
                    z++;
                    adj = false;
                }
            }
            if(o % 2 == 0 && !(o == 2 && a == 1)) System.out.println("YES");
            else System.out.println("NO");
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