package edu.practice.leatcode;

public class MaximumProductOfSubArray {

	public static void main(String[] args) {
		MaximumProductOfSubArray obj = new MaximumProductOfSubArray();
		System.out.println(obj.getSum(new int[] {-2,-3,-2,-4}));
	}

	private int getSum(int[] nums) {
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
