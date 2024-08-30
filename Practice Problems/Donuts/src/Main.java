import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count=0;
    static int[] answers;
    static ArrayList<Cow> cows = new ArrayList<>();
    static ArrayList<Donut> donuts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        N = io.nextInt();
        M = io.nextInt();
        answers = new int[N+1];
        for (int i=0; i<M+1; i++){
            donuts.add(new Donut(false, 0));
        }
        cows.add(new Cow(Integer.MAX_VALUE, Integer.MAX_VALUE));
        for (int i=0; i<N; i++){
            cows.add(new Cow(io.nextInt(), io.nextInt()));
        }
        for (int i=N; i>=1; i--){
            if(!donuts.get(cows.get(i).f).used){
                donuts.get(cows.get(i).f).used = true;
                donuts.get(cows.get(i).f).cow = i;
                count++;
            }
            else{
                changeDonut(i, 'f');
            }
            answers[i] = count;
        }
        for (int i=1; i<N+1; i++){
            System.out.println(answers[i]);
        }

    }

    private static void changeDonut(int newCow, char option){
        int num;
        if (option == 'f') num = cows.get(newCow).f;
        else num = cows.get(newCow).s;
        int oldCow = donuts.get(num).cow;
        donuts.get(num).cow = newCow;
        if(!donuts.get(cows.get(oldCow).s).used){
            donuts.get(cows.get(oldCow).s).used = true;
            donuts.get(cows.get(oldCow).s).cow = oldCow;
            count++;
        }
        else if(oldCow < donuts.get(cows.get(oldCow).s).cow) { changeDonut(oldCow, 's');
        }
    }

}

class Donut{
    boolean used;
    int cow;

    public Donut(boolean u, int cow){
        used = u;
        this.cow = cow;
    }
}

class Cow{
    int f;
    int s;

    public Cow(int f, int s){
        this.f = f;
        this.s = s;
    }
}

@SuppressWarnings("ALL")
class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;

    public Kattio() {
        this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(String problemName) throws IOException {
        super(new FileWriter(problemName + ".out"));
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }

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