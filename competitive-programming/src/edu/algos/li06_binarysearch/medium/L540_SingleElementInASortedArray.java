package edu.algos.li06_binarysearch.medium;

public class L540_SingleElementInASortedArray {

	public static void main(String[] args) {
		L540_SingleElementInASortedArray obj = new L540_SingleElementInASortedArray();
		
		int[] nums = new int[] {1,1,2,3,3,4,4,8,8};
		System.out.println(obj.singleNonDuplicate(nums));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/single-element-in-a-sorted-array/
     * Idea: On left side of target num, 1st and 2nd instances of duplicate numbers are at even and odd positions.
	 * Vice versa on the right of the number.
	 * 
	 * */
	public int singleNonDuplicate(int[] nums) {
        int left=0, right = nums.length-2;
        while(left <= right){
            int mid = (left+right)/2;
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                if(nums[mid] == nums[mid-1]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        
        return nums[left];
    }

}
