package edu.algos.li04_twopointers.twopointers;

import java.util.Arrays;

public class SquaresOfASortedArray {

	public static void main(String[] args) {
		SquaresOfASortedArray obj = new SquaresOfASortedArray();
		
		int[] nums = new int[] {-4,-1,0,3,10};
		int[] result = obj.sortedSquares(nums);
		System.out.println(Arrays.toString(result));
	}

	/*
	 * Problem: https://leetcode.com/problems/squares-of-a-sorted-array/
	 * */
	public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        
        int i=0, j=nums.length-1, k = nums.length-1;
        while(i<=j){
            int num;
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                num = Math.abs(nums[i]);
                i++;
            }else{
                num = Math.abs(nums[j]);
                j--;
            }
            result[k--] = num*num;
        }
        
        return result;
    }
}
