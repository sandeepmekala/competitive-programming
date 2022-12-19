package edu.algos.li21_dp2;

import java.util.HashMap;

public class TargetSum {

	public static void main(String[] args) {
		TargetSum obj = new TargetSum();

		int[] nums = new int[] { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(obj.findTargetSumWays(nums, target));
	}

	/*
	 * Problem: https://leetcode.com/problems/target-sum/submissions/
	 * Idea: build a decision tree. start with index 0. For each element we have 2 choices + or -1 that number.
	 * Update the sum and call two recursive functions
	 * 
	 * 
	 * */
	public int findTargetSumWays(int[] nums, int target) {

		HashMap<String, Integer> mem = new HashMap<>();
		return rec(nums, target, 0, 0, mem);
	}

	private int rec(int[] nums, int target, int i, int sum, HashMap<String, Integer> mem) {
		int n = nums.length;
		if (i == n) {
			if (sum == target) {
				return 1;
			} else {
				return 0;
			}
		}

		String key = (i + ":" + sum);
		if (mem.containsKey(key)) {
			return mem.get(key);
		}

		int localSum = 0;
		localSum += rec(nums, target, i + 1, sum - nums[i], mem);
		localSum += rec(nums, target, i + 1, sum + nums[i], mem);
		mem.put(key, localSum);

		return mem.get(key);
	}

}
