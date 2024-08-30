import java.io.*;
import java.util.*;

/*
MY CODE HERE: BELOW CODE IS SOLUTION
public class Main {
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("div7");
        ArrayList<Integer> cows = new ArrayList<>();
        ArrayList<Integer> prefixCows = new ArrayList<>();
        prefixCows.add(0);
        N = io.nextInt();
        for (int i=0; i<N; i++){
            cows.add(io.nextInt());
        }
        for (int i=0; i<N; i++){
            prefixCows.add(prefixCows.get(i)+cows.get(i));
        }

        int l;
        for (int i=N-1; i>-1; i--){
            for (int j=1; j<i; j++){
                if((prefixCows.get(i) - prefixCows.get(j-1)) % 7 == 0){
                    if(i-j+1 > max) max = i-j+1;
                    break;
                }
            }

        }
        io.write(max +"");
        io.close();


    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}
*/

public class Main {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("div7");

        int n = io.nextInt();
        long l;
        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<Long> sums = new ArrayList<>();
        sums.add(0L);
        for (int i=0; i<n; i++){
            nums.add(l=io.nextInt());
            sums.add((sums.get(i) + l) % 7);
        }
        int start, end, len, maxlen= Integer.MIN_VALUE;
        for (int i=1; i<7; i++){
            start = 0;
            end = 0;
            for (int j=0; j<n; j++){
                if(sums.get(j) == i){
                    start = i;
                    break;
                }
            }
            for (int j=n; j>-1; j--){
                if(sums.get(j) == i){
                    end = i;
                    break;
                }
            }
            len = end - start - 1;
            if(maxlen < len) maxlen = len;
        }
        io.write("" + maxlen);




        io.close();
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