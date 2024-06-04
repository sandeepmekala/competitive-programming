package  com.algos.core.li02_hashing.revised;

import java.util.HashSet;
import java.util.Set;

public class L128_LongestConsecutiveSequence {

	public static void main(String[] args) {
		L128_LongestConsecutiveSequence obj = new L128_LongestConsecutiveSequence();
		System.out.println(obj.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}

	// Problem: https://leetcode.com/problems/longest-consecutive-sequence/
	// Idea: Use HashSet to check if num-1 exist in the set.
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) 
			set.add(num);

		int max = 0;
		for (int num : nums) {
			if (set.contains(num - 1))
				continue;

			int count = 0;
			while (set.contains(num)) {
				count++;
				num++;
			}
			max = Math.max(max, count);
		}
		return max;
	}
}
