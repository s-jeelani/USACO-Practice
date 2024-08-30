import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("subsum");
        int N = io.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = io.nextInt();
        }


		long maxSubSum = arr[0];
		long runningPrefSum = 0;
		long minPrefSum = 0;
		for (int i : arr) {
            System.out.println(runningPrefSum + " " + maxSubSum + " " + minPrefSum);
			runningPrefSum += i;
			maxSubSum = Math.max(maxSubSum, runningPrefSum - minPrefSum);
			minPrefSum = Math.min(minPrefSum, runningPrefSum);
		}
		System.out.println(maxSubSum);
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