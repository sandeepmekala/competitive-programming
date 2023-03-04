package edu.algos.li02_array.easy;

import java.util.Arrays;

public class L724_FindPivotIndex {

	public static void main(String[] args) {
		L724_FindPivotIndex obj  = new L724_FindPivotIndex();
		
		int[] nums = new int[] {1,7,3,6,5,6};
		System.out.println(obj.pivotIndex(nums));
		
	}
	
	/*
	 * Problem: https://leetcode.com/problems/find-pivot-index/
	 * Idea: Just use sum and prefix sum
	 * */
	public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        
        int prefixSum = 0;
        for(int i=0; i<nums.length; i++){
            if(prefixSum == sum - nums[i]) return i;
            
            prefixSum += nums[i];
            sum -= nums[i];
        }
        
        return -1;
    }

}
