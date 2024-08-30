import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N, Q;
    static ArrayList<Cow> sortedNums = new ArrayList<>();
    static HashMap<Integer, Integer> indexToSort = new HashMap<>();
    static ArrayList<_Query> queries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("milksum");
		N = io.nextInt();
        int l, index, bIndex, T;
        for (int i=0; i<N; i++){
            l = io.nextInt();
            sortedNums.add(new Cow(l, i));
        }
        Q = io.nextInt();
        for (int i=0; i<Q; i++){
            queries.add(new _Query(io.nextInt()-1, io.nextInt()));
        }
        Collections.sort(sortedNums);
        for (int i=0; i<N; i++){
            indexToSort.put(sortedNums.get(i).originalIndex, i);
        }
        ArrayList<Integer> prefix = calcPrefixSum(false);
        ArrayList<Integer> wPrefix = calcPrefixSum(true);
        ArrayList<Cow> copiedArray = new ArrayList<>(sortedNums);
        System.out.println(prefix);
        System.out.println(wPrefix);
        for (_Query q: queries){

            index = indexToSort.get(q.i);
            Cow old = copiedArray.get(index);

            copiedArray.set(index, new Cow(q.j,copiedArray.get(index).originalIndex));
            bIndex = binarySearch(0, N-1, sortedNums, q.j);
            T = wPrefix.get(N);

            System.out.println(index + " " + bIndex);

            if(bIndex + 1 >= index){
                T -= sortedNums.get(index).num * (index+1);
                T += (bIndex+1)*q.j;
                T += prefix.get(index+1) - prefix.get(bIndex+1);
            } else if(bIndex + 1 < index){
                T -= sortedNums.get(index).num * (index+1);
                T += (bIndex+1)*q.j;
                T += prefix.get(index) - prefix.get(bIndex);
            }
            io.write(T + "\n");
            copiedArray.set(index, old);
        }
        io.close();





    }

    private static int binarySearch(int start, int end, ArrayList<Cow> array, int num){
        if(end >= start){
            int mid = start + (end-start)/2;
            if(array.get(mid).num == num) return mid;
            if(array.get(mid).num > num) return binarySearch(start, mid-1, array, num);
            return binarySearch(mid+1, end, array, num);
        }
        if(start > N-1) return start-1;
        if(end < 0) return end+1;
        if(array.get(start).num > num) return end;
        else return start;


    }

    private static ArrayList<Integer> calcPrefixSum(boolean weighted){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        if(weighted){
            for (int i=0; i<N; i++){
                temp.add(temp.get(i)+(i+1)*sortedNums.get(i).num);
            }
        } else{
            for (int i=0; i<N; i++){
                temp.add(temp.get(i)+sortedNums.get(i).num);
            }
        }
        return temp;

    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }
}

class Cow implements Comparable<Cow>{
    int num;
    int originalIndex;

    public Cow(int num, int i){
        this.num = num;
        this.originalIndex = i;
    }


    @Override
    public int compareTo(Cow o) {
        return Integer.compare(num, o.num);
    }
}

class _Query{
    int i;
    int j;

    public _Query(int i, int j){
        this.i = i;
        this.j = j;
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