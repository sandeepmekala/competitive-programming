package  com.algos.core.li15_dp.revised;

public class Subsequence_L518_CoinChangeII {

	public static void main(String[] args) {
		Subsequence_L518_CoinChangeII obj = new Subsequence_L518_CoinChangeII();
		int[] coins = new int[] {2,1,3};
		int total = 4;
		System.out.println(obj.change(total, coins));
		System.out.println(obj.change(coins, 2, total));
	}
	
	//  Problem: https://leetcode.com/problems/coin-change-ii/
	//  Idea: Same knapsack problem.
	//  if total becomes 0, return 1 so that the combination is counted in total
	//  if total<0 or index<0, then return 0 so that this combination is not counted
	//  
	//  T[i][j] = T[i-1][j] + T[i][j-coins[i]]
	// 
	//  
	//  	c/t	0	1	2	3	4
	// 	1	1	1	1	1	1
	//  	2	1	1	2	2	3
	//  	3	1	1	2	3	4
	//
	// Time: O(n*tatal)
    // Space: O(n*tatal)
	public int change(int total, int[] coins) {
		int n = coins.length;
		int[][] comb = new int[n][total+1];
		for(int ind=0; ind<n; ind++) {
			for(int tot=0; tot<=total; tot++) {
				if(tot == 0) {
					comb[ind][tot] = 1;
				}else if(ind == 0) {
					if(tot%coins[ind] == 0) 
						comb[ind][tot] = 1;
				}else {
					int notPick = comb[ind-1][tot];
					int pick = 0;
					if(coins[ind] <= tot)
						pick = comb[ind][tot-coins[ind]];
					comb[ind][tot] = notPick+pick;
				}
			}
		}
		
		return comb[n-1][total];
	}
	
	public int change(int[] coins, int ind, int tot) {
		if(ind == 0) {
			if(tot % coins[0] == 0)
				return 1;
			return 0;
		}
		int notPick = change(coins, ind-1, tot);
		int pick = 0;
		if(coins[ind] <= tot) 
			pick = change(coins, ind, tot-coins[ind]);
		
		return notPick + pick;
	}

}
