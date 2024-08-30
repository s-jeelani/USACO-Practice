import java.io.*;
import java.util.*;

public class Main {
    static int N, T, K;
    static int[] arr;
    static ArrayList<Integer> largerIndex;

    public static void main(String[] args) throws IOException {
        Kattio io  = new Kattio();
        T = io.nextInt();
        for (int t=0; t<T; t++){
            N = io.nextInt();
            K = io.nextInt();
            K--;
            arr = new int[N];
            largerIndex= new ArrayList<>();
            for(int n=0; n<N; n++){
                arr[n] = io.nextInt();
            }
            for (int n=0; n<N; n++){
                if(arr[n] > arr[K]){
                    largerIndex.add(n);
                }
            }
            System.out.println(solve());

        }

    }

    private static int solve(){
        if(largerIndex.isEmpty()){
            return N-1;
        }
        if(K < largerIndex.get(0)) {
            return largerIndex.get(0)-1;
        }
        if(largerIndex.size() == 1){
            return Integer.max(largerIndex.get(0)-1, K-largerIndex.get(0) + (largerIndex.get(0) == 0 ? -1 : 0));
        }
        return Integer.max(largerIndex.get(0)-1, Integer.min(K, largerIndex.get(1))-largerIndex.get(0) + (largerIndex.get(0) == 0 ? -1 : 0));
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