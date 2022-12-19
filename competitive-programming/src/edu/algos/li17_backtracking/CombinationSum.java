package edu.algos.li17_backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum obj = new CombinationSum();
		int[] nums = new int[] { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(obj.combinationSum(nums, target));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(candidates, target, 0, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void dfs(int[] candidates, int target, int total, int index, List<Integer> list,
			List<List<Integer>> result) {
		if (total == target) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		if (index >= candidates.length || total > target) {
			return;
		}

		list.add(candidates[index]);
		dfs(candidates, target, total + candidates[index], index, list, result);
		list.remove(list.size() - 1);
		dfs(candidates, target, total, index + 1, list, result);
	}
}
