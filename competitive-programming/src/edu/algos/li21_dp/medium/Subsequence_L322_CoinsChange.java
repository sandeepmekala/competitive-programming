
package edu.algos.li21_dp.medium;

public class Subsequence_L322_CoinsChange {

	public static void main(String[] args) {
		Subsequence_L322_CoinsChange obj = new Subsequence_L322_CoinsChange();
		
		int[] coins = new int[]{5,1,6,8};
		int total = 11;
		System.out.println(obj.coinChange(coins, total));
		
		System.out.println(obj.coinChange(coins, 3, total));
	}

	/*
	 * Problem: https://leetcode.com/problems/coin-change/
	 * Idea: Same as knapsack problem. Index i and the amount that is remiain will become parameters.
	 * If total becomes 0, then return 0 so that the min can be calculation. Count of actual number already happened with +1.
	 * If total < 0 or index < 0, then return MAX so that it will be excluded at min calculation.
	 * 
	 * T[i][j] = min{	
	 * 		T[i-1][j],
	 * 		1+T[i][j-coins[i]]
	 *  }
	 * 
	 * 
	 * c\t	0	1	2	3	4	5	6	7	8	9	10	11
	 * 1	0	1	2	3	4	5	6	7	8	9	10	11
	 * 5	0	1	2	3	4	1	2	3	4	5	2	3
	 * 6	0	1	2	3	4	1	1	2	3	4	2	3	
	 * 8	0	1	2	3	4	1	2	2	1	2	2	2  
	 * 
	 */
	public int coinChange(int[] coins, int total) {
		int n = coins.length;
		int[][] sum = new int[n][total+1];
		for(int i=0; i<coins.length; i++) {
			for(int j=1; j<=total; j++) {
				if(i==0) {  
				    if(j%coins[i] == 0){			//if only one coin and it can change the total	
				        sum[i][j] = j/coins[i];    
				    }else {
				    	sum[i][j] = (int) 1e9;
				    }
				} else {
					int notPick = 0 + sum[i-1][j];
					int pick = Integer.MAX_VALUE;		//mem[i]...  means we can select same coin again
					if(coins[i] <= j) {
						pick = 1 + sum[i][j-coins[i]];
					}
					sum[i][j] = Math.min(notPick, pick);		
				}	
			}
		}
		
		if(sum[n-1][total] >= (int) 1e9){
            return -1;
        }
		return sum[n-1][total];
	}
	
	private int coinChange(int[] coins, int i, int total) {
		if(i == 0) {
			if(total%coins[i] == 0) 
				return total/coins[i];
			else 
				return (int)1e9;
		}
		int notPick = 0 + coinChange(coins, i-1, total);
		int pick = Integer.MAX_VALUE;
		if(coins[i] <= total) {
			pick = 1 + coinChange(coins, i, total-coins[i]);;
		}
		return Math.min(notPick, pick);
	}
}
