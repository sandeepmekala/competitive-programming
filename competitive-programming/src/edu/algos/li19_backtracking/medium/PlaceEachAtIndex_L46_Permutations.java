package edu.algos.li19_backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlaceEachAtIndex_L46_Permutations {

	public static void main(String[] args) {
		PlaceEachAtIndex_L46_Permutations obj = new PlaceEachAtIndex_L46_Permutations();
		System.out.println(obj.permute(new int[]{1,2,3}));
	}

	// Problem: https://leetcode.com/problems/permutations/
	// Idea: Fix each position once swap each element to that position to generat permutations.
	// Time complexity: O(n^n)
	// Space complexity: O(1)
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }
    
    public void permute(int[] nums, int index, List<List<Integer>> result) {
        if(index == nums.length-1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i=index; i<=nums.length-1; i++){
            swap(nums, index, i);
            permute(nums, index+1, result);
            swap(nums, index, i);
        }
    }
    
    private void swap(int[] nums, int l, int i){
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }

}