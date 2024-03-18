package  com.algos.li05_binarysearch;

public class L153_FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		L153_FindMinimumInRotatedSortedArray obj = new L153_FindMinimumInRotatedSortedArray();
		System.out.println(obj.findMin(new int[] {4,5,6,7,0,1,2}));
	}
	
    // Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    // Idea: Continuosly, update min with nums[mid]
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
