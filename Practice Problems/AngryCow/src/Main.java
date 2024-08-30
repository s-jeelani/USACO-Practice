import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<Integer> poses = new ArrayList<>();
	static ArrayList<Bale> bales = new ArrayList<>();
	static ArrayList<Bale> bales1 = new ArrayList<>();


    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("angry");
		N = io.nextInt();
		for (int i=0; i<N; i++){
			poses.add(io.nextInt());
		}
		Collections.sort(poses);
		for (Integer i: poses){
			bales.add(new Bale(i, 0, false));
			bales1.add(new Bale(i, 0, false));
		}
		int x=0, a=0;

		for (int i=0; i<N; i++){

			bales = bales1;
			bales.get(i).exploded = true;
			bales.get(i).radius = 1;
			x = i;
			for (int j=i-1; j>-1; j--){
				if(bales.get(x).pos - bales.get(x).radius <= bales.get(j).pos){
					while(bales.get(x).pos - bales.get(x).radius <= bales.get(j).pos){
						bales.get(j).radius = bales.get(x).radius+1;
						bales.get(j).exploded = true;
						x = j;
						j--;
						if(j<0) break;
					}
				} else{
					break;
				}

			}
			x = i;
			for (int j=i+1; j<N; j++){
				if(bales.get(x).pos + bales.get(x).radius >= bales.get(j).pos){
					while(bales.get(x).pos + bales.get(x).radius >= bales.get(j).pos){
						bales.get(j).radius = bales.get(x).radius+1;
						bales.get(j).exploded = true;
						x = j;
						j++;
						if(j>N-1) break;
					}
				} else{
					break;
				}

			}
			System.out.println(bales.get(i).pos + " " + bales);
		}











    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}



class Bale{
	int pos;
	int radius;
	boolean exploded;

	 public Bale(int pos, int r, boolean e){
	 	this.pos = pos;
	 	this.radius = r;
	 	this.exploded = e;
	 }

	@Override
	public String toString() {
		return "Bale{" +
				"pos=" + pos +
				", radius=" + radius +
				", exploded=" + exploded +
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