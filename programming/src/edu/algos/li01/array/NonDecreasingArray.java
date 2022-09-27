package edu.algos.li01.array;

public class NonDecreasingArray {

	public static void main(String[] args) {
		NonDecreasingArray obj = new NonDecreasingArray();
		
		int[] nums = new int[] {4,2,3,5};
		System.out.println(obj.checkPossibility(nums));
	}

	/*
	 * Problem: https://leetcode.com/problems/non-decreasing-array/
	 * Companies: Amazon
	 * */
	public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n < 3) return true;
        
        boolean nonDecreasing = false;
        for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                if(nonDecreasing) return false;
                nonDecreasing = true;
                if(i > 0){
                    if(nums[i-1] <= nums[i+1]) 
                        nums[i] = nums[i+1];
                    else
                        nums[i+1] = nums[i];
                }else{
                    nums[i] = nums[i+1];
                }
            }
        }
        
        return true;
    }
}
