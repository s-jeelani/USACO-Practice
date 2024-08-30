import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> ranges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        N = io.nextInt();
        arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = -1;
        }
        arr[0] = 1;
        for (int i=0; i<N; i++){
            ArrayList<Integer> r = new ArrayList<>();
            for (int j=i; j<N; j++){
                r.add(io.nextInt());
            }
            ranges.add(r);
        }
        for (ArrayList<Integer> a : ranges){
            for (int k=1; k<a.size(); k++){
                if(a.get(k) != a.get(k-1)){

                }
            }
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