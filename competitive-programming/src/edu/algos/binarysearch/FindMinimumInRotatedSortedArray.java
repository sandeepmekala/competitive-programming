package edu.algos.binarysearch;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
		System.out.println(obj.findMin(new int[] {3,4,5,1,2}));
	}
	
	public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        int min = nums[0];
        while(left<=right){
            if(nums[left] <= nums[right]){		//[2,1]
            	min = Math.min(min, nums[left]);
                break;
            }
            
            int mid = (left+right)/2;
            min = Math.min(min, nums[mid]);		//[3,1,2]
            if(nums[left] <= nums[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return min;
    }

}
