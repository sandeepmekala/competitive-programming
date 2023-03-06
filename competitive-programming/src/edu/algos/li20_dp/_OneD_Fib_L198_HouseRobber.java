package edu.algos.li20_dp;

import java.util.Arrays;

public class _OneD_Fib_L198_HouseRobber {

	public static void main(String[] args) {
		_OneD_Fib_L198_HouseRobber obj = new _OneD_Fib_L198_HouseRobber();
		
		int[] nums = new int[] {2,7,9,3,1};
		System.out.println(obj.rob(nums));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/house-robber/
	 * Idea: Go left to right by caching the results of smaller problems. If you choose to rob the current house, you need rob remaining nums[i-2] houses, 
	 * if you ignore the current house, you need to rob nums[i-1] houses.
	 *	T[i] = Max{
	 *		profit(i)+T[i-2],
	 *		T[i-1]
	 *	}
	 * 
	 * */
	public int rob(int[] profit) {
		int n = profit.length;
        int dp[]=new int[n];
    	Arrays.fill(dp,-1);

		dp[0]= profit[0];
		for(int i=1 ;i<n; i++){
			int pick = Integer.MIN_VALUE;
			if(i>1)
				pick = profit[i] + dp[i-2];
			int nonPick = 0+dp[i-1];
			
			dp[i]= Math.max(pick, nonPick);
		}
		return dp[n-1];
    }

	public int rob(int n,int[] profit){
		int dp[]=new int[n];
		Arrays.fill(dp,-1);
		return rob(n-1, profit, dp);
	}

	private int rob(int ind, int[] profit, int[] dp){
		if(ind<0)  return 0;
		if(ind==0) return profit[ind];

		if(dp[ind]!=-1) return dp[ind];

		int pick= profit[ind]+ rob(ind-2, profit, dp);
		int nonPick = 0 + rob(ind-1, profit, dp);
		
		return dp[ind]=Math.max(pick, nonPick);
	}
}
