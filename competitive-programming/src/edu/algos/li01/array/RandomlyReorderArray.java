package edu.algos.li01.array;

import java.util.Arrays;

public class RandomlyReorderArray {

	public static void main(String[] args) {
		RandomlyReorderArray obj = new RandomlyReorderArray();
		int values[] = { 1, 0, 3, 9, 2 };
		System.out.println(Arrays.toString(obj.randomlyReorderArray(values)));
	}

	public int[] randomlyReorderArray(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int randInd = (int) (Math.random() * i);

			int temp = nums[i];
			nums[i] = nums[randInd];
			nums[randInd] = temp;
		}
		return nums;
	}
}