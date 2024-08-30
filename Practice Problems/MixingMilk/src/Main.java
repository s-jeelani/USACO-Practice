import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
	public static HashMap<Integer, Milk> buckets = new HashMap<>();


    public static void main(String[] args) throws IOException {
    	Kattio io =	new Kattio("mixmilk");
		buckets.put(0, new Milk(io.nextInt(), io.nextInt()));
		buckets.put(1, new Milk(io.nextInt(), io.nextInt()));
		buckets.put(2, new Milk(io.nextInt(), io.nextInt()));
		fillBuckets();
        for (Milk milk : buckets.values()){
            io.write(milk.milk + "\n");
        }
        io.close();
    }


    private static void fillBuckets(){
        Milk pouring, filling;
        for (int i=0; i<100; i++){
            pouring = buckets.get(i % 3);
            filling = buckets.get((i+1) % 3);
            filling.milk += pouring.milk;
            pouring.milk = 0;
            if(filling.milk > filling.cap) {
                pouring.milk += filling.milk-filling.cap;
                filling.milk = filling.cap;
            }




        }
	}


}

class Milk{
	int milk;
	int cap;

	public Milk(int capacity, int milk){
		this.milk = milk;
		this.cap = capacity;
	}

    @Override
    public String toString() {
        return "Milk{" +
                "milk=" + milk +
                ", cap=" + cap +
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