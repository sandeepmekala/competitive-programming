package edu.algos.li20_dp1.medium;

public class Fib_L198_HouseRobber {

	public static void main(String[] args) {
		Fib_L198_HouseRobber obj = new Fib_L198_HouseRobber();
		
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
        if(n == 1){
            return profit[0];
        }
        
        int[] table = new int[n];
        table[0] = profit[0];
        table[1] = Math.max(profit[0], profit[1]);
        for(int i=2; i<n; i++){
            table[i] = Math.max(profit[i]+table[i-2], table[i-1]);
        }
        
        return table[n-1];
    }

}
