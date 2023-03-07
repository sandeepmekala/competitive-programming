package edu.algos.li13_priorityqueue;

public class _L215_KthLargestElementInAnArray {

	public static void main(String[] args) {
		_L215_KthLargestElementInAnArray obj = new _L215_KthLargestElementInAnArray();

		int[] nums = new int[] {3,2,1,5,6,4};
		//int[] nums = new int[] {2,1};
		int k = 2;
		//int k = 1;
		System.out.println(obj.findKthLargest(nums, k));
	}

	// Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/
	// Idea: Apply quick select algo. Use partition algo to find a pivot index, use binary search on n-k to push the index towards n-k.
	public int findKthLargest(int[] nums, int k) {
		int n = nums.length;
		int low = 0, high = n-1;
		while(true) {
			int pivot = partition(nums, low, high);
			if(pivot == n-k) {
				return nums[pivot];
			}else if(pivot < n-k) {
				low = pivot+1;
			}else {
				high = pivot-1;
			}
		}
	}
	
	private int partition(int[] nums, int low, int high) {
		int n = nums.length;
		int i=low, j=high;
		while(i<j) {
			while(i<n && nums[i] <= nums[low]) {
				i++;
			}
			while(j>=0 && nums[j] > nums[low]) {
				j--;
			}
			if(i<j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		int temp = nums[j];
		nums[j] = nums[low];
		nums[low] = temp;
		
		return j;
	}
}
