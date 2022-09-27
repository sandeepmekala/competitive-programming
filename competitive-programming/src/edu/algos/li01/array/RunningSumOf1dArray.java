package edu.algos.li01.array;

import java.util.Arrays;

public class RunningSumOf1dArray {

	public static void main(String[] args) {
		RunningSumOf1dArray obj = new RunningSumOf1dArray();
		
		int[] nums = new int[] {1,2,3,4,5};
		System.out.println(Arrays.toString(obj.runningSum(nums)));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/running-sum-of-1d-array/
	 * */
	public int[] runningSum(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            nums[i] = sum;
        }
        
        return nums;
    }

}
