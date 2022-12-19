package edu.algos.li06_binarysearch.medium;

public class L33_SearchInRotatedSortedArray {

	public static void main(String[] args) {
		L33_SearchInRotatedSortedArray obj = new L33_SearchInRotatedSortedArray();
		System.out.println(obj.search(new int[] {4,5,6,7,8,1,2,3}, 8));
	}
	
    // Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
    // Idea: 
	public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
            	if(nums[mid] <= nums[right]) {
            		right = mid-1;
            	}else {
            		if(target < nums[left]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
            	}
            }else{                                  // 4,5,6,7,8,1,2,3
            	if(nums[left] <= nums[mid]) {
            		left = mid+1;
            	}else {
            		if(target > nums[right]){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
            	}
            }
        }
        return -1;
    }

}
