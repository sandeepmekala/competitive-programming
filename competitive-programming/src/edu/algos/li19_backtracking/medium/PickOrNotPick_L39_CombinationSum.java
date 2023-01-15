package edu.algos.li19_backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class PickOrNotPick_L39_CombinationSum {

	public static void main(String[] args) {
		PickOrNotPick_L39_CombinationSum obj = new PickOrNotPick_L39_CombinationSum();
		int[] nums = new int[] { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(obj.combinationSum(nums, target));
	}

	// Problem: https://leetcode.com/problems/combination-sum/
	// Idea: Similar like subset problem. But we have to track sum with subsets to compare with target.
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSum(candidates, target, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void combinationSum(int[] candidates, int target, int index, List<Integer> list,
			List<List<Integer>> result) {
		if (index == candidates.length){
			if (target == 0) {
				result.add(new ArrayList<Integer>(list));
				return;
			}	
			return;	
		} 

		if(candidates[index] <= target){
			list.add(candidates[index]);
			combinationSum(candidates, target-candidates[index], index, list, result);
			list.remove(list.size() - 1);
		}
		combinationSum(candidates, target, index + 1, list, result);
	}
}
