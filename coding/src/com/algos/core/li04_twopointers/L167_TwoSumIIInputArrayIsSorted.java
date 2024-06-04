package com.algos.core.li04_twopointers;

import java.util.Arrays;

public class L167_TwoSumIIInputArrayIsSorted {
	public static void main(String args[]) {
		L167_TwoSumIIInputArrayIsSorted obj = new L167_TwoSumIIInputArrayIsSorted();
		System.out.println(Arrays.toString(obj.twoSum(new int[] { 2, 7, 11, 15 }, 9)));
	}

	// Problem: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
	// Idea: One ptr comes from front and another comes from back.
	public int[] twoSum(int[] nums, int target) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			if (nums[i] + nums[j] == target) {
				return new int[]{i+1, j+1};
			} else if (nums[i] + nums[j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return new int[]{};
	}
}
