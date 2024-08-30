import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, max=Integer.MIN_VALUE;
    static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("guess");
		N = io.nextInt();
		String l;
        for (int i=0; i<N; i++){
            Animal a = new Animal(io.next(), io.nextInt());
            for (int j=0; j<a.num; j++){
                a.props.add(io.next());
            }
            animals.add(a);

        }
        for (Animal a: animals){
            for (Animal a2: animals){
                if(a.equals(a2)) continue;
                int counter = 0;
                for (String p: a.props){
                    for (String p1: a2.props){
                        if(p.equals(p1)) counter++;
                    }
                }
                if(counter > max) max = counter;
            }
        }
        io.write(max+1+"");
        io.close();












    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Animal{
	String name;
	int num;
	int counter = 0;
	public ArrayList<String> props = new ArrayList<>();

	public Animal(String name, int num){
		this.name = name;
		this.num = num;
	}

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", counter=" + counter +
                ", props=" + props +
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