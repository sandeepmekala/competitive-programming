package edu.algos.li21_dp.medium;

public class Subsequence_L39_CombinationSum {

	public static void main(String[] args) {
		Subsequence_L39_CombinationSum obj = new Subsequence_L39_CombinationSum();
		
		int[] nums = new int[] {1,5,11,9};
		int sum = 13;
		System.out.println(obj.combinationSum(nums, sum));
	}

	// Problem: https://leetcode.com/problems/combination-sum/
	// 
	public boolean combinationSum(int[] nums, int sum) {
		int n = nums.length;
		boolean[] mem = new boolean[sum+1];
		mem[0] = true;
		for(int i=0; i<=sum; i++) {
			for(int j=0; j<n; j++) {
				if(i-nums[j] >= 0 && mem[i-nums[j]]) {
					mem[i] = true;
				}
			}
		}
		return mem[sum];
	}

}
