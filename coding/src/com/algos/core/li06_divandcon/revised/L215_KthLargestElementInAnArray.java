package  com.algos.core.li06_divandcon.revised;

public class L215_KthLargestElementInAnArray {

	public static void main(String[] args) {
		L215_KthLargestElementInAnArray obj = new L215_KthLargestElementInAnArray();

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
			int pivotIndex = partition(nums, low, high);
			if(pivotIndex == n-k) {
				return nums[pivotIndex];
			}else if(pivotIndex < n-k) {
				low = pivotIndex+1;
			}else {
				high = pivotIndex-1;
			}
		}
	}
	
	// low is pivot
	private int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
        int pivotIndx = low;
        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, pivotIndx);
                pivotIndx++;
            }
        }
        swap(nums, pivotIndx, high);
        return pivotIndx;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
