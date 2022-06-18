package edu.algos.dp2;

public class Dp03CoinsChange2 {

	public static void main(String[] args) {
		Dp03CoinsChange2 obj = new Dp03CoinsChange2();
		int[] coins = new int[] {2,1,3};
		int total = 4;
		System.out.println(obj.totalWaysForCoinsChangeTopDown(coins, 2, total));
		
		System.out.println(obj.totalWaysForCoinsChangeBottomUp(coins, total));
	}
	
	/* concept: same knapsack problem.
	 * if total becomes 0, return 1 so that the combination is counted in total
	 * if total<0 or index<0, then return 0 so that this combination is not counted
	 * 
	 * T[i][j] = T[i-1][j] + T[i][j-coins[i]]
	 *
	 * 
	 * 	c/t	0	1	2	3	4
	 *	1	1	1	1	1	1
	 * 	2	1	1	2	2	3
	 * 	3	1	1	2	3	4
	 * */
	private int totalWaysForCoinsChangeBottomUp(int[] coins, int total) {
		int n = coins.length;
		int[][] mem = new int[n][total+1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<=total; j++) {
				if(j == 0) {
					mem[i][j] = 1;
				}else if(i == 0) {
					if(j%coins[i] == 0) {
						mem[i][j] = 1;
					}
				}else if(coins[i] > j) {
					mem[i][j] = mem[i-1][j];
				}else {
					mem[i][j] = mem[i-1][j]+mem[i][j-coins[i]];
				}
			}
		}
		
		return mem[n-1][total];
	}
	
	private int totalWaysForCoinsChangeTopDown(int[] coins, int index, int total) {
		
		if(total == 0) {
			return 1;
		}
		if(index < 0 || total < 0) {
			return 0;
		}
		if(coins[index] > total) {
			return totalWaysForCoinsChangeTopDown(coins, index-1, total);
		}else {							
			return totalWaysForCoinsChangeTopDown(coins, index-1, total)+totalWaysForCoinsChangeTopDown(coins, index, total-coins[index]);
		}
	}

}
