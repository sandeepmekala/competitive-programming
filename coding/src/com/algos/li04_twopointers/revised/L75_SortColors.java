package  com.algos.li04_twopointers.revised;

import java.util.Arrays;

public class L75_SortColors {

	public static void main(String[] args) {
		L75_SortColors obj = new L75_SortColors();

		int[] nums = new int[] {2,0,2,1,1,0};
		//int[] nums = new int[] {2,0,1};
		obj.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

	// Problem: https://leetcode.com/problems/sort-colors/
	// Idea: Use low, mid and high pointers. 
	// All the element before low should be 0 (0, low-1)
	// All the elements between low and before mid should be 1 (low, mid-1)
	// All the elements after high should be 2 (high+1, n-1)
	public void sortColors(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1;
		while (mid <= high) {
			if (nums[mid] == 0) {
				swap(nums, mid, low);
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else {
				swap(nums, mid, high);
				high--;
			}
		}
	}

	private void swap(int[] nums, int ind1, int ind2) {
		int temp = nums[ind2];
		nums[ind2] = nums[ind1];
		nums[ind1] = temp;
	}

}
