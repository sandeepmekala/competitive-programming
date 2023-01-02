package edu.algos.li20_dp1.medium;

public class Kadanes_L53_MaximumSubarray {

	public static void main(String[] args) {
		Kadanes_L53_MaximumSubarray obj = new Kadanes_L53_MaximumSubarray();
		
		System.out.println(obj.maxSubArray(new int[] { 1, -3, 2, 1, -1 }));
		System.out.println(obj.maxSubArray(new int[] { 1 }));
		System.out.println(obj.maxSubArray(new int[] { }));
	}

	// Problem: https://leetcode.com/problems/maximum-subarray/
	// Idea: It is DP algo because at each element we have 2 choices. Whether to take that element or continue with previous sum OR start a new range.
	// Continuously add numbers, if sum goes above global sum, update global sum.
	// If sum goes negative, reset it to 0.
	public int maxSubArray(int nums[]) {
		int start = 0, end = 0;
		int global_sum = Integer.MIN_VALUE;
		int local_sum = 0;
		for (int i = 0; i < nums.length; i++) {
			local_sum += nums[i];
			if (local_sum > global_sum) {
				global_sum = local_sum;
				end = i;
			}
			if (local_sum < 0) {
				local_sum = 0;
				start = i + 1;
			}
		}
		System.out.println(start + ":" + end);
		return global_sum;
	}
}