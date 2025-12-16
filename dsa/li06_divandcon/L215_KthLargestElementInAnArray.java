package li06_divandcon;

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
	// Time: O(n*logn)
	public int findKthLargest(int[] nums, int k) {
		int n = nums.length;
		int low = 0, high = n-1;
		while(true) {
			int pivotInd = partition(nums, low, high);
			if(pivotInd == n-k) {
				return nums[pivotInd];
			}else if(pivotInd < n-k) {
				low = pivotInd+1;
			}else {
				high = pivotInd-1;
			}
		}
	}

	// high is pivot
	private int partition(int[] nums, int low, int high) {
        int pivotInd = low;
		int pivot = nums[high];
        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, pivotInd);
                pivotInd++;
            }
        }
        swap(nums, pivotInd, high);
        return pivotInd;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
