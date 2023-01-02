package edu.algos.li19_backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class L78_Subsets {

	public static void main(String[] args) {
		L78_Subsets obj = new L78_Subsets();

		int[] set = new int[] { 1, 2, 3 };
		System.out.println(obj.subsets(set));
	}

	// Problem: https://leetcode.com/problems/subsets/
	// Idea: Pass the solution list. Recursively call the same function with and without each element in solution list.
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		subsets(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	public void subsets(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
		if (index == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}

		list.add(nums[index]);
		subsets(nums, index + 1, list, result);
		list.remove(list.size() - 1);
		subsets(nums, index + 1, list, result);
	}
}