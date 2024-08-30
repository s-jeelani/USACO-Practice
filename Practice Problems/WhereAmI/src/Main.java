import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, X;
    static String s;

    public static void main(String[] args) throws IOException {
            Kattio io = new Kattio("whereami");
            N = io.nextInt();
            s = io.next();
            boolean Break = false;
            for (int i=1; i<s.length()+1; i++){
                for(int j=0; j<s.length()-i+1; j++){
                    String l = s.substring(j, j+i);


                    for (int k=0; k<s.length()-i+1; k++){
                        if(!(j==k)){
                            if(l.equals(s.substring(k, k+i))){
                                Break = true;
                                break;
                            }
                        }
                    }
                    if(Break){
                        break;
                    }
                }
                if(!Break){
                    X = i;
                    break;
                }
                Break = false;
            }
            io.write(X+"");
            io.close();












    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
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