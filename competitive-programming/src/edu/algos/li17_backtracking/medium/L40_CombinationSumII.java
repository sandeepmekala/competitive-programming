package edu.algos.li17_backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40_CombinationSumII {

	public static void main(String[] args) {
		L40_CombinationSumII obj = new L40_CombinationSumII();
		int[] nums = new int[] { 10,1,2,7,6,1,5 };
		int target = 8;
		System.out.println(obj.combinationSum2(nums, target));
	}

    // Problem: https://leetcode.com/problems/combination-sum-ii/
    // Idea: Similar like unique subsets problem.
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumRec(candidates, target, 0, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void combinationSumRec(int[] candidates, int target,int total, int index, List<Integer> list, List<List<Integer>> result){
        if(total == target){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        if(index >= candidates.length || total > target){
            return;
        }
        
        list.add(candidates[index]);
        combinationSumRec(candidates, target, total+candidates[index], index+1, list, result);
        list.remove(list.size()-1);
        while(index+1 < candidates.length && candidates[index] == candidates[index+1]){
            index++;
        }
        combinationSumRec(candidates, target, total, index+1, list, result);
    }
}
