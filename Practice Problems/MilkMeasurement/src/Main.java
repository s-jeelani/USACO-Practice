import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, changes=0, B=7, E=7, M=7;
    static ArrayList<Character> leads = new ArrayList<>();
    static ArrayList<Character> leads1 = new ArrayList<>();
    static TreeMap<Integer, MilkChange> milkChanges = new TreeMap<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("measurement");
		N = io.nextInt();
		for (int i =0; i<N; i++){
			milkChanges.put(io.nextInt(), new MilkChange(io.next().charAt(0), io.nextInt()));
		}
		leads.add('B');
        leads.add('E');
        leads.add('M');
		for (Map.Entry<Integer, MilkChange> e : milkChanges.entrySet()){
            checkLeads(e.getValue());


        }
		io.write("" + changes);
		io.close();








    }

    private static void checkLeads(MilkChange m){
        leads1 = leads;
        if(m.c == 'B') B += m.i;
        if(m.c == 'E') E += m.i;
        if(m.c == 'M') M += m.i;
        leads = new ArrayList<>();

        if(B > E && B > M) leads.add('B');
        else if(E > B && E > M) leads.add('E');
        else if(M > E && M > B) leads.add('M');

        if (B == E && B > M){ leads.add('B'); leads.add('E');}
        else if (B == M && B > E){ leads.add('B'); leads.add('M');}
        else if (M == E && M > B){ leads.add('M'); leads.add('E');}

        if(B == E && E == M) {leads.add('B'); leads.add('E'); leads.add('M');}
        Collections.sort(leads);
        if(!leads.equals(leads1)) changes++;

    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class MilkChange{
	Character c;
	Integer i;

	public MilkChange(Character c, Integer i){
		this.c = c;
		this.i = i;
	}

	@Override
	public String toString() {
		return "MilkChange{" +
				"c=" + c +
				", i=" + i +
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