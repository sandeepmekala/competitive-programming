package edu.algos.li21_dp2;

public class Dp01Knapsack {

	private static int w[] = { 1, 2, 3, 4, 5 };
	private static int v[] = { 5, 3, 5, 3, 2 };
	static int n = 4;
	static int W = 10;
	public static void main(String[] args) {
		Dp01Knapsack obj = new Dp01Knapsack();

		System.out.println(obj.knapsackBottomUp(n, W));
		System.out.println(obj.knapsackTopDown(n, W));	// n, W
		
	}
	
	/*
	 * Idea: Maximize the value by placing the objects in knapsack
	 * 
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
	private int knapsackBottomUp(int n, int wt) {
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
	private int memory[][] = new int[n+1][W+1];
	private int knapsackTopDown(int n, int wt) {
		if (n >= 0 && wt >= 0 && memory[n][wt] != 0) {
			return memory[n][wt];
		}
		if (n < 0 || wt < 0)
			return 0;
		else if (w[n] > wt) {
			memory[n][wt] = knapsackTopDown(n - 1, wt);
		} else {
			int val1 = knapsackTopDown(n - 1, wt);
			int val2 = v[n] + knapsackTopDown(n - 1, wt - w[n]);
			memory[n][wt] = Math.max(val1, val2);
		}
		return memory[n][wt];
	}
		
	private int KnapsackRec(int n, int wt) {

		if (n < 0 || wt < 0)
			return 0;
		else if (w[n] > wt) {
			return KnapsackRec(n - 1, wt);
		} else {
			int withoutItmSelect = KnapsackRec(n - 1, wt);
			int withItmSelect = v[n] + KnapsackRec(n - 1, wt - w[n]);
			return Math.max(withoutItmSelect, withItmSelect);
		}
	}
}
