package edu.algos.li20_dp;

public class _Kadanes_L152_MaximumProductOfSubArray {

	public static void main(String[] args) {
		_Kadanes_L152_MaximumProductOfSubArray obj = new _Kadanes_L152_MaximumProductOfSubArray();
		System.out.println(obj.maxProduct(new int[] {-2,-3,-2,-4}));
	}

	// Problem: https://leetcode.com/problems/maximum-product-subarray/
	// Idea: Use Kadances algo. 
	// Product of two negative nums can become max. Hence, we need track negative max also as it might get multiplied by a negative num.
	// We might form big negative number by multiplying the current max prod with a negative number.
	public int maxProduct(int[] nums) {
		int globalMaxProd = nums[0];
		int locMaxProd = nums[0];
		int locMinProd = nums[0];
		for(int i=1; i<nums.length; i++) {
			int oldMax = locMaxProd;
			locMaxProd = Math.max(nums[i], Math.max(locMaxProd*nums[i], locMinProd*nums[i]));
			locMinProd = Math.min(nums[i], Math.min(oldMax*nums[i], locMinProd*nums[i]));
			
			if(locMaxProd > globalMaxProd)
				globalMaxProd = locMaxProd;
		}

		return globalMaxProd;
    }

}
