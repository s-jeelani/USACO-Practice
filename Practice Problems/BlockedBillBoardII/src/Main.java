import java.io.*;
import java.util.*;

/*
Blocked Billboard II
O(1)
*/

public class Main {
    static StringTokenizer st;
    static int a, b, c, d;
    static double tarp;
    static int cornersCovered;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("billboard.out"));
        st = new StringTokenizer(fin.readLine());
        a = toInt(st.nextToken()); b = toInt(st.nextToken()); c = toInt(st.nextToken()); d = toInt(st.nextToken());
        Rect lawn = new Rect(a,d, Math.abs(c-a), Math.abs(d-b));
        st = new StringTokenizer(fin.readLine());
        a = toInt(st.nextToken()); b = toInt(st.nextToken()); c = toInt(st.nextToken()); d = toInt(st.nextToken());
        Rect feed = new Rect(a,d, Math.abs(c-a), Math.abs(d-b));
        if(feed.covers(lawn.x1, lawn.y1)) cornersCovered++;
        if(feed.covers(lawn.x2, lawn.y2)) cornersCovered++;
        if(feed.covers(lawn.x3, lawn.y3)) cornersCovered++;
        if(feed.covers(lawn.x4, lawn.y4)) cornersCovered++;
        if(cornersCovered == 4) tarp = 0;
        if(cornersCovered < 2) tarp = lawn.width * lawn.height;
        if(cornersCovered == 2) tarp = (lawn.width * lawn.height) - feed.intersection(lawn);

        fout.write(String.valueOf((int) tarp));
        fout.close();
    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Rect{
    int x1;
    int y1;
    int x2;
    int y2;
    int x3;
    int y3;
    int x4;
    int y4;
    int height;
    int width;
    // x and y for (x, y) is the top left corner of de rectangle
    public Rect(int x, int y, int width, int height){
        this.x1 = x;
        this.y1 = y;
        this.x2 = x+width;
        this.y2 = y;
        this.x3 = x+width;
        this.y3 = y-height;
        this.x4 = x;
        this.y4 = y-height;
        this.height = height;
        this.width = width;

    }

    @Override
    public String toString() {
        return "Rect{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                ", x4=" + x4 +
                ", y4=" + y4 +
                '}';
    }

    public boolean covers(int x, int y){
        return (x1 <= x) && (x2 >= x) && (y1 >= y) && (y3 <= y);
    }

    public int intersection(Rect r){
        int xL = Math.max(this.x1, r.x1);
        int xR = Math.min(this.x2, r.x2);
        int yT = Math.max(this.y4, r.y4);
        int yB = Math.min(this.y1, r.y1);
        return (xR-xL) * (yB-yT);
    }
}