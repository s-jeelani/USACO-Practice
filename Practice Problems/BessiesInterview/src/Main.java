import java.io.*;
import java.util.*;

public class Main {
    static int N, K, F;
    static ArrayList<Integer> T = new ArrayList<>();
    static HashMap<Integer, TreeSet<Integer>> pairs = new HashMap<>();
    static HashMap<Integer, TreeSet<Integer>> tpairs = new HashMap<>();
    static HashSet<Integer> processed = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("bi");
        N = io.nextInt();
        K = io.nextInt();
        for (int i=0; i<N; i++){
            T.add(io.nextInt());
        }
        T.add(1);
        F=0;
        System.out.println(solve());
        System.out.println(possibleF());
        System.out.println(pairs + " " + tpairs);
    }

    private static int solve(){
        TreeSet<Time> times = new TreeSet<>();
        boolean end = true;
        for (int i=0; i<K; i++){
            times.add(new Time(0, i, 1, i+1));

        }
        int curCow = K-1;
        int curT = 0;
        Time prevT = new Time(0, 0, 0, 0);
        int ans = -1;
        while(!times.isEmpty()){
            Time t = times.pollFirst();
            assert t != null;
            if(!end && t.t != prevT.t) return ans;

            if(t.v == -1){
                if (prevT.t == t.t){
                    if(!pairs.containsKey(prevT.farmer)) pairs.put(prevT.farmer, new TreeSet<>());
                    if(!pairs.containsKey(t.farmer)) pairs.put(t.farmer, new TreeSet<>());
                    pairs.get(prevT.farmer).add(t.t);
                    pairs.get(t.farmer).add(t.t);

                    if(!tpairs.containsKey(t.t)) tpairs.put(t.t, new TreeSet<>());
                    tpairs.get(t.t).add(prevT.farmer);
                    tpairs.get(t.t).add(t.farmer);
                }


                curCow += 1;
                times.add(new Time(t.t, curCow, 1, t.farmer));
                if(curCow==N){
                    F = t.farmer;
                    end = false;
                    ans = t.t;
                }

                prevT = t;

            }
            else if(end){
                times.add(new Time(T.get(t.ID)+t.t, t.ID, -1, t.farmer));


            }
        }
        return ans;
    }

    private static String possibleF(){
        reverseCheck(F);

        StringBuilder s = new StringBuilder();
        for (int i=1; i<K+1; i++){
            if(processed.contains(i)) s.append(1);
            else s.append(0);
        }
        return s.toString();
    }

    private static void reverseCheck(int M){
        processed.add(M);
        TreeSet<Integer> SET = pairs.get(M);
        if(SET == null) return;
        while(!SET.isEmpty()){
            int q = SET.pollLast();
            for (int x : tpairs.get(q)){
                if(processed.contains(x)) continue;
                reverseCheck(x);
            }

        }
    }

}

class Time implements Comparable<Time>{
    int t;
    int ID;
    int v; // 1 for start -1 for end
    int farmer;

    public Time(int t, int ID, int v, int farmer){
        this.t = t;
        this.ID = ID;
        this.v = v;
        this.farmer = farmer;
    }

    @Override
    public int compareTo(Time o) {
        if(t == o.t) return Integer.compare(ID, o.ID);
        return Integer.compare(t, o.t);
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