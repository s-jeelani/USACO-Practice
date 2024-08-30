import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<LineSegment> lines = new ArrayList<>();
	static ArrayList<Pair> moves = new ArrayList<>();
	static ArrayList<Coord> intersections = new ArrayList<>();
	static ArrayList<Coord> grid = new ArrayList<>();
	static int x = 0, y = 0, x1 = 0, y1 = 0, min= Integer.MAX_VALUE, t=0;
	static Character d;


	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("mowing");
		N = io.nextInt();
		for  (int i=0; i<N; i++) moves.add(new Pair(io.next().charAt(0), io.nextInt()));
		for (Pair p: moves){
			x1 = x; y1 = y;
			if(p.direction == 'N') {y += p.amount; d = 'V';}
			else if(p.direction == 'W'){ x -= p.amount; d = 'H';}
			else if(p.direction == 'S'){ y -= p.amount; d = 'V';}
			else if(p.direction == 'E'){ x += p.amount; d = 'H';}
			lines.add(new LineSegment(x1, y1, x, y, d));
		}
		Coord intersect;
		intersections.add(new Coord(0, 0));
		intersections.get(0).passed(0);
		for (LineSegment l : lines){
			for (LineSegment l1 : lines) if(l != l1 && !l.d.equals(l1.d)){
					if((intersect = l.intersection(l1)) != null) intersections.add(intersect);

			}
		}
		HashSet<Coord> set = new HashSet<>(intersections);
		intersections = new ArrayList<>(set);
		x = 0; y = 0;
		for(Pair p: moves){
			if(p.direction == 'N'){
				for(int i=0; i<p.amount; i++){
					y++;
					t++;
					for (Coord c: intersections) {
						if(c.x == x && c.y == y){
							c.passed(t);
							break;
						}
					}
				}
			}
			else if(p.direction == 'S'){
				for(int i=0; i<p.amount; i++){
					y--;
					t++;
					for (Coord c: intersections){
						if(c.x == x && c.y == y){
							c.passed(t);
							break;
						}
					}
				}
			}
			else if(p.direction == 'W'){
				for(int i=0; i<p.amount; i++){
					x--;
					t++;
					for (Coord c: intersections) {
						if(c.x == x && c.y == y){
							c.passed(t);
							break;
						}

					}
				}
			}
			else if(p.direction == 'E'){
				for(int i=0; i<p.amount; i++) {
					x++;
					t++;
					for (Coord c : intersections){
						if (c.x == x && c.y == y) {
							c.passed(t);
							break;
						}
					}
				}
			}
		}


		for(Coord c: intersections){
			if(c.min < min) min = c.min;
		}
		if(min == Integer.MAX_VALUE) min = -1;
		io.write(min + "");
		io.close();









    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class LineSegment{
	int x1;
	int y1;
	int x2;
	int y2;
	Character d;

	public LineSegment(int x1, int y1, int x2, int y2, Character d){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.d = d;
	}

	public Coord intersection(LineSegment l){
		if(l.d == 'V'){
			if(Math.max(l.y1, l.y2) >= this.y1 && Math.min(l.y1, l.y2) <= this.y1 && Math.max(this.x1, this.x2) >= l.x1 && Math.min(this.x1, this.x2) < l.x1) return new Coord(l.x1, this.y1);
		}

		if(Math.max(this.y1, this.y2) >= l.y1 && Math.min(this.y1, this.y2) <= l.y1 && Math.max(l.x1, l.x2) >= this.x1 && Math.min(l.x1, l.x2) <= this.x1) return new Coord(this.x1, l.y1);;
		return null;
	}

	@Override
	public String toString() {
		return "LineSegment{" +
				"x1=" + x1 +
				", y1=" + y1 +
				", x2=" + x2 +
				", y2=" + y2 +
				", d=" + d +
				'}';
	}




}

class Pair{
	Character direction;
	int amount;


	public Pair(Character direction, int amount){
		this.direction = direction;
		this.amount = amount;
	}

}

class Coord{
	int x, y;
	boolean passed = false;
	int tStart = 0; int tEnd = 0;
	int min = Integer.MAX_VALUE;

	public Coord(int x, int y){
		this.x = x; this.y = y;
	}

	public void passed(int t){
		if(passed){
			tEnd = t;
			if(tEnd-tStart < min) min = tEnd-tStart;
			tStart = 0;
			tEnd = 0;
			passed = false;
		} else {
			passed = true;
			tStart = t;
		}
	}

	@Override
	public String toString() {
		return "Coord{" +
				"x=" + x +
				", y=" + y +
				", passed=" + passed +
				", tStart=" + tStart +
				", tEnd=" + tEnd +
				", min=" + min +
				'}';
	}

	@Override
	public boolean equals(Object c){
		if(c == this) return true;
		if(!(c instanceof Coord)) return false;
		Coord c1 = (Coord) c;
		return c1.x == this.x && c1.y == this.y && c1.passed == this.passed && c1.min == this.min && c1.tStart == this.tStart && c1.tEnd == this.tEnd;
	}

	@Override
	public int hashCode(){
		return Integer.parseInt("" + Math.abs(this.x) + "" + Math.abs(this.y));
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