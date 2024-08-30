import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static ArrayList<Integer> perm = new ArrayList<>();
    static ArrayList<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) throws IOException {

		Kattio io = new Kattio("v");
        N = io.nextInt();
        long x = 0;
        int a, b;
        for (int i=0; i<N; i++){
            hm.put((a=io.nextInt()), (b=io.nextInt()));
            pairs.add(new Pair(a, b));
        }
        findPerm();
        ArrayList<Integer> bi = new ArrayList<>();
        for(int i=0; i<N; i++) bi.add(1);

        for (int i=0; i<N-1; i++){
            if(bi.get(i+1) == 0) continue;
            bi.set(i, 0);
            x += hm.get(perm.get(i+1));
        }
        if(bi.get(0) == 1) {
            x += hm.get(perm.get(0));
        }
        System.out.println(x);







    }

    private static void findPerm(){
        Collections.sort(pairs);

        perm.add(pairs.get(0).key);
        for (int i=N-1; i>0; i--){
            perm.add(pairs.get(i).key);
        }
    }





    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}



class Pair implements Comparable<Pair>{
    int key;
    int value;

    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
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