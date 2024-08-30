import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();
    static int amount;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        N = io.nextInt();
        for(int i=0; i<N; i++){
            list.add(io.nextInt());
        }
        for (int i=0; i<N; i++){
            for (int j=i; j<N; j++){
                if(checkAverage(list.subList(i, j+1))) amount++;
            }
        }
        System.out.println(amount);








    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }

    private static boolean checkAverage(List<Integer> ar){
        double sum = 0; double avg;
        for (Integer i: ar){
            sum += i;
        }
        avg = sum/(ar.size());
        for (Integer i: ar){
            if(i == avg){
                return true;
            }
        }
        return false;
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