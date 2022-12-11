package edu.algos.li20.dp1;

public class L152_MaximumProductOfSubArray {

	public static void main(String[] args) {
		L152_MaximumProductOfSubArray obj = new L152_MaximumProductOfSubArray();
		System.out.println(obj.maxProduct(new int[] {-2,-3,-2,-4}));
	}

	// Problem: https://leetcode.com/problems/maximum-product-subarray/
	// Idea: Use Kadances algo. 
	public int maxProduct(int[] nums) {
		int localMax = nums[0];
		int localMin = nums[0];
        int globalMax = localMax;
		
		for(int i=1; i<nums.length; i++) {
			int prevLocalMax = localMax;
			localMax = Math.max(nums[i], Math.max(localMax*nums[i], localMin*nums[i]));
			localMin = Math.min(nums[i], Math.min(prevLocalMax*nums[i], localMin*nums[i]));
			
			globalMax = Math.max(globalMax, localMax);
		}
        globalMax = Math.max(globalMax, localMax);
		return globalMax;
    }

}
