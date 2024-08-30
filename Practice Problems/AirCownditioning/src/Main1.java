import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main1 {
    static int N;
    static ArrayList<Integer> p = new ArrayList<>();
    static ArrayList<Integer> differences = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> sets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		N = io.nextInt();
		for(int i=0; i<N; i++){
			p.add(io.nextInt());
		}
		for(int i=0; i<N; i++){
			differences.add(p.get(i)-io.nextInt());
		}
		sets = makeSets(differences);


		int min = MainFunc();
        System.out.println(min +"");








    }

    private static int toInt(String x) {
        return Integer.parseInt(x);
    }

    public static int MainFunc(){
        int counter = 0;
        Pair p = meddle(sets.get(0));
        counter += p.count;
        sets.remove(0);
        sets.addAll(makeSets(p.ar));
        System.out.println(p.ar);
		while(!checkZeros(sets)){
		    meddle(sets.get(sets.size()-1));
            counter += p.count;
            sets.remove(sets.get(sets.size()-1));
            sets.addAll(makeSets(p.ar));
            System.out.println(counter);
        }
		return counter;
	}

	public static Pair meddle(ArrayList<Integer> ar){
        System.out.println(ar);
        if(ar.size() != 1) {
            ArrayList<Integer> newAr = new ArrayList<>();
            for (Integer i : ar) {
                newAr.add(Math.abs(i));
            }
            int minimum = min(newAr);
            for (int i = 0; i < ar.size(); i++) {
                newAr.add(i, newAr.get(i) - minimum);
                newAr.remove(i + 1);
            }
            return new Pair(minimum, newAr);
        }
        return new Pair(ar.get(0), new ArrayList<>(Arrays.asList(0)));

    }

    public static int min(ArrayList<Integer> ar){
        int minimum = Integer.MAX_VALUE;
        for(Integer i: ar){
            if(i < minimum) minimum = i;
        }
        return minimum;
    }

    public static ArrayList<ArrayList<Integer>> makeSets(ArrayList<Integer> arr){
        ArrayList<ArrayList<Integer>> sets1 = new ArrayList<>();
        boolean first = true;
        int cur = 0;
        for(Integer i : arr){
            if(first){
                if(i == 0) continue;
                if(i < 0) cur = -1;
                if(i > 0) cur = 1;
                sets1.add(new ArrayList<>((Arrays.asList(i))));
                first = false;
                continue;
            }
            if(i == 0){
                sets1.add(new ArrayList<>((Arrays.asList(0))));
                cur = 0;
            } else if(Math.abs(i)/i == cur){
                sets1.get(sets1.size()-1).add(i);
            } else{
                sets1.add(new ArrayList<>((Arrays.asList(i))));
                cur = Math.abs(i)/i;
            }
        }
        System.out.println(sets1);
        return sets1;
    }

    public static boolean checkZeros(ArrayList<ArrayList<Integer>> arr){
        for(ArrayList<Integer> i: arr){
            for(Integer i1 : i){
                if(i1 != 0) return false;
            }
        }
        return true;
    }

}


class Pair{
    int count;
    ArrayList<Integer> ar;

    public Pair(int count, ArrayList<Integer> ar){
        this.count = count;
        this.ar = ar;
    }


}










@SuppressWarnings("ALL")
