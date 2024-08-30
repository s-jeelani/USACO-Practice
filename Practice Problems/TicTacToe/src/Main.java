import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N1, N2 = 0;
    static Board b;


    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("tttt");
		b = new Board(io.getLine().charAt(0), io.getLine().charAt(1), io.getLine().charAt(2), io.getLine().charAt(0), io.getLine().charAt(1), io.getLine().charAt(2), io.getLine().charAt(0), io.getLine().charAt(1), io.getLine().charAt(2));
        b.checkCols();
        b.checkRows();
        b.checkDiagonals();
        for(Map.Entry<String, Integer> e : b.hm.entrySet()){
            if(e.getKey().length() == 1) N1 += e.getValue();
            else if(e.getKey().length() == 2) N2 += e.getValue();
        }

		io.write(N1 + "\n");
        io.write(String.valueOf(N2));
        io.close();








    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Board{
	Character a1;
	Character a2;
	Character a3;
	Character b1;
	Character b2;
	Character b3;
	Character c1;
	Character c2;
	Character c3;
	HashMap<String, Integer> hm = new HashMap<>();

	public Board(Character a1,Character a2,Character a3,Character b1,Character b2,Character b3,Character c1,Character c2,Character c3){
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s\n%s %s %s\n%s %s %s", a1, a2, a3, b1, b2, b3, c1, c2, c3);
	}

	public void checkCols(){
	    String i = checkSet(a1, b1, c1);
        if(!i.equals("")){
            if(i.length() == 1) hm.put(i, 1);
            else if(i.length() == 2) hm.put(i, 1);
        }

        i = checkSet(a2, b2, c2);
        if(!i.equals("")){
            if(i.length() == 1) hm.put(i, 1);
            else if(i.length() == 2) hm.put(i, 1);
        }

        i = checkSet(a3, b3, c3);
        if(!i.equals("")){
            if(i.length() == 1) hm.put(i, 1);
            else if(i.length() == 2) hm.put(i, 1);
        }

    }

    public void checkRows(){
        String i = checkSet(a1, a2, a3);
        if(!i.equals("")){
            if(i.length() == 1) hm.put(i, 1);
            else if(i.length() == 2) hm.put(i, 1);
        }

        i = checkSet(b1, b2, b3);
        if(!i.equals("")){
            if(i.length() == 1) hm.put(i, 1);
            else if(i.length() == 2) hm.put(i, 1);
        }

        i = checkSet(c1, c2, c3);
        if(!i.equals("")){
            if(i.length() == 1) hm.put(i, 1);
            else if(i.length() == 2) hm.put(i, 1);
        }
    }

    public void checkDiagonals(){
        String i = checkSet(a1, b2, c3);
        if(!i.equals("")){
            if(i.length() == 1) hm.put(i, 1);
            else if(i.length() == 2) hm.put(i, 1);
        }

        i = checkSet(c1, b2, a3);
        if(!i.equals("")){
            if(i.length() == 1) hm.put(i, 1);
            else if(i.length() == 2) hm.put(i, 1);
        }
    }

    public String checkSet(Character a, Character b, Character c){
	    char[] s;
        if(a == b && a == c && b == c) return String.valueOf(a);
	    if (a == b || a == c || b == c) {
	        if(a == b) {s = (a + "" + c).toCharArray(); Arrays.sort(s); return String.valueOf(s);}
	        if(b == c) {s = (a + "" + c).toCharArray(); Arrays.sort(s); return String.valueOf(s);}
	        if(a == c) {s = (a + "" + b).toCharArray(); Arrays.sort(s); return String.valueOf(s);}
        }
	    return "";

    }
}
















@SuppressWarnings("ALL")
class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    public String line;
    private int counter = 0;

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
        line = next();
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

	public String getLine(){
        if(counter > 2) {counter = 0; line = next();}
        counter++;
        return line;
    }
}