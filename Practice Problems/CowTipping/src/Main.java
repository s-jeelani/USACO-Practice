import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("cowtip");
        N = io.nextInt();
        for (int i=0; i<N; i++){
            String s = io.next();
            ArrayList<Integer> row = new ArrayList<>();
            for (Character c : s.toCharArray()){
                row.add(toInt(""+c));
            }
            grid.add(row);
        }
        int counter=0;
        int r=0, c=0;

        while (isEmpty()) {
            int max1 = Integer.MIN_VALUE;
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    if(i+j>max1 && grid.get(i).get(j) == 1){
                        max1 = i+j;
                        r = i;
                        c = j;
                    }
                }
            }
            flipGrid(r+1, c+1);
            counter++;
        }
        io.write(counter+"");
        io.close();











    }

    private static String nice(ArrayList<ArrayList<Integer>> g){
        String f = "";
        for (ArrayList<Integer> ar : grid){
            String s = "";
            for (Integer i : ar){
                s += i;
            }
            s += "\n";
            f += s;
        }
        f += "\n";
        return f;
    }

    private static void flipGrid(int r, int c){
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                if(grid.get(i).get(j) == 1) grid.get(i).set(j, 0);
                else grid.get(i).set(j, 1);
            }
        }
    }

    private static boolean isEmpty(){
        for (ArrayList<Integer> ar : grid){
            for (Integer i : ar){
                if(i == 1) return true;
            }
        }
        return false;
    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
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