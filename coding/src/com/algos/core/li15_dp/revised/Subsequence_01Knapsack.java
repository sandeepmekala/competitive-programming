package  com.algos.core.li15_dp.revised;

public class Subsequence_01Knapsack {

	public static void main(String[] args) {
		Subsequence_01Knapsack obj = new Subsequence_01Knapsack();
		
		int[] weights = { 1, 2, 3, 4, 5 };
		int[] values = { 5, 3, 5, 3, 2 };
		int n = 4, wt = 10;
		System.out.println(obj.knapsack(weights, values, n, wt));
		System.out.println(obj.knapsack(weights, values, n, wt));	// n, W
	}
	
	//  Problem: https://bit.ly/3KHpP3v
	//  
	//  n\w	0 	1	2	3	4	5	6	7	8	9	10
	//  1(5)	0	5	5	5	5	5	5	5	5	 5	5
	//  2(3)	0	5	5	8	8	8	8	8	8	8	8	
	//  3(5)	0	5	5	8	8	8	13	13	13	13	13
	//  4(3)	0	5	5	8	8	8	13	13	13	13	16
	//  5(2)	0	5	5	5	8	8	13	13	13	13	16
	//
	// Time: O(n*Wmax)
    // Space: O(n*Wmax)
	public int knapsack(int[] weight, int[] value, int n, int wmax) {
		int[][] val = new int[n][wmax+1];
		for(int ind=0; ind<n; ind++) {
			for(int w=0; w<=wmax; w++) {	
				if(ind == 0) {
					if(weight[0] <= w)			// for every wt w, we can pick 0th element
						val[0][w] = value[0];
				}else {
					int notPick = 0 + val[ind-1][w];
					int pick = Integer.MIN_VALUE;
					if(weight[ind] <= w)
						pick = value[ind]+val[ind-1][w-weight[ind]];
					val[ind][w] = Math.max(notPick, pick);
				}
			}
		}
		return val[n-1][wmax];
	}

	// n and w defines the state
	// O(N*Wmax) where n=number of elements and w is max weight
	public int knapsack2(int[] weight, int[] value, int ind, int wmax) {
		if (ind == 0){
			if(weight[0] <= wmax)
				return value[0];
			return 0;
		}
			
		int notPick = 0 + knapsack(weight, value, ind - 1, wmax);
		int pick = Integer.MIN_VALUE;
		if(weight[ind] <= wmax)
			pick = value[ind] + knapsack(weight, value, ind - 1, wmax - weight[ind]);

		return Math.max(notPick, pick);
	}
}
