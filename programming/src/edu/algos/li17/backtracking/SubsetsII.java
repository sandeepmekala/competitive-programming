package edu.algos.li17.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		SubsetsII obj = new SubsetsII();
		int[] nums = new int[] { 1, 2, 2 };
		List<List<Integer>> result = obj.subsetsWithDup(nums);
		System.out.println(result);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void subsets(int[] nums, int index, List<Integer> list, List<List<Integer>> result)     {
        if (index >= nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}

		list.add(nums[index]);
		subsets(nums, index + 1, list, result);
		list.remove(list.size()-1);
        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }
		subsets(nums, index + 1, list, result);
    }
}