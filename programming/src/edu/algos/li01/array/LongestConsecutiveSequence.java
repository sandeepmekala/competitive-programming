package edu.algos.li01.array;

import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		System.out.println(obj.longestConsecutive(new int[] {100,4,200,1,3,2}));
	}

	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		int globalMax = 0;
		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			if (set.contains(current - 1)) {
				continue;
			}
			int localMax = 0;
			while (set.contains(current)) {
				current++;
				localMax++;
			}
			if (localMax > globalMax) {
				globalMax = localMax;
			}
		}
		return globalMax;
	}
}
