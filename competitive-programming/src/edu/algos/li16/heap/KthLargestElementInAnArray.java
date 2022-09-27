package edu.algos.li16.heap;

public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		KthLargestElementInAnArray obj = new KthLargestElementInAnArray();

		//int[] nums = new int[] {3,2,1,5,6,4};
		int[] nums = new int[] {2,1};
		//int k = 2;
		int k = 1;
		System.out.println(obj.findKthLargest(nums, k));
	}

	public int findKthLargest(int[] nums, int k) {
		int n = nums.length;
		int start = 0, end = n-1;
		while(true) {
			int pivot = partition(nums, start, end);
			if(n-k == pivot) {
				return nums[pivot];
			}else if(n-k > pivot) {
				start = pivot+1;
			}else {
				end = pivot-1;
			}
		}
	}
	
	private int partition(int[] nums, int start, int end) {
		int n = nums.length;
		int i=start, j=end;
		while(i<j) {
			while(i<n && nums[i] <= nums[start]) {
				i++;
			}
			while(j>=0 && nums[j] > nums[start]) {
				j--;
			}
			if(i<j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		int temp = nums[j];
		nums[j] = nums[start];
		nums[start] = temp;
		
		return j;
	}
}
