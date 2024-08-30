import java.io.*;
import java.util.*;
import java.util.stream.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static Map<Character, Integer> letters = Stream.of(new Object[][] {
			{'a', 0},
			{'b', 0},
			{'c', 0},
			{'d', 0},
			{'e', 0},
			{'f', 0},
			{'g', 0},
			{'h', 0},
			{'i', 0},
			{'j', 0},
			{'k', 0},
			{'l', 0},
			{'m', 0},
			{'n', 0},
			{'o', 0},
			{'p', 0},
			{'q', 0},
			{'r', 0},
			{'s', 0},
			{'t', 0},
			{'u', 0},
			{'v', 0},
			{'w', 0},
			{'x', 0},
			{'y', 0},
			{'z', 0},
	}).collect(Collectors.toMap(data -> (Character) data[0],  data -> (Integer) data[1]));
    static ArrayList<Board> boards = new ArrayList<>();
    static Board b;
    static int totalLetters = 0;

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("blocks");
		N = io.nextInt();
		for (int i=0; i<N; i++){
			boards.add(new Board(io.next(), io.next()));
		}
		b = boards.get(0);
		for (Map.Entry<Character, Integer> e : letters.entrySet()){
			e.setValue(minLetters(e.getKey()));
			io.write(e.getValue() + "\n");
		}
		io.close();



    }

    private static int minLetters(Character c){
    	totalLetters = 0;
    	for (int i=0; i<N; i++){
    		Board bo = boards.get(i);
    		totalLetters += Math.max(countOccurences(bo.side1, c), countOccurences(bo.side2, c));
		}
    	return totalLetters;
	}

	private static int countOccurences(String s, Character c){
    	int count = 0;
    	for (Character c1 : s.toCharArray()) if(c == c1) count++;
		return count;
	}


    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}


class Board{
	String side1;
	String side2;

	public Board(String side1, String side2){
		this.side1 = side1;
		this.side2 = side2;
	}

	@Override
	public String toString() {
		return "Board{" +
				"side1='" + side1 + '\'' +
				", side2='" + side2 + '\'' +
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