package edu.algos.li04_slidingwindow.easy;

public class L643_MaximumAverageSubarrayI {

	public static void main(String[] args) {
		L643_MaximumAverageSubarrayI obj = new L643_MaximumAverageSubarrayI();
		
		int[] nums = new int[] {1,12,-5,-6,50,3};
		System.out.println(obj.findMaxAverage(nums, 4));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/maximum-average-subarray-i/
	 * Idea: Track the fixed size sliding window of k. Cal sum from it and avg. Track global min avg.
	 * */
	public double findMaxAverage(int[] nums, int k) {
        double sum = 0, avg = Integer.MIN_VALUE;
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
