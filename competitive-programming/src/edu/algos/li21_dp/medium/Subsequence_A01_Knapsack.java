package edu.algos.li21_dp2;

public class Subsequence_A01_Knapsack {

	public static void main(String[] args) {
		Subsequence_A01_Knapsack obj = new Subsequence_A01_Knapsack();
		
		int weights[] = { 1, 2, 3, 4, 5 };
		int values[] = { 5, 3, 5, 3, 2 };
		int n = 4, wt = 10;
		int mem[][] = new int[n+1][wt+1];
		System.out.println(obj.knapsack(weights, values, n, wt));
		System.out.println(obj.Knapsack(weights, values, n, wt));	// n, W
	}
	
	/*
	 * Problem: Maximize the value by placing the objects in knapsack
	 * Idea: 
	 * 
	 * n\w	0 	1	2	3	4	5	6	7	8	9	10
	 * 1(5)	0	5	5	5	5	5	5	5	5	 5	5
	 * 2(3)	0	5	5	8	8	8	8	8	8	8	8	
	 * 3(5)	0	5	5	8	8	8	13	13	13	13	13
	 * 4(3)	0	5	5	8	8	8	13	13	13	13	16
	 * 5(2)	0	5	5	5	8	8	13	13	13	13	16
	 * */
	// time: O(n*Wmax)
	public int knapsack(int[] wt, int[] val, int n, int weight) {
		int value[][] = new int[n][weight+1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<=weight; j++) {	
				if(i == 0) {
					if(wt[i] <= j)
						value[i][j] = val[i];
				}else {
					int notPick = value[i-1][j];
					int pick = Integer.MIN_VALUE;
					if(wt[i] <= j)
						pick = val[i]+value[i-1][j-wt[i]];
					value[i][j] = Math.max(notPick, pick);
				}
			}
		}
		return value[n-1][weight];
	}

	// n and w defines the state
	// O(N*Wmax) where n=number of elements and w is max weight
	public int Knapsack(int[] wt, int[] val, int i, int weight) {
		if (i == 0){
			if(wt[0] <= weight) return val[0];
			return 0;
		}
			
		int notPick = 0 + Knapsack(wt, val, i - 1, weight);
		int pick = Integer.MIN_VALUE;
		if(wt[i] <= weight)
			pick = val[i] + Knapsack(wt, val, i - 1, weight - wt[i]);

		return Math.max(notPick, pick);
	}
}
