package edu.algos.li19_backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90_SubsetsII {

	public static void main(String[] args) {
		L90_SubsetsII obj = new L90_SubsetsII();
		
		int[] nums = new int[] { 1, 2, 2 };
		List<List<Integer>> result = obj.subsetsWithDup(nums);
		System.out.println(result);
	}

	// Problem: https://leetcode.com/problems/subsets-ii/
	// Idea: Similar like subsets. [1,2,2] gets gets generate by the first recursion.
	// But the while loop before second recursion make sure [1,2,2] doesn't get generated again.
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void subsets(int[] nums, int index, List<Integer> list, List<List<Integer>> result)     {
        if (index == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}

		list.add(nums[index]);
		subsets(nums, index + 1, list, result);
		list.remove(list.size()-1);		
        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;				// next num that gets added should not be same as which is remove just now to avoid duplicates.
        }
		subsets(nums, index + 1, list, result);
    }
}