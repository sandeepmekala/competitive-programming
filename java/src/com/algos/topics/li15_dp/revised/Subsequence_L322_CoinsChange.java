
package  com.algos.topics.li15_dp.revised;

public class Subsequence_L322_CoinsChange {

	public static void main(String[] args) {
		Subsequence_L322_CoinsChange obj = new Subsequence_L322_CoinsChange();

		int[] coins = new int[]{5,1,6,8};
		int total = 11, n = coins.length;
		System.out.println(obj.coinChange(coins, n-1, total));
		System.out.println(obj.coinChange(coins, total));
	}

	// Problem: https://leetcode.com/problems/coin-change/
	// Minimum number of coins required to make the total. Unlimited supply of coins.
	// Idea: Same as knapsack problem. Index i and the amount that is remiain will become parameters.
	//
	// T[i][j] = min{
	// 		T[i-1][j],
	// 		1+T[i][j-coins[i]]
	//  }
	//
	//
	// c\t	0	1	2	3	4	5	6	7	8	9	10	11
	// 1	0	1	2	3	4	5	6	7	8	9	10	11
	// 5	0	1	2	3	4	1	2	3	4	5	2	3
	// 6	0	1	2	3	4	1	1	2	3	4	2	3
	// 8	0	1	2	3	4	1	2	2	1	2	2	2
	//
	// Time: O(n*tatal)
    // Space: O(n*tatal)
	public int coinChange(int[] coins, int ind, int total) {
		if(ind == 0) {
			if(total % coins[ind] == 0)
				return total/coins[ind];

			return (int)1e9;
		}
		int notPick = 0 + coinChange(coins, ind-1, total);
		int pick = Integer.MAX_VALUE;
		if(coins[ind] <= total)
			pick = 1 + coinChange(coins, ind, total-coins[ind]);

		return Math.min(notPick, pick);
	}

	public int coinChange(int[] coins, int total) {
		int n = coins.length;
		int[][] dp = new int[n][total+1];
		for(int i=0; i<coins.length; i++) {
			for(int j=1; j<=total; j++) {
				if(i==0) {
				    if(j%coins[i] == 0){			//if only one coin and it can change the total
				        dp[i][j] = j/coins[i];
				    }else {
				    	dp[i][j] = (int) 1e9;
				    }
				} else {
					int notPick = 0 + dp[i-1][j];
					int pick = Integer.MAX_VALUE;
					if(coins[i] <= j)
						pick = 1 + dp[i][j-coins[i]];

					dp[i][j] = Math.min(notPick, pick);
				}
			}
		}

		if(dp[n-1][total] >= (int) 1e9)
            return -1;
		return dp[n-1][total];
	}
}
