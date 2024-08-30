import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		N = io.nextInt();
		for (int z=0; z<N; z++){

			int maxdex=0;
			ArrayList<Long> nums = new ArrayList<>();
			int that = io.nextInt();
			for (int y=0; y<that; y++){
				nums.add(io.nextLong());
			}
			long num = 0;
			int prevMaxdex = -1;
			int prevMaxdex1 = -1;
			while (true){
				long min = Long.MAX_VALUE; long max = Long.MIN_VALUE;

				int i1, i2;
				for (int i=0; i<nums.size(); i++){
					if(nums.get(i) < min){
						min = nums.get(i);
					}
					if(nums.get(i) > max){
						max = nums.get(i);
						maxdex = i;
					}
				}
				if(min == max){
					break;
				}

				if(maxdex == 0){
					i1 = maxdex;
					i2 = maxdex+1;
				}
				else if(maxdex == nums.size()-1){
					i1 = maxdex;
					i2 = maxdex-1;
				}
				else{
					if(nums.get(maxdex+1) > nums.get(maxdex-1)){
						i1 = maxdex;
						i2 = maxdex+1;
					}
					else if(nums.get(maxdex + 1).equals(nums.get(maxdex - 1))){
						i1 = maxdex;
						if(Math.abs(maxdex+1 - nums.size()/2) > Math.abs(maxdex-1 - nums.size()/2)){
							i2 = maxdex+1;
						} else{
							i2 = maxdex-1;
						}
					}
					else{
						i1 = maxdex;
						i2 = maxdex-1;
					}
				}
				if((maxdex == prevMaxdex && prevMaxdex1 == i2) || min < 0){

					num = -1;
					break;
				}
				if(nums.get(i2) != min && nums.size() % 2 == 0){
					num += 2*(nums.get(i2) - min);

					nums.set(i1, nums.get(i1) - (nums.get(i2) - min));
					nums.set(i2, min);
				}
				else{
					num += 2*(nums.get(i1) - min);

					long x = nums.get(i2) - (nums.get(i1) - min);
					nums.set(i1, min);
					nums.set(i2, x);
				}




				prevMaxdex = maxdex;
				prevMaxdex1 = i2;



			}
			System.out.println(num);








		}









	}

	private static int toInt(String x) {
		return Integer.parseInt(x);
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