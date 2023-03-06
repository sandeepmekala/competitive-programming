package edu.algos.li06_binarysearch;

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
        int low=0, high = nums.length-2;
        while(low <= high){
            int mid = (low+high)/2;
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }else{
                if(nums[mid] == nums[mid-1]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        
        return nums[low];
    }

}
