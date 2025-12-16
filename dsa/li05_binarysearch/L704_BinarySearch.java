package li05_binarysearch;

public class L704_BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;

		L704_BinarySearch bs = new L704_BinarySearch();
		System.out.println(bs.search(arr, 0, n-1, x));
	}

	// Problem: https://leetcode.com/problems/binary-search/
	// Idea: Divide the array in half every time based on if mid element is greater or smaller
	// Time: O(logn)
	public int search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return -1;
    }

	private int search(int[] nums, int left, int right, int target) {
		if (left <= right) {
			// find mid
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (target <= nums[mid]) {
				return search(nums, left, mid - 1, target);
			} else if (target > nums[mid]) {
				return search(nums, mid + 1, right, target);
			}
		}
		return -1;
	}



}
