package edu.algos.li04_hashing.medium;

import java.util.HashSet;

public class L128_LongestConsecutiveSequence {

	public static void main(String[] args) {
		L128_LongestConsecutiveSequence obj = new L128_LongestConsecutiveSequence();
		System.out.println(obj.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}

	// Problem: https://leetcode.com/problems/longest-consecutive-sequence/
	// Idea: Use HashSet to check if num-1 exist in the set.
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			if (set.contains(current - 1))
				continue;

			int count = 0;
			while (set.contains(current)) {
				count++;
				current++;
			}
			if (count > max) {
				max = count;
			}
		}
		return max;
	}
}
