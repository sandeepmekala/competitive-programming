package  com.algos.li19_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class L46_Permutations {

	public static void main(String[] args) {
		L46_Permutations obj = new L46_Permutations();
		System.out.println(obj.permute(new int[]{1,2,3}));
	}

	// Problem: https://leetcode.com/problems/permutations/
	// Idea: Fix each position once swap each element to that position to generat permutations starting with that element.
	// Time: O(n!)
	// Space: O(1)
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }
    
    public void permute(int[] nums, int ind, List<List<Integer>> result) {
        if(ind == nums.length-1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return; 
        }
        for(int i=ind; i<=nums.length-1; i++){
            swap(nums, ind, i);
            permute(nums, ind+1, result);
            swap(nums, ind, i);
        }
    }
    
    private void swap(int[] nums, int l, int i){
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }

}