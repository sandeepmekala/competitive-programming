package  com.algos.core.li01_array.revised;

public class L53_MaximumSubarray {

	public static void main(String[] args) {
		L53_MaximumSubarray obj = new L53_MaximumSubarray();
		
		System.out.println(obj.maxSubArray(new int[] { 1, -3, 2, 1, -1 }));
		// System.out.println(obj.maxSubArray(new int[] { 1 }));
		// System.out.println(obj.maxSubArray(new int[] { }));
	}

	// Problem: https://leetcode.com/problems/maximum-subarray/
	// Idea: Continuously add numbers, if sum goes above global sum, update global sum.
	// If sum goes negative, reset it to 0.
	// Time: O(n)
    // Space: O(1)
	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		int start = 0, end = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > maxSum) {
				maxSum = sum;
				end = i;
			}
			if (sum < 0) {
				sum = 0;
				start = i + 1;
			}
		}
		System.out.println(start + ":" + end);
		return maxSum;
	}
}