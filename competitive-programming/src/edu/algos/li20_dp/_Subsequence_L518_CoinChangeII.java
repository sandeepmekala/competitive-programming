package edu.algos.li20_dp;

public class _Subsequence_L518_CoinChangeII {

	public static void main(String[] args) {
		_Subsequence_L518_CoinChangeII obj = new _Subsequence_L518_CoinChangeII();
		int[] coins = new int[] {2,1,3};
		int total = 4;
		System.out.println(obj.change(coins, 2, total));
		
		System.out.println(obj.change(total, coins));
	}
	
	/* 
	 * Problem: https://leetcode.com/problems/coin-change-ii/
	 * Idea: same knapsack problem.
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
	public int change(int amount, int[] coins) {
		int n = coins.length;
		int[][] comb = new int[n][amount+1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<=amount; j++) {
				if(j == 0) {
					comb[i][j] = 1;
				}else if(i == 0) {
					if(j%coins[i] == 0) {
						comb[i][j] = 1;
					}
				}else {
					int notPick = comb[i-1][j];
					int pick = 0;
					if(coins[i] <= j)
						pick = comb[i][j-coins[i]];
					comb[i][j] = notPick+pick;
				}
			}
		}
		
		return comb[n-1][amount];
	}
	
	public int change(int[] coins, int ind, int total) {
		if(ind == 0) {
			if(total % coins[0] == 0)
				return 1;
			return 0;
		}
		int notPick = change(coins, ind-1, total);
		int pick = 0;
		if(coins[ind] <= total) {
			pick = change(coins, ind, total-coins[ind]);
		}
		return notPick + pick;
	}

}
