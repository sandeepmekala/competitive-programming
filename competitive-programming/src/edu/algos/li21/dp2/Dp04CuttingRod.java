package edu.algos.li21.dp2;

public class Dp04CuttingRod {

	public static void main(String[] args) {
		Dp04CuttingRod obj = new Dp04CuttingRod();
		int[] lens = new int[]{1,2,3,4};
		int[] profits = new int[] {2,5,7,8};
		int length = 5;
		System.out.println(obj.cuttingRodTopDown(lens, profits, 3, length));
		System.out.println(obj.cuttingRodBottomUp(lens, profits, 3, length));
	}

	/* Problem: Maximize the profit by cutting rods to specific length rods.
	 * Concept: same as knapsack.
	 *
	 * 	T[i][j] = max{	
	 * 		T[i-1][j]
	 * 		profit(i)+T[i][j-len[i]]
	 *  }
	 * 	
	 * 
	 * 		i\j	0	1	2	3	4	5
	 * 		0	0	0	0	0	0	0
	 * 	2	1	0	2	4	6	8	10	
	 * 	5	2	0	2	5	7	10	12
	 * 	7	3	0	2	5	7	10	12	
	 *	8	4 	0	2	3	4	10	12
	 * 
	 * */
	private int cuttingRodBottomUp(int[] lens, int[] profits, int n, int length) {
		int[][] mem = new int[n+1][length+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=length; j++) {
				if(i == 0 || j == 0) {
					mem[i][j] = 0;
				}else if(lens[i] > j){
					mem[i][j] = mem[i-1][j];
				}else{
					mem[i][j] = Math.max(mem[i-1][j], profits[i]+mem[i][j-lens[i]]);
				}
			}
		}
		return mem[n][length];
	}

	private int cuttingRodTopDown(int[] lens, int[] profits, int i, int length) {
		if(i<0 || length < 0) {
			return 0;
		}else if(lens[i] > length) {
			return cuttingRodTopDown(lens, profits, i-1, length);
		}else {
			return Math.max(cuttingRodTopDown(lens, profits, i-1, length), profits[i]+cuttingRodTopDown(lens, profits, i, length-lens[i]));
		}
	}
}
