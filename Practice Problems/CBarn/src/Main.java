import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, distTraveled, min= Integer.MAX_VALUE, current, remainingCows, totalCows;
    static ArrayList<Integer> cows = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("cbarn");
		N = io.nextInt();
		for (int i=0; i<N; i++){
			current = io.nextInt();
			cows.add(current);
			remainingCows += current;
			rooms.add(new Room(current));
		}
		totalCows = remainingCows;
		for (int i=0; i<N; i++){
			current = testRoom(i);
			if(current < min) min = current;
		}
		io.write("" + min);
		io.close();









    }

    private static int testRoom(int n){
        remainingCows = totalCows;
        distTraveled = 0;
        Room r = rooms.get(0);
        for (int i=0; i<rooms.size(); i++){
            Room p = rooms.get(i);
            if(i!=0) distTraveled += remainingCows;
            remainingCows -= p.cowsNeeded;

        }
        rooms.add(r);
        rooms.remove(0);
        return distTraveled;
    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Room{
	int cowsNeeded;

	public Room(int cowsNeeded){
		this.cowsNeeded = cowsNeeded;
	}

    @Override
    public String toString() {
        return "Room{" +
                "cowsNeeded=" + cowsNeeded +
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