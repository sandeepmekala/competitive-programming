package edu.algos.li01.array;

import java.util.Arrays;

public class SetMismatch {

	public static void main(String[] args) {
		SetMismatch obj = new SetMismatch();

		int[] nums = new int[] {4,2,1,2};
		System.out.println(Arrays.toString(obj.findErrorNums(nums)));
	}

	/*
	 * Problem: https://leetcode.com/problems/set-mismatch/
	 * 
	 * */
	public int[] findErrorNums(int[] nums) {
        int i=0;                                //0
        while(i<nums.length){
            int numIndex = nums[i]-1;           //1
            if(nums[i]-1 == i || nums[i] == nums[numIndex]){
                i++;
                continue;
            }
            
            int temp = nums[numIndex];
            nums[numIndex] = nums[i];
            nums[i] = temp;
        }
        
        for(i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                return new int[]{nums[i], i+1};
            }
        }
        
        return new int[]{-1, -1};
        
    }
}
