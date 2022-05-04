package edu.practice.leatcode;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		MoveZeroes obj = new MoveZeroes();
		int[] nums = new int[] {0,1,0,3,12};
		obj.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	 public void moveZeroes(int[] nums) {
	        int i=0, j=0;
	        while(i<nums.length && j<nums.length){
	            while(i<nums.length && nums[i] == 0){
	                i++;
	            }
	            while(j<nums.length && nums[j] != 0 && j<i){
	                j++;
	            }
	            if(i<nums.length && j<nums.length){
	                int temp = nums[j];
	                nums[j] = nums[i];
	                nums[i] = temp;
	                i++;
	                j++;
	            }
	        }
	    }

}
