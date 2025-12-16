package li01_array.java;

import java.util.Arrays;

public class L645_SetMismatch {

	public static void main(String[] args) {
		L645_SetMismatch obj = new L645_SetMismatch();

		int[] nums = new int[] {4,2,1,2};
		System.out.println(Arrays.toString(obj.findErrorNums(nums)));
	}

	/*
	 * Problem: https://leetcode.com/problems/set-mismatch/
	 * Idea: Place the nums at its index position
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
