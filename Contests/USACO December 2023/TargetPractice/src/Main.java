import java.io.*;
import java.util.*;

public class Main {
    static int T, C;
    static HashSet<Integer> tar = new HashSet<>();
    static ArrayList<Integer> com = new ArrayList<>();
    static ArrayList<Integer> pos = new ArrayList<>();
    static int[] dir = {-2, -1, 0, 1, 2};
    static int[] cnts = new int[5];
    /*
    LL = 0
    L = 1
    S = 2
    R = 3
    RR = 4

     */

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("tp");
        T = io.nextInt();
        C = io.nextInt();
        for (int i=0; i<T; i++){
            tar.add(io.nextInt());
        }
        char[] s = io.next().toCharArray();
        for (char c : s){
            switch (c) {
                case 'F' -> com.add(0);
                case 'R' -> com.add(1);
                case 'L' -> com.add(-1);
            }
        }
        pos.add(0);
        seq();
        for (Integer p : pos){
            for (int i =0; i<5; i++){
                if(tar.contains(p+dir[i])) cnts[i]++;
            }
        }
        System.out.println(Arrays.toString(cnts));
    }

    private static void seq(){
        for (Integer i : com){
            pos.add(pos.get(pos.size()-1)+i);
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