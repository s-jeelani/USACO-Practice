import java.io.*;
import java.util.*;

public class Main {
    static int G,N;
    static int cnt=0;
    static ArrayList<Location> grazings = new ArrayList<>();
    static ArrayList<Location> alibis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        G = io.nextInt();
        N = io.nextInt();
        for (int i=0; i<G;i++){
            grazings.add(new Location(io.nextInt(), io.nextInt(), io.nextInt()));
        }
        for (int i=0; i<N;i++){
            alibis.add(new Location(io.nextInt(), io.nextInt(), io.nextInt()));
        }
        Collections.sort(grazings);
        Collections.sort(alibis);
        Location last = grazings.get(G-1);
        double xtra = calculateDist();
        for (int i=0; i<N; i++){
            Location l = alibis.get(i);
            double t = last.t - l.t + xtra;
            double distance = Math.sqrt(Math.pow(last.y-l.y, 2) + Math.pow(last.x-l.x,2));
            if(distance > t){
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static double calculateDist(){
        double extraTime = 0;
        for (int i=0; i<G-1;i++){
            double dist = Math.pow((grazings.get(i+1).y-grazings.get(i).y),2) + Math.pow((grazings.get(i+1).x-grazings.get(i).x),2);
            extraTime += grazings.get(i+1).t - grazings.get(i).t - Math.sqrt(dist);
        }
        return extraTime;
    }

}

class Location implements Comparable<Location> {
    int x;
    int y;
    double t;

    public Location(int x, int y, double t){
        this.x = x;
        this.y = y;
        this.t = t;

    }

    @Override
    public int compareTo(Location o) {
        return Double.compare(t, o.t);
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