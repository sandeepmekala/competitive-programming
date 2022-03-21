package edu.algos.dp;

public class BasicKnapsack01 {

	private static int w[] = { 1, 2, 3, 4, 5 };
	private static int v[] = { 5, 3, 5, 3, 2 };
	static int W = 10;
	private static int memory[][] = new int[5][10];

	public static void main(String[] args) {

		System.out.println(KnapsackTopDown(4, W));	// n, c/W
		System.out.println(KnapsackBottomUp(4, W));
	}

	// n and w defines the state
	// O(N*Wmax) where n=number of elements and w is max weight
	private static int KnapsackTopDown(int n, int wt) {
		if (n >= 0 && wt > 0 && memory[n][wt - 1] != 0) {
			return memory[n][wt - 1];
		}
		if (n < 0 || wt < 0)
			return 0;
		else if (w[n] > wt) {
			return KnapsackTopDown(n - 1, wt);
		} else {
			int temp1 = KnapsackTopDown(n - 1, wt);
			int temp2 = v[n] + KnapsackTopDown(n - 1, wt - w[n]);
			memory[n][wt - 1] = Math.max(temp1, temp2);
			return Math.max(temp1, temp2);
		}
	}
	
	/*
	 * n\w	0 	1	2	3	4	5	6	7	8	9	10
	 * 0	0	0	0	0	0	0	0	0	0	0	0
	 * 1(5)	0	5	5	5	5	5	5	5	5	5	5
	 * 2(3)	0	5	5	8	8	8	8	8	8	8	8	
	 * 3(5)	0	5	5	8	8	8	13	13	13	13	13
	 * 4(3)	0	5	5	8	8	8	13	13	13	13	16
	 * 5(2)	0	5	5	5	8	8	13	13	13	13	16
	 * */
	private static int KnapsackBottomUp(int n, int wt) {
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

	private static int KnapsackRec(int n, int wt) {

		if (n < 0 || wt < 0)
			return 0;
		else if (w[n] > wt) {
			return KnapsackRec(n - 1, wt);
		} else {
			int temp1 = KnapsackRec(n - 1, wt);
			int temp2 = v[n] + KnapsackRec(n - 1, wt - w[n]);
			return Math.max(temp1, temp2);
		}
	}
}
