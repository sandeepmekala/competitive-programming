package  com.algos.li20_dp;

import java.util.Arrays;

public class OneD_Fib_L213_HouseRobberII {

	public static void main(String[] args) {
		OneD_Fib_L213_HouseRobberII obj = new OneD_Fib_L213_HouseRobberII();
		
		int[] nums = new int[] {2,3,2};
		//int[] nums = new int[] {0,0};
		System.out.println(obj.rob(nums));
	}
	
	/*
	 *	Problem: https://leetcode.com/problems/house-robber-ii/
	 *  Idea: We can't rob both first and last houses. Hence we slip array in to 2 parts. 
	 *  One including the first element and another one including last element. 
	 *  Run normal House Robber algo on both arrays and take max.
	 * */
	// Time: O(n)
	// Space: O(n)
	public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        
        int[] part1 = Arrays.copyOfRange(nums, 0, n-1);
        int[] part2 = Arrays.copyOfRange(nums, 1, n);
        return Math.max(robHelper(part1), robHelper(part2));
    }

	private int robHelper(int[] profit) {
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

}
