package edu.algos.li04.twopointers;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		NextPermutation obj = new NextPermutation();
		
		int[] nums = new int[] {1,2,3};
		obj.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n < 2) return;
        
        int i=n-2;
        while(i>=0 && nums[i] >= nums[i+1]) i--;
        
        if(i >= 0){
            int j = n-1;
            while(j>=0 && nums[j] <= nums[i]) j--;   
            
            swap(nums, i, j);
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
