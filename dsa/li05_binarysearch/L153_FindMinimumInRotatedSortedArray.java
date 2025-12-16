package li05_binarysearch;

public class L153_FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		L153_FindMinimumInRotatedSortedArray obj = new L153_FindMinimumInRotatedSortedArray();
		System.out.println(obj.findMin(new int[] {4,5,6,7,0,1,2}));     // 0
	}

    // Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    // Idea: If left part is sorted, then update min with nums[low] and eleminate left part
    // Else right part is sorted, update min with nums[mid] and eleminate right part
	public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(low <= high){
            if(nums[low] <= nums[high])     // remaining array is sorted now we can exit
                return Math.min(min, nums[low]);

            int mid = (low+high)/2;
            if(nums[low] <= nums[mid]){     // left part is sorted
                min = Math.min(min, nums[low]);
                low = mid+1;
            }else{                          // right part is sorted
                min = Math.min(min, nums[mid]);
                high = mid-1;
            }
        }

        return min;
    }

}
