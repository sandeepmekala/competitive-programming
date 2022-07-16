package edu.algos.li06.binarysearch;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
		System.out.println(obj.search(new int[] {4,5,6,7,8,1,2,3}, 8));
	}
	
	public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
            	if(nums[mid] <= nums[right]) {
            		right = mid-1;
            	}else {
            		if(target < nums[left]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
            	}
            }else{
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
