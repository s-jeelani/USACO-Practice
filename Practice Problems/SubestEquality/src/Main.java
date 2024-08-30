import java.io.*;
import java.util.*;
import java.util.stream.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static String S, T;
    static int N;



    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        String str = "";
        S = io.next();
        T = io.next();
        N = io.nextInt();
        for (int j=0; j<N; j++){
            String f = io.next();
            String s1="", s2="";
            ArrayList<Character> c = f.chars().mapToObj((i) -> (char) i).collect(Collectors.toCollection(ArrayList::new));
            for (int i=0; i<S.length(); i++){
                if(c.contains(S.charAt(i))){
                    s1 += S.charAt(i);
                }
                if(c.contains(T.charAt(i))){
                    s2 += T.charAt(i);
                }

            }
            if(s1.equals(s2)){
                str += "Y";
            }



        }
        System.out.println(str);


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