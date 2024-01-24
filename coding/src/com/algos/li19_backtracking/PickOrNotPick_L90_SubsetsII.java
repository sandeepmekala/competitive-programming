package  com.algos.li19_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickOrNotPick_L90_SubsetsII {

	public static void main(String[] args) {
		PickOrNotPick_L90_SubsetsII obj = new PickOrNotPick_L90_SubsetsII();
		
		int[] nums = new int[] { 1, 2, 2 };
		List<List<Integer>> result = obj.subsetsWithDup(nums);
		System.out.println(result);
	}

	// Problem: https://leetcode.com/problems/subsets-ii/
	// Idea: Similar like subsets. [1,2,2] gets gets generate by the first recursion.
	// But the while loop before second recursion make sure [1,2,2] doesn't get generated again.
	// time: O(2^n)
    // space: O(n)
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void subsets(int[] nums, int ind, List<Integer> list, List<List<Integer>> result)     {
        if (ind == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		} 

		list.add(nums[ind]);
		subsets(nums, ind + 1, list, result);
		list.remove(list.size()-1);		
        while(ind+1 < nums.length && nums[ind] == nums[ind+1]){
            ind++;				// next num that gets added should not be same as which is remove just now to avoid duplicates.
        }
		subsets(nums, ind + 1, list, result);
    }
}