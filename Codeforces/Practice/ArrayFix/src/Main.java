import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int N, T;
    static ArrayList<Integer> newArr = new ArrayList<>();
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        T = io.nextInt();
        for (int t=0; t<T; t++){
            N = io.nextInt();
            newArr = new ArrayList<>();
            arr = new ArrayList<>();
            for(int n=0; n<N; n++) {
                arr.add(io.nextInt());
            }
            newArr.add(arr.get(N-1));
            for (int i=N-2; i>=0; --i){
                if(arr.get(i) > newArr.get(newArr.size()-1)){
                    newArr.add(arr.get(i) % 10);
                    newArr.add(arr.get(i)/10);
                }
                else{
                    newArr.add(arr.get(i));
                }
            }
            System.out.println(isSorted(newArr) ? "YES" : "NO");

        }



    }
    private static boolean isSorted(ArrayList<Integer> array) {
        for (int i=1; i<N; i++){
            if(array.get(i) > array.get(i-1)) return false;
        }
        return true;
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