package algos.dp;

public class CoinsChangeTotalWays {

	public static void main(String[] args) {
		int[] coins = new int[] {1,2,3};
		int total = 4;
		System.out.println(totalWaysForCoinsChangeTopDown(coins, 2, total));
		
		System.out.println(totalWaysForCoinsChangeBottomUp(coins, total));
	}
	
	/*
	 * 	c/t	0	1	2	3	4
	 *	1	1	1	1	1	1
	 * 	2	1	1	2	2	3
	 * 	3	1	1	2	3	4
	 * */
	private static int totalWaysForCoinsChangeBottomUp(int[] coins, int total) {
		int[][] mem = new int[coins.length][total+1];
		for(int i=0; i<coins.length; i++) {
			for(int j=0; j<=total; j++) {
				if(j == 0) {
					mem[i][j] = 1;
				}else if(i == 0 &&j%coins[i] == 0) {
					mem[i][j] = 1;
				}else if(coins[i] > j) {
					mem[i][j] = mem[i-1][j];
				}else {
					mem[i][j] = mem[i-1][j]+mem[i][valid(j-coins[i])];
				}
				
			}
		}
		
		return mem[coins.length-1][total];
	}
	
	private static int totalWaysForCoinsChangeTopDown(int[] coins, int index, int total) {
		
		if(total == 0) {
			return 1;
		}
		if(index < 0 || total < 0) {
			return 0;
		}
		if(total < coins[index]) {
			return totalWaysForCoinsChangeTopDown(coins, index-1, total);
		}else {							
			return totalWaysForCoinsChangeTopDown(coins, index-1, total)+totalWaysForCoinsChangeTopDown(coins, index, total-coins[index]);
		}
	}
	private static int valid(int index) {
		if(index < 0 ) {
			return 0;
		}
		return index;
	}

}
