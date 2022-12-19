package edu.algos.li04_twopointers.medium;

import java.util.Arrays;

public class L75_SortColors {

	public static void main(String[] args) {
		L75_SortColors obj = new L75_SortColors();

		int[] nums = new int[] {2,0,2,1,1,0};
		//int[] nums = new int[] {2,0,1};
		obj.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

	/*	
	 * Problem: https://leetcode.com/problems/sort-colors/
	 * Idea: Use low and high pointers. All the element before low should be 0 and all the elements after high should be 2
	 * 		It is called Dutch National Flag Algorithm
	*/
	public void sortColors(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1;
		while (mid <= high) {
			if (nums[mid] == 0) {
				int temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else {
				int temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
			}
		}
	}

}
