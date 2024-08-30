import java.io.*;
import java.util.*;

public class Main {
    static int N, T,P;
    static Tube t1 = new Tube(1);
    static Tube t2 =  new Tube(2);
    static Tube t3 = new Tube(3);
    static Tube[] tubes = {t1, t2, t3};
    static int f, g;
    static int cnt=0;
    static StringBuilder z = new StringBuilder();

    /*
    P1 Strategy: O(1) calculation using length and last term
    P2 Strategy:
    P3 Strategy:
     */

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        T = io.nextInt();
        for (int a=0; a<T; a++ ){
            N = io.nextInt();
            P = io.nextInt();

            t1 = new Tube(1);
            t2 =  new Tube(2);
            t3 = new Tube(3);
            z = new StringBuilder();
            char[] l = io.next().toCharArray();
            f = Character.getNumericValue(l[0]);
            char cur = '0';
            for (char c : l){
                if(c != cur){ t1.L.add(Character.getNumericValue(c));
                cur = c;
            }}

            l = io.next().toCharArray();
            cur = '0';
            g = Character.getNumericValue(l[0]);
            for (char c : l){
                if(c != cur){ t2.L.add(Character.getNumericValue(c));
                cur = c;
            }}
            cnt=0;
            t3.L.add(0);
            solve();
        }

    }

    /*
    private static int findM(){


        int d = t1.L.get(0) == t2.L.get(0) ? 0 : -1;
        if(b == 1 && c <=2 || c==1 && b<=2){
            return (b+c+d-1);
        }
        return (b+c+d);



    }
    */
    /*
     D - S: 0
     S - D: 0 take the one opp to S
     D - D: -1 No affect
     S - S: 0 No affect
     */

    private static void solve(){

        if(f == g){
            if(t1.L.peek() == t2.L.peek() || t2.L.peek() == f){
                move(1);
            }
            else{
                move(2);
            }
        }
        else{
            move(1);
        }
        System.out.println(cnt);
        System.out.print(z);







    }

    private static void move(int n){
        if(t1.L.size() <= 1 && t2.L.size() <= 1){
            ret();
            return;
        }
        if(t1.L.size() <= 1 && n == 1){
            move(2);
            return;
        }
        if(t2.L.size() <= 1 && n == 2){
            move(1);
            return;
        }
        cnt++;

        switch(n){

            case 1:
                if(t1.L.peek() == t2.L.peek()){
                    t1.L.pop();
                    if(P == 2 || P == 3) z.append("1 2\n");

                }
                else{
                    if(P == 2 || P == 3) z.append("1 3\n");
                    if(t3.L.peek() == 0){
                        t3.L.pop();
                        t3.L.add(t1.L.pop());

                    }
                    else{
                        t1.L.pop();

                    }
                }
                move(1);
                return;
            case 2:
                if(t1.L.peek() == t2.L.peek()){
                    t2.L.pop();
                    if(P == 2 || P == 3) z.append("2 1\n");

                }
                else{
                    if(P == 2 || P == 3) z.append("2 3\n");
                    if(t3.L.peek() == 0){
                        t3.L.pop();
                        t3.L.add(t2.L.pop());

                    }
                    else{
                        t2.L.pop();

                    }
                }
                move(2);

        }
    }

    private static void ret(){
        if(t3.L.peek() == 0) {
        }
        else if(t1.L.peek() == t2.L.peek()){
            if(P == 2 || P == 3) z.append("2 1\n");
            if(P == 2 || P == 3) z.append("3 2\n");
            cnt += 2;
        }
        else{
            cnt += 1;
            if(t1.L.peek() == t3.L.peek()){
                if(P == 2 || P == 3) z.append("3 1\n");
            }
            else{
                if(P == 2 || P == 3) z.append("3 2\n");
            }
        }
    }

}

class Tube{
    int n;
    Stack<Integer> L = new Stack<>();


    public Tube(int n){
        this.n = n;
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