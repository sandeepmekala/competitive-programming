package  com.algos.core.li01_array.revised;

import java.util.Arrays;

public class L31_NextPermutation {

	public static void main(String[] args) {
		L31_NextPermutation obj = new L31_NextPermutation();
		
		//int[] nums = new int[] {1,2,3};
        int[] nums = new int[] {2,3,1};
		obj.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
	
    // Problem: https://leetcode.com/problems/next-permutation/
    // Idea: Find the num1 which less then the previous. Traverse from right.
    // Find num2 which is greater then num1 from right. Replace num1 and num2.
    // reverse all the str after num1 index
	public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n < 2) return;
        
        int i=n-2;
        while(i>=0 && nums[i] >= nums[i+1])    
            i--;                // finds 2 in 2,3,1
        
        if(i >= 0){
            int j = n-1;
            while(j>=0 && nums[j] <= nums[i]) 
                j--;            // finds 3 in 2,3,1, which is greater then 2.
            
            swap(nums, i, j);   // 2,3,1 -> 3,2,1
        }
        reverse(nums, i+1, n-1);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int l, int r){
        while(l < r) swap(nums, l++, r--);
    }

}
