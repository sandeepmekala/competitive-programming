package edu.algos.li04_slidingwindow;

public class L209_MinimumSizeSubarraySum {

	public static void main(String[] args) {
		L209_MinimumSizeSubarraySum obj = new L209_MinimumSizeSubarraySum();
		
		int[] nums = new int[] {2,3,1,2,4,3};
		System.out.println(obj.minSubArrayLen(7, nums));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/minimum-size-subarray-sum/
	 * Idea: Use sliding window as it ask for contiguous sub array.
     * Continuely find sum of nums, if some goes more then target, find the min length of all posibilities.
     * Use two pointers tp track sub array.
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
