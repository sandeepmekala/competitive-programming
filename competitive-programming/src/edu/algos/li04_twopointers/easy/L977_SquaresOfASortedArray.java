package edu.algos.li04_twopointers.easy;

import java.util.Arrays;

public class L977_SquaresOfASortedArray {

	public static void main(String[] args) {
		L977_SquaresOfASortedArray obj = new L977_SquaresOfASortedArray();
		
		int[] nums = new int[] {-4,-1,0,3,10};
		int[] result = obj.sortedSquares(nums);
		System.out.println(Arrays.toString(result));
	}

	/*
	 * Problem: https://leetcode.com/problems/squares-of-a-sorted-array/
     * Idea: 
	 * */
	public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        
        int i=0, j=nums.length-1, ind = nums.length-1;
        while(i <= j) {
            int num;
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                num = Math.abs(nums[i]);
                i++;
            }else{
                num = Math.abs(nums[j]);
                j--;
            }
            result[ind--] = num*num;
        }
        
        return result;
    }
}
