package edu.algos.li21_dp2;

public class Knapsack_A01_Knapsack {

	public static void main(String[] args) {
		Knapsack_A01_Knapsack obj = new Knapsack_A01_Knapsack();
		
		int weights[] = { 1, 2, 3, 4, 5 };
		int values[] = { 5, 3, 5, 3, 2 };
		int n = 4, wt = 10;
		int mem[][] = new int[n+1][wt+1];
		System.out.println(obj.knapsackBottomUp(weights, values, n, wt));
		System.out.println(obj.knapsackTopDown(weights, values, n, wt, mem));	// n, W
	}
	
	/*
	 * Problem: Maximize the value by placing the objects in knapsack
	 * Idea: 
	 * 
	 * n\w	0 	1	2	3	4	5	6	7	8	9	10
	 * 0	0	0	0	0	0	0	0	0	0	0	0
	 * 1(5)	0	5	5	5	5	5	5	5	5	5	5
	 * 2(3)	0	5	5	8	8	8	8	8	8	8	8	
	 * 3(5)	0	5	5	8	8	8	13	13	13	13	13
	 * 4(3)	0	5	5	8	8	8	13	13	13	13	16
	 * 5(2)	0	5	5	5	8	8	13	13	13	13	16
	 * */
	// time: O(n*Wmax)
	public int knapsackBottomUp(int[] w, int[] v, int n, int wt) {
		int mem[][] = new int[n+1][wt+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=wt; j++) {	
				if(i == 0 || j == 0) {
					mem[i][j] = 0;
				}else if(w[i-1] > j){
					mem[i][j] = mem[i-1][j];
				}else {
					mem[i][j] = Math.max(mem[i-1][j], v[i-1]+mem[i-1][j-w[i-1]]);
				}
			}
		}
		return mem[n][wt];
	}

	// n and w defines the state
	// O(N*Wmax) where n=number of elements and w is max weight
	public int knapsackTopDown(int[] w, int[] v, int n, int wt, int[][] memory) {
		if (n >= 0 && wt >= 0 && memory[n][wt] != 0) {
			return memory[n][wt];
		}
		if (n < 0 || wt < 0)
			return 0;
		else if (w[n] > wt) {
			memory[n][wt] = knapsackTopDown(w, v, n - 1, wt, memory);
		} else {
			int pick = v[n] + knapsackTopDown(w, v, n - 1, wt - w[n], memory);
			int notPick = knapsackTopDown(w, v, n - 1, wt, memory);
			memory[n][wt] = Math.max(pick, notPick);
		}
		return memory[n][wt];
	}
		
	public int KnapsackRec(int[] w, int[] v, int n, int wt) {

		if (n < 0 || wt < 0)
			return 0;
		else if (w[n] > wt) {
			return KnapsackRec(w, v, n - 1, wt);
		} else {
			int withoutItmSelect = KnapsackRec(w, v, n - 1, wt);
			int withItmSelect = v[n] + KnapsackRec(w, v, n - 1, wt - w[n]);
			return Math.max(withoutItmSelect, withItmSelect);
		}
	}
}
