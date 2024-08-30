import java.io.*;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        T = io.nextInt();
        for (int a=0; a<T; a++){
            int N = io.nextInt();
            int Q = io.nextInt();
            int C = io.nextInt();
            int[] seq = new int[N+1];
            int[] max = new int[N+1];
            boolean brk = false;
            int MAX = 1;

            ArrayList<Pair> pairs = new ArrayList<>();
            Queue<Integer> zero = new LinkedList<>();
            for (int i=1; i<N+1; i++){
                seq[i] = io.nextInt();
                if(seq[i] == 0) zero.add(i);
                MAX = Math.max(MAX, seq[i]);
                max[i] = MAX;
            }

            for (int i=0; i<Q; i++){
                pairs.add(new Pair(io.nextInt(), io.nextInt()));
            }
            Collections.sort(pairs);
            Queue<Pair> q = new LinkedList<>(pairs);
            if(seq[1] == 0) seq[1] = 1;

            while (!q.isEmpty()){
                Pair p = q.poll();
                //Case 1: Aj is 0
                if(seq[p.a] == 0 && seq[p.h] != 0){
                    seq[p.a] = max[p.h-1];
                    if(!zero.isEmpty()){
                        while (p.a > zero.peek()){
                            if(seq[zero.peek()] != 0){
                                zero.poll();
                                if(zero.isEmpty()) break;
                                continue;
                            }
                            seq[zero.poll()] = max[p.h-1];
                            if(zero.isEmpty()) break;
                        }
                    }


                    if(seq[p.a] >= seq[p.h]){
                        brk=true;
                        break;
                    }

                }
                //Case 2: Hj is 0
                else if(seq[p.h] == 0 && seq[p.a] != 0){
                    if(max[p.h-1]+1 > C || max[p.h-1] != seq[p.a]){
                        brk = true;
                        break;
                    }
                    seq[p.h] = seq[p.a]+1;
                    max[p.h] = seq[p.h];
                }

                //Case 3: Both are 0
                else if(seq[p.h] == 0 && seq[p.a] == 0){
                    seq[p.a] = max[p.h-1];
                    for (int j=p.a; j<p.h; j++){
                        max[j] = seq[p.a];
                        if(seq[j] == seq[p.a]) break;
                    }
                    if(max[p.h-1]+1 > C || max[p.h-1] != seq[p.a]){
                        brk = true;
                        break;
                    }
                    seq[p.h] = seq[p.a]+1;
                    max[p.h] = seq[p.h];
                }

                //Case 4: Both are #


            }
            while(!zero.isEmpty()){
                if(seq[zero.peek()] != 0){
                    zero.poll();
                    if(zero.isEmpty()) break;
                    continue;
                }
                seq[zero.poll()] = 1;


            }
            if(brk) System.out.println(-1);
            else{
                StringBuilder s = new StringBuilder();
                for (int i=1; i<N+1; i++){
                    s.append(seq[i]);
                    if(i != N) s.append(" ");
                }
                System.out.println(s);
            }

        }

    }

}

class Pair implements Comparable<Pair>{
    int a;
    int h;

    public Pair(int a, int h){
        this.a = a;
        this.h = h;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.h == o.h) return Integer.compare(this.a, o.a);
        return Integer.compare(this.h, o.h);
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