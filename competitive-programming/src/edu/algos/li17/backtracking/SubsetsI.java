package edu.algos.li17.backtracking;

import java.util.ArrayList;

public class SubsetsI {

	public static void main(String[] args) {
		int[] set = new int[] { 1, 2, 3 };
		subsets(set, new ArrayList<Integer>(), 0);
	}

	private static void subsets(int nums[], ArrayList<Integer> list, int index) {
		if (index >= nums.length) {
			System.out.println(new ArrayList<>(list));
			return;
		}

		list.add(nums[index]);
		subsets(nums, list, index + 1);
		list.remove(list.size()-1);
		subsets(nums, list, index + 1);

	}
}