package edu.algos.li19_backtracking;

import java.util.ArrayList;
import java.util.List;

public class PickOrNotPick_L78_Subsets {

	public static void main(String[] args) {
		PickOrNotPick_L78_Subsets obj = new PickOrNotPick_L78_Subsets();

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

	public void subsets(int[] nums, int ind, List<Integer> list, List<List<Integer>> result) {
		if (ind == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}

		list.add(nums[ind]);	// pick
		subsets(nums, ind + 1, list, result);
		
		list.remove(list.size() - 1);	// not pick
		subsets(nums, ind + 1, list, result);
	}
}