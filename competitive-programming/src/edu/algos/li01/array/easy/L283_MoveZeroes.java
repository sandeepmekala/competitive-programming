package edu.algos.li01.array.easy;

import java.util.Arrays;

public class L283_MoveZeroes {

	public static void main(String[] args) {
		L283_MoveZeroes obj = new L283_MoveZeroes();
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		obj.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

	// Problem: https://leetcode.com/problems/move-zeroes/
	// Idea: 1st pointer waits at non 0 place, 2nd pointer waits at 0 place, then swap.
	public void moveZeroes(int[] nums) {
		int i = 0, j = 0;
		while (i < nums.length && j < nums.length) {
			while (i < nums.length && nums[i] == 0) {
				i++;
			}
			while (j < nums.length && nums[j] != 0 && j < i) {
				j++;
			}
			if (i < nums.length && j < nums.length) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
				j++;
			}
		}
	}

	// Idea: track num of 0's seen so far and move the current num at i to num[i-#0's].
	public void moveZeroes2(int[] nums) {
        int snowBallSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
    }

}
