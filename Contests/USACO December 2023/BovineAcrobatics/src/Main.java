import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, cnt=0;
    static int min=Integer.MAX_VALUE;
    static ArrayList<Integer> vals = new ArrayList<>();
    static TreeMap<Integer, Integer> w = new TreeMap<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        N = io.nextInt();
        M = io.nextInt();
        K = io.nextInt();
        for (int i=0; i<N; i++){
            w.put(io.nextInt(), io.nextInt());
        }
        while (M > 0){
            tower(w.firstEntry());
            remove();
            M -= min;
            min = Integer.MAX_VALUE;
            vals = new ArrayList<>();
        }
        System.out.println(cnt);

    }

    private static void tower(Map.Entry<Integer, Integer> e){
        vals.add(e.getKey());
        min = Math.min(min, e.getValue());
        if(w.ceilingKey(e.getKey()-K) == null) return;
        tower(w.ceilingEntry(e.getKey()-K));
    }

    private static void remove(){
        if(M - min < 0) min = M;
        cnt += vals.size()*min;
        for (int v: vals){

            if(w.get(v)-min == 0) w.remove(v);
            else w.replace(v, w.get(v)-min);
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