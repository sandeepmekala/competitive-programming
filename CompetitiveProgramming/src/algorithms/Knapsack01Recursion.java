package algorithms;

public class Knapsack01Recursion {

	private static int w[] = {1,2,3,4,5};
	private static int v[] = {5,3,5,3,2};
	public static void main(String[] args) {

		System.out.println(KS(4, 10));
	}
	private static int KS(int n, int c){
		
		if(n == -1 || c == 0)
			return 0;
		else if(w[n] > c){
			return KS(n-1, c);
		}else{
			int temp1 = KS(n-1, c);
			int temp2 = v[n] + KS(n-1, c-w[n]);
			return Math.max(temp1, temp2);
		}
	}

}
