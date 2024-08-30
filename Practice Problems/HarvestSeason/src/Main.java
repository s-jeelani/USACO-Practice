import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[][] grid = new int[6][6];
    static int count=1, result = 0;
    static int[] xDirection = {-1, 0, 1, 0};
    static int[] yDirection = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        K = io.nextInt();
        for (int i=0; i<K; i++){
            grid[io.nextInt()][io.nextInt()] = 1;
        }
        grid[1][1] = 1;

        go(1, 1);

        io.write(result+"");
        io.close();
    }

    private static void go(int x, int y){

        if(x == 5 && y == 5){
            if(count == 25-K){
                result++;
            }
            return;
        }

        for (int i=0; i<4; i++){
            int xx = x + xDirection[i];
            int yy = y + yDirection[i];
            if((xx > 5 || yy > 5 || xx <= 0 || yy <= 0)) {
                continue;
            }
            if(grid[xx][yy] == 1){
                continue;
            }
            grid[xx][yy] = 1;
            count++;

            go(xx, yy);

            grid[xx][yy] = 0;
            count--;
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