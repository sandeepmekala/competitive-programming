package algorithms;
import java.util.Arrays;

public class Knapsack01DynamicProgramming {

	private static int w[] = {1,2,3,4,5};
	private static int v[] = {5,3,5,3,2};
	private static int mid_results[][] = new int[5][10];
	public static void main(String[] args) {

		System.out.println(KS(4, 10));		
	}
	private static int KS(int n, int c){
		if(n >= 0 && c > 0 && mid_results[n][c-1] != 0){
			return mid_results[n][c-1];
		}
		if(n == -1 || c == 0)
			return 0;
		else if(w[n] > c){
			return KS(n-1, c);
		}else{
			int temp1 = KS(n-1, c);
			int temp2 = v[n] + KS(n-1, c-w[n]);
			mid_results[n][c-1] = Math.max(temp1, temp2);
			return Math.max(temp1, temp2);
		}
	}

}
