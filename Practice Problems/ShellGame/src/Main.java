import java.io.*;
import java.util.*;
import java.lang.*;

/*
Shell Game
O(n)
*/

public class Main {
    static int N;
    static int[][] swaps;
    static HashMap<Integer, Integer> values = new HashMap<>();
    static HashMap<Integer, Boolean> shells;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("shell.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("shell.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken());
        swaps = new int[N][3];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(fin.readLine());
            swaps[i] = new int[]{toInt(st.nextToken()),toInt(st.nextToken()), toInt(st.nextToken())};
        }
        values.put(1, findValue(1));
        values.put(2, findValue(2));
        values.put(3, findValue(3));
        ArrayList<Integer> sortedValues = new ArrayList<>(values.values());
        Collections.sort(sortedValues);
        fout.write(String.valueOf(sortedValues.get(sortedValues.size()-1)));
        fout.close();

    }
    //pl = pebbleLocation
    public static int findValue(int pl){
        int points = 0;
        boolean s1, s2;
        shells = new HashMap<>(Map.of(1, false, 2, false, 3, false));
        shells.replace(pl, true);
        for(int[] swap: swaps){
            s1 = shells.get(swap[0]);
            s2 = shells.get(swap[1]);
            shells.replace(swap[0], s2);
            shells.replace(swap[1], s1);

            if(shells.get(swap[2])) points++;
        }
        return points;
    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}