package edu.algos.li19_backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickOrNotPick_L40_CombinationSumII {

	public static void main(String[] args) {
		PickOrNotPick_L40_CombinationSumII obj = new PickOrNotPick_L40_CombinationSumII();
		int[] nums = new int[] { 10,1,2,7,6,1,5 };
		int target = 8;
		System.out.println(obj.combinationSum2(nums, target));
	}

    // Problem: https://leetcode.com/problems/combination-sum-ii/
    // Idea: Similar like unique subsets problem.
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void combinationSum2(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> result){
        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        list.add(candidates[index]);
        combinationSum2(candidates, target-candidates[index], index+1, list, result);
        list.remove(list.size()-1);
        while(index+1 < candidates.length && candidates[index] == candidates[index+1]){
            index++;
        }
        combinationSum2(candidates, target, index+1, list, result);
    }
}
