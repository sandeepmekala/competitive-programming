package edu.algos.li05.slidingwindow;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
		
		int[] nums = new int[] {2,3,1,2,4,3};
		System.out.println(obj.minSubArrayLen(7, nums));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/minimum-size-subarray-sum/
	 * Concept: use sliding window as it ask for contiguous sub arrays
	 * */
	public int minSubArrayLen(int target, int[] nums) {
        
        int i=0, j=0, n = nums.length;
        int sum = 0, len = Integer.MAX_VALUE;
        while(j<n){
            sum += nums[j];
            while(sum >= target){
                len = Math.min(len, j-i+1);
                sum -= nums[i++];
            }
            j++;
        }
        
        return len == Integer.MAX_VALUE? 0: len;
    }

}
