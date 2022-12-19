package edu.algos.li04_twopointers.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_ThreeSum {

	public static void main(String[] args) {
		L15_ThreeSum obj = new L15_ThreeSum();
		System.out.println(obj.threeSum(new int[] { -2,0,0,2,2}));
	}

	// Problem: https://leetcode.com/problems/3sum/
	// Idea: Sort the nums to eleminate the duplicates
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		if (nums.length >= 3) {
			for (int i = 0; i <= nums.length - 3; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				int left = i + 1, right = nums.length - 1;
				while (left < right) {
					if (nums[i] + nums[left] + nums[right] == 0) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[left]);
						list.add(nums[right]);
						result.add(list);
						
						while(left < right && nums[left] == nums[left+1]) left++;
						while(left < right && nums[right] == nums[right-1]) right--;
						left++;
						right--;
					} else if (nums[i] + nums[left] + nums[right] > 0) {
						right--;
					} else {
						left++;
					}
				}
			}
		}

		return result;
	}
}
