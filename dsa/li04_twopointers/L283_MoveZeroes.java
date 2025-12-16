package li04_twopointers;

import java.util.Arrays;

public class L283_MoveZeroes {

	public static void main(String[] args) {
		L283_MoveZeroes obj = new L283_MoveZeroes();
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		obj.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

	// Problem: https://leetcode.com/problems/move-zeroes/
	// Idea: 1st pointer waits at non 0 place, 2nd pointer waits at 0 place, then swap.
	public void moveZeroes(int[] nums) {
		int r = 0, l = 0, n = nums.length;
		while (r < n && l < n) {
			while (r < n && nums[r] == 0)
				r++;
			while (l < n && nums[l] != 0 && l < r)
				l++;
			if (r < n && l < n) {
				int temp = nums[l];
				nums[l] = nums[r];
				nums[r] = temp;
				r++;
				l++;
			}
		}
	}

}
