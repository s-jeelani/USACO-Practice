import java.io.*;
import java.util.*;

/*
Loop through string all the way, each time, find pairs, find string in between, find the amount of single letters in that string, divide everything by 2.
*/

public class Main {
    static String N;
    static int X;
    static HashMap<Character, Integer> letters = new HashMap<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("circlecross");
		N = io.next();
		int counter;
		String temp;
		for (int i=0; i<52; i++){
		    char c = N.charAt(i);
		    counter = i+1;
		    temp = "";
            //clockwise
            while (true){
                if(counter > 51) counter = 0;
                if(N.charAt(counter) == c) break;
                temp += N.charAt(counter);
                counter++;
            }
            if(temp.length() > 26) {
                //counter-clockwise
                counter = i-1;
                temp = "";
                while (true) {
                    if (counter < 0) counter = 51;
                    if (N.charAt(counter) == c) break;
                    temp += N.charAt(counter);
                    counter--;
                }
            }
            letters = new HashMap<>();
            for (char c1: temp.toCharArray()){
                if (letters.containsKey(c1)) {

                    // If char is present in charCountMap,
                    // incrementing it's count by 1
                    letters.put(c1, letters.get(c1) + 1);
                }
                else {

                    // If char is not present in charCountMap,
                    // putting this char to charCountMap with 1 as it's value
                    letters.put(c1, 1);
                }
            }
            for (Map.Entry<Character, Integer> e : letters.entrySet()){
                if(e.getValue() == 1) X++;
            }

        }
		io.write(X/4 + "");
		io.close();









    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
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