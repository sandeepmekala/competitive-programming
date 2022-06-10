package edu.algos.binarysearch;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;	

		BinarySearch bs = new BinarySearch();
		System.out.println(bs.search(arr, 0, n-1, x));
	}

	// concept: divide the array in half every time based on if mid element is greater or smaller
	private int search(int[] nums, int start, int end, int target) {
		
		if (start <= end) {
			// find mid
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (target <= nums[mid]) {
				return search(nums, start, mid - 1, target);
			} else if (target > nums[mid]) {
				return search(nums, mid + 1, end, target);
			}
		}
		return -1;
	}
	
	

}
