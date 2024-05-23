package  com.algos.li15_dp.revised;

import java.util.Arrays;

public class OneD_Subseq_L198_HouseRobber {

	public static void main(String[] args) {
		OneD_Subseq_L198_HouseRobber obj = new OneD_Subseq_L198_HouseRobber();
		
		int[] nums = new int[] {2,7,9,3,1};
		System.out.println(obj.rob(nums));
		System.out.println(obj.rob2(nums));
	}
	
	
	// Problem: https://leetcode.com/problems/house-robber/
	// Idea: Go left to right by caching the results of smaller problems. If you choose to rob the current house, you need rob remaining nums[i-2] houses, 
	//  	if you ignore the current house, you need to rob nums[i-1] houses.
	//   T[i] = Max{
	//   	profit(i)+T[i-2],
	//   	T[i-1]
	//   }
	// Time: O(n)
	// Space: O(n)
	public int rob(int[] profit) {
		int n = profit.length;
        int[] rob=new int[n];
    	Arrays.fill(rob,-1);

		rob[0]= profit[0];
		for(int i=1 ;i<n; i++){
			int nonPick = 0+rob[i-1];
			int pick = profit[i];
			if(i>1)
				pick += rob[i-2];
			
			rob[i]= Math.max(pick, nonPick);
		}
		return rob[n-1];
    }

	public int rob2(int[] profit){
		int n = profit.length;
		int dp[]=new int[n];
		Arrays.fill(dp,-1);
		return rob(n-1, profit, dp);
	}

	private int rob(int ind, int[] profit, int[] dp){
		if(ind==0) return profit[ind];

		if(dp[ind]!=-1) return dp[ind];

		int nonPick = 0 + rob(ind-1, profit, dp);
		int pick= profit[ind];
		if(ind>1)
			pick += rob(ind-2, profit, dp);
		
		return dp[ind]=Math.max(pick, nonPick);
	}
}
