package edu.algos.li05.slidingwindow;

public class MaximumAverageSubarrayI {

	public static void main(String[] args) {
		MaximumAverageSubarrayI obj = new MaximumAverageSubarrayI();
		
		int[] nums = new int[] {1,12,-5,-6,50,3};
		System.out.println(obj.findMaxAverage(nums, 4));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/maximum-average-subarray-i/
	 * 
	 * */
	public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double avg = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(i<k){
                sum += nums[i];
                continue;
            }
            
            avg = Math.max(avg, sum/k);
            sum = sum - nums[i-k]+nums[i];
        }
        avg = Math.max(avg, sum/k);
        
        return avg;
    }

}
