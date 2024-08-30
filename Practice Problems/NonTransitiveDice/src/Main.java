import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static String ans, finalAns = "";

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		N = io.nextInt();
        Dice greater, least, temp;
		for (int z=0; z<N; z++){
		    ans = "no";
		    Dice d1 = new Dice(io.nextInt(), io.nextInt(), io.nextInt(), io.nextInt());
            Dice d2 = new Dice(io.nextInt(), io.nextInt(), io.nextInt(), io.nextInt());
		    if(d1.moreLikely(d2) == 0) ans = "no";
		    else{
		        if(d1.moreLikely(d2) == 1){
		            greater = d1;
		            least = d2;
                } else{
		            greater = d2;
		            least = d1;
                }
		        boolean Break = false;
		        for (int i=1; i<11; i++){
		            for (int j=1; j<11; j++){
		                for (int k=1; k<11; k++){
		                    for (int l=1; l<11; l++){
		                        temp = new Dice(i,j,k, l);
		                        if(temp.moreLikely(greater) == 1 && temp.moreLikely(least) == -1){
		                            Break = true;
		                            ans = "yes";
		                            break;
                                }
                            }
		                    if(Break) break;
                        }
		                if(Break) break;
                    }
		            if(Break) break;
                }
            }






		    finalAns += ans + "\n";
        }
		System.out.println(finalAns.trim());












    }


    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Dice{
    ArrayList<Integer> nums = new ArrayList<>();

    public Dice(int a, int b, int c, int d){
        nums.add(a);
        nums.add(b);
        nums.add(c);
        nums.add(d);
    }

    public int moreLikely(Dice y){
        float thisPercent=0, thatPercent=0;
        for (Integer i: this.nums){
            float counter = 0;
            for (Integer j: y.nums){
                if(i > j) counter += 25;
            }
            thisPercent += counter/4;
        }
        for (Integer i: y.nums){
            float counter = 0;
            for (Integer j: this.nums){
                if(i > j) counter += 25;
            }
            thatPercent += counter/4;
        }
        return Float.compare(thisPercent, thatPercent);
    }


    @Override
    public String toString() {
        return "Dice{" +
                "nums=" + nums +
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