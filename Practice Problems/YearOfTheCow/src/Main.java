import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<Cow> cows = new ArrayList<>();
    static ArrayList<String> years = new ArrayList<>(Arrays.asList("Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"));
    static HashMap<String, Pair> cowYears = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("yotc");
        N = io.nextInt();
        int x;
        for (int i=0; i<N; i++){
            String a = io.next();
            io.next(); io.next();
            String b = io.next();
            String c = io.next();
            io.next(); io.next();
            String d = io.next();
            cows.add(new Cow(a, b, c, d));
        }
        cowYears.put("Bessie", new Pair("Ox", 0));
        String curCow="Bessie", prevCow=""; Cow t = null;
        while (!curCow.equals("Elsie")) {
            boolean found = false;
            for (Cow c : cows) {
                if (c.cowRel.equals(curCow)) {
                    found = true;
                    t = c;
                    break;
                }
            }
            assert t != null;
            curCow = t.name;
            System.out.println(curCow +" " + prevCow);
            if(prevCow.equals(curCow) || !found || cowYears.containsKey(curCow)){
                cows.remove(t);
                curCow = "Bessie";
                System.out.println(cows);
                continue;
            }

            if (t.prev.equals("previous")) {
                cowYears.put(t.name, new Pair(t.anim, cowYears.get(t.cowRel).num - (12 + years.indexOf(cowYears.get(t.cowRel).anim) - years.indexOf(t.anim))));
            } else if (t.prev.equals("next")) {
                if(years.indexOf(t.anim)>years.indexOf(cowYears.get(t.cowRel).anim)){
                    cowYears.put(t.name, new Pair(t.anim, cowYears.get(t.cowRel).num + (years.indexOf(t.anim)-years.indexOf(cowYears.get(t.cowRel).anim))));
                } else if(years.indexOf(t.anim)<years.indexOf(cowYears.get(t.cowRel).anim)){
                    cowYears.put(t.name, new Pair(t.anim, cowYears.get(t.cowRel).num + (12-((years.indexOf(cowYears.get(t.cowRel).anim)-years.indexOf(t.anim))))));
                } else{
                    cowYears.put(t.name, new Pair(t.anim, cowYears.get(t.cowRel).num + 12));
                }
            }
            prevCow = curCow;
        }
        System.out.println(Math.abs(cowYears.get("Elsie").num));











    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}


class Pair{
    String anim;
    int num;

    public Pair(String anim, int num){
        this.anim = anim;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "anim='" + anim + '\'' +
                ", num=" + num +
                '}';
    }
}



class Cow{
    String name;
    String prev;
    String anim;
    String cowRel;

    public Cow(String name, String prev, String anim, String cowRel){
        this.name = name;
        this.prev = prev;
        this.anim = anim;
        this.cowRel = cowRel;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "name='" + name + '\'' +
                ", prev='" + prev + '\'' +
                ", anim='" + anim + '\'' +
                ", cowRel='" + cowRel + '\'' +
                '}';
    }
}











@SuppressWarnings("ALL")
class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;

		// standard input
		public Kattio() { this(System.in, System.out); }
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
			} catch (Exception e) { return null;}

		}

		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}