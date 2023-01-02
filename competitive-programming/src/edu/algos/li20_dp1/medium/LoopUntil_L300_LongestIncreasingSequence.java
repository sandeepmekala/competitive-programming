package edu.algos.li20_dp1.medium;

import java.util.Arrays;

public class LoopUntil_L300_LongestIncreasingSequence {

	public static void main(String[] args) {
		LoopUntil_L300_LongestIncreasingSequence obj = new LoopUntil_L300_LongestIncreasingSequence();
		System.out.println(obj.lengthOfLIS(new int[] { 2, -1, 4, 3, 5, -1, 3, 2 }));
	}

	// Problem: https://leetcode.com/problems/longest-increasing-subsequence/
	// Idea: Find lis of all the previous elements starting from left to right,	then find lis of current element
	// current element lis is the max of all the previous elements lis plus 1
	// O(n^2) as it takes another loop to find the max for current element
	public int lengthOfLIS(int[] nums) {
        int max = 0, n = nums.length;
        if(n == 1)
            return 1;
		
		int[] lis = new int[n];
		Arrays.fill(lis, 1);	//lis for each element is itself
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i]) {
					lis[i] = Math.max(lis[i], lis[j]+1);
				}
			}
			
			if(lis[i] > max) {	//just track max to return
				max = lis[i];
			}
		}
		return max;
    }
	
}
