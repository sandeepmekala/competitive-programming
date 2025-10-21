package  com.algos.topics.li14_backtracking.revised;

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
	// Time: O(2^n)
    // space: O(n)
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSum(nums, 0, target, new ArrayList<>(), result);
		return result;
	}

	private void combinationSum(int[] nums, int ind, int target, List<Integer> list,
			List<List<Integer>> result) {
		if (ind == nums.length){
			if (target == 0)
				result.add(new ArrayList<>(list));
			return;
		}

		if(nums[ind] <= target){
			list.add(nums[ind]);
			combinationSum(nums, ind, target-nums[ind], list, result);	// pick
			list.remove(list.size() - 1);
		}
		combinationSum(nums, ind + 1, target, list, result);  // not pick
	}
}
