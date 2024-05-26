package  com.algos.core.li14_backtracking.revised;

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
	// Time: O(2^n)
    // space: O(n)
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum2(nums, 0, target, new ArrayList<>(), result);
        return result;
    }
    
    private void combinationSum2(int[] nums, int ind, int target, List<Integer> list, List<List<Integer>> result){
        if(ind == nums.length){
            if(target == 0)
                result.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[ind]);
        combinationSum2(nums, ind+1, target-nums[ind], list, result);
        list.remove(list.size()-1);
        while(ind+1 < nums.length && nums[ind] == nums[ind+1]){
            ind++;
        }
        combinationSum2(nums, ind+1, target, list, result);
    }
}
