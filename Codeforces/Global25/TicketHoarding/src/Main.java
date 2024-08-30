import java.io.*;
import java.util.*;

public class Main {
    static int N, T, K, M;
    static ArrayList<Integer> arr;
    static HashMap<Integer, ArrayList<Order>> orders;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        T = io.nextInt();
        for (int t=0; t<T; t++){
            N = io.nextInt();
            M = io.nextInt();
            K = io.nextInt();
            arr = new ArrayList<>();
            orders = new HashMap<>();
            for (int n=0; n<N; n++){
                arr.add(io.nextInt());
            }
            int k = K;
            int i=0;
            Collections.sort(arr);
            Order o;
            while(k > 0){
                if(k < M){
                    o = new Order(arr.get(i), k);
                    k = 0;
                }
                else{
                    o = new Order(arr.get(i), M);
                    k -= M;
                }
                if(!orders.containsKey(arr.get(i))) orders.put(arr.get(i), new ArrayList<>());
                orders.get(arr.get(i)).add(o);
                i++;
            }
            int boughtK = 0;
            int moneySpent = 0;
            for (int n=0; n<N; n++){
                int val = arr.get(n);
                if(!orders.containsKey(val)) continue;
                o = orders.get(val).get(0);
                orders.get(val).remove(o);
                if(orders.get(val).size() == 0) orders.remove(val);
                moneySpent += o.amt * (o.val+boughtK);
                boughtK += o.amt;
            }
            System.out.println(moneySpent);

        }

    }

}

class Order{
    int val;
    int amt;

    public Order(int val, int amt){
        this.val = val;
        this.amt = amt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "val=" + val +
                ", amt=" + amt +
                '}';
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