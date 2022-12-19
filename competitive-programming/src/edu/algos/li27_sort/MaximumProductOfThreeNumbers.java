package edu.algos.li27_sort;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

	public static void main(String[] args) {
		MaximumProductOfThreeNumbers obj = new MaximumProductOfThreeNumbers();
		
		int[] nums = new int[] {1,2,3,4};
		System.out.println(obj.maximumProduct(nums));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/maximum-product-of-three-numbers/
	 * 
	 * */
	public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-3]*nums[n-2]*nums[n-1]);
    }

}
