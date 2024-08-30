import com.sun.source.util.*;

import java.io.*;
import java.util.*;

/*
Check if multiple maximums are there test case



*/

public class Main {
    static int N, T;
    static ArrayList<Integer> log;

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		T = io.nextInt();
		for (int a=0; a<T; a++){
            N = io.nextInt();
            log = new ArrayList<>();
            int counter = 0;
            int sum=0;
            for (int i=0; i<N; i++){
                int x = io.nextInt();
                sum += x;
                log.add(x);
            }
            ArrayList<Integer> logCopy = new ArrayList<>(log);
            TreeSet<Integer> possVal = new TreeSet<>();
            for (int i=1; i<=Math.sqrt(sum); i++){
                if(sum % i == 0){
                    possVal.add(i);
                    possVal.add(sum/i);
                }
            }
            ArrayList<Integer> x = new ArrayList<>(possVal);
            Collections.reverse(x);
            for (Integer i: x){
                if(checkSame()){
                    break;
                }
                if(i > log.size()) continue;
                log = new ArrayList<>(logCopy);
                int num = sum/i;
                int j = 0;
                counter = 0;
                while (j<log.size()-1){
                    if (log.get(j)<num){
                        if(log.get(j)+log.get(j+1)<=num){
                            int y = log.get(j+1);
                            log.remove(j+1);
                            log.set(j, log.get(j)+y);
                            counter++;
                            j--;
                        } else{
                            break;
                        }
                    } else if (log.get(j)>num) break;
                    j++;

                }

            }




            System.out.println(counter);
        }














    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }

    private static boolean checkSame(){
        int x = log.get(0);
        for (Integer integer : log) {
            if (integer != x) return false;
        }


        return true;

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