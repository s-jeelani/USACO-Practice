import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N, P;
    static ArrayList<Post> posts = new ArrayList<>();
    static TreeMap<Integer, TreeSet<Integer>> XadjL = new TreeMap<>();
    static TreeMap<Integer, TreeSet<Integer>> YadjL = new TreeMap<>();
    static ArrayList<Edge> edges = new ArrayList<>();
    static Post p;
    static boolean TWICE = false;


    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("pfp");
        N = io.nextInt();
        P = io.nextInt();
        for (int i=1; i<P+1; i++){
            int x = io.nextInt();
            int y = io.nextInt();
            if(!XadjL.containsKey(x)) XadjL.put(x, new TreeSet<>());
            XadjL.get(x).add(y);

            if(!YadjL.containsKey(y)) YadjL.put(y, new TreeSet<>());
            YadjL.get(y).add(x);
        }
        p = new Post(XadjL.firstKey(), );
        createLine();
        System.out.println(XadjL + " " + YadjL);


    }

    private static void createLine(){

        XadjL.get(p.x).remove(p.y);
        YadjL.get(p.y).remove(p.x);
        recur(p, -1);
        System.out.println(edges);
    }

    private static void recur(Post m, int s){
        if(m.equals(p)){
            if (TWICE) return;
            TWICE = true;
        }
        if(s == -1){
            Post q = new Post(m.x, XadjL.get(m.x).first());
            if(p.equals())
            edges.add(new Edge(m, q, s));
            recur(q, 1);
        }
        else{
            Post q = new Post(YadjL.get(m.y).first(), m.y);
            edges.add(new Edge(m, q, s));
            recur(q, -1);
        }
    }

}

class Edge{
    Post post1;
    Post post2;
    int s; // 1 is V -1 is H

    public Edge(Post post1, Post post2, int s){
        this.post1 = post1;
        this.post2 = post2;
        this.s = s;

    }

    @Override
    public String toString() {
        return "Edge{" +
                "post1=" + post1 +
                ", post2=" + post2 +
                ", s=" + s +
                '}';
    }
}

class Post implements Comparable<Post>{
    int x;
    int y;

    public Post(int x, int y){
        this.x = x;
        this.y = y;

    }


    @Override
    public int compareTo(Post o) {
        if(x == o.x) return Integer.compare(y, o.y);
        return Integer.compare(x, o.x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return x == post.x && y == post.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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