import java.io.*;
import java.util.*;
import java.util.stream.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N;
    static ArrayList<Block> blocks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    	Kattio io = new Kattio();
    	N = io.nextInt();
    	for (int i=0; i<4; i++){
    		String s = io.next();
    		char[] c = s.toCharArray();
    		ArrayList<Character> x = new ArrayList<>();
			for (char c1 : c) {
				x.add(c1);
			}
    		blocks.add(new Block(x, s));
		}
    	for (int i=0; i<N; i++) {
    	    String ans = "NO";
            HashMap<Integer, ArrayList<Block>> hm = new HashMap<>();
            String s = io.next();
            char[] carr = s.toCharArray();

            ArrayList<Character> cList = new ArrayList<>();
            for (char c1 : carr) {
                cList.add(c1);
            }

            int r =0;

            for (Character x : cList) {
                hm.put(r, new ArrayList<>());
                for (Block b : blocks) {
                    if (b.charCount.get(x) > 0) {
                        ArrayList<Block> bs = hm.get(r);
                        bs.add(b);
                        hm.put(r, bs);
                    }
                }
                r++;
            }
            ArrayList<Block> unusuableBlocks = new ArrayList<>();
            boolean br1=false,br2=false,br3=false,br4=false;
            if (s.length() == 1) {
                if (hm.get(cList.indexOf(s.charAt(0))).size() > 0) ans = "YES";
            } else if (s.length() == 2){

                for (Block b: hm.get(cList.indexOf(s.charAt(0)))){

                    unusuableBlocks.add(b);

                    for (Block b1: hm.get(cList.indexOf(s.charAt(1)))){
                        for (Block u: unusuableBlocks){
                            if(b1 == u){
                                br1 = true;
                                break;
                            }
                        }
                        if(br1) continue;
                        ans = "YES";
                        break;
                    }
                    if(ans.equals("YES")) break;
                    unusuableBlocks.remove(b);

                }


            } else if (s.length() == 3) {

                for (Block b: hm.get(cList.indexOf(s.charAt(0)))){

                    unusuableBlocks.add(b);

                    for (Block b1: hm.get(cList.indexOf(s.charAt(1)))){
                        br1 = false;
                        for (Block u: unusuableBlocks){
                            if(b1 == u){
                                br1 = true;
                                break;
                            }
                        }
                        if(br1) continue;
                        unusuableBlocks.add(b1);
                        for (Block b2: hm.get(cList.indexOf(s.charAt(2)))){
                            br2 = false;
                            for (Block u: unusuableBlocks){
                                if(b2 == u){
                                    br2 = true;
                                    break;
                                }
                            }
                            if(br2) continue;
                            ans = "YES";
                            break;
                        }
                        if(ans.equals("YES")) break;
                        unusuableBlocks.remove(b1);
                    }
                    if(ans.equals("YES")) break;
                    unusuableBlocks.remove(b);

                }


            } else{

                for (Block b: hm.get(cList.indexOf(s.charAt(0)))){

                    unusuableBlocks.add(b);

                    for (Block b1: hm.get(cList.indexOf(s.charAt(1)))){
                        br1 = false;
                        for (Block u: unusuableBlocks){
                            if(b1 == u){
                                br1 = true;
                                break;
                            }
                        }
                        if(br1) continue;
                        unusuableBlocks.add(b1);
                        for (Block b2: hm.get(cList.indexOf(s.charAt(2)))){
                            br2 = false;
                            for (Block u: unusuableBlocks){
                                if(b2 == u){
                                    br2 = true;
                                    break;
                                }
                            }
                            if(br2) continue;
                            unusuableBlocks.add(b2);
                            for (Block b3: hm.get(cList.indexOf(s.charAt(3)))){
                                br3 = false;
                                for (Block u: unusuableBlocks){
                                    if(b3 == u){
                                        br3 = true;
                                        break;
                                    }
                                }
                                if(br3) continue;
                                ans = "YES";
                                break;
                            }
                            if(ans.equals("YES")) break;
                            unusuableBlocks.remove(b2);
                        }
                        if(ans.equals("YES")) break;
                        unusuableBlocks.remove(b1);
                    }
                    if(ans.equals("YES")) break;
                    unusuableBlocks.remove(b);

                }

            }
            System.out.println(ans);
        }











    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }


}

class Block{
    ArrayList<Character> c;
    String s;
    HashMap<Character, Integer> charCount = new HashMap<>() {{
        put('A', 0);
        put('B', 0);
        put('C', 0);
        put('D', 0);
        put('E', 0);
        put('F', 0);
        put('G', 0);
        put('H', 0);
        put('I', 0);
        put('J', 0);
        put('K', 0);
        put('L', 0);
        put('M', 0);
        put('N', 0);
        put('O', 0);
        put('P', 0);
        put('Q', 0);
        put('R', 0);
        put('S', 0);
        put('T', 0);
        put('U', 0);
        put('V', 0);
        put('W', 0);
        put('X', 0);
        put('Y', 0);
        put('Z', 0);
    }};

    public Block(ArrayList<Character> c, String s){
        this.c = c;
        this.s = s;
        for (Character x: c){
            charCount.replace(x, charCount.get(x)+1);
        }
    }

    @Override
    public String toString() {
        return "Block{" +
                "s=" + s +
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