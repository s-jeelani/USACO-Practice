import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, M, R;
    static ArrayList<Integer> cows = new ArrayList<>();
    static ArrayList<Store> stores = new ArrayList<>();
    static ArrayList<Integer> rents = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("rental");
        N = io.nextInt();
        M = io.nextInt();
        R = io.nextInt();
        for (int i=0; i<N; i++){
            cows.add(io.nextInt());
        }
        for (int i=0; i<M; i++){
            stores.add(new Store(io.nextInt(),  io.nextInt()));
        }
        for (int i=0; i<R; i++) {
            rents.add(io.nextInt());
        }
        cows.sort(Collections.reverseOrder());
        stores.sort(Collections.reverseOrder());
        Collections.sort(rents);
        int curStore=0, newStore=0;
        long moneyGeneratedByStore = 0;
        long totalMoney = 0;
        Store store;
        Set<Integer> removedIndices = new HashSet<>();
        int X = N;
        for (int n=0; n<N; n++){
            if(removedIndices.contains(n)){
                continue;
            }
            int tempC = cows.get(n);
            moneyGeneratedByStore = 0;
            for (int i=curStore; i<M; i++){
                store = stores.get(i);
                if(store.gal < tempC && tempC > 0){
                    tempC -= store.gal;
                    moneyGeneratedByStore += (long) store.gal *store.cost;
                }
                else {
                    curStore = i;
                    break;
                }

            }
            moneyGeneratedByStore += (long) (tempC) *stores.get(curStore).cost;
            newStore = stores.get(curStore).gal - tempC;

            R = rents.size();
            if(rents.size() != 0) {

                if (moneyGeneratedByStore >= rents.get(R - 1)) {
                    removedIndices.add(n);
                    totalMoney += moneyGeneratedByStore;
                    stores.get(curStore).gal = newStore;

                } else {

                    totalMoney += rents.get(R - 1);
                    rents.remove(R - 1);
                    removedIndices.add(X - 1);
                    X -= 1;
                    n--;
                }
            } else {
                    removedIndices.add(n);
                    totalMoney += moneyGeneratedByStore;
                    stores.get(curStore).gal = newStore;
                }
                System.out.println(totalMoney);
            }
        io.write(totalMoney + "");
        io.close();


    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Store implements Comparable<Store>{
    int gal;
    int cost;

    public Store(int gal, int cost){
        this.gal = gal;
        this.cost = cost;

    }

    @Override
    public int compareTo(Store o) {
        return Integer.compare(cost, o.cost);
    }

    @Override
    public String toString() {
        return "Store{" +
                "gal=" + gal +
                ", cost=" + cost +
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