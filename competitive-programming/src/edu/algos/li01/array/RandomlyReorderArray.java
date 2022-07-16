package edu.algos.li01.array;

import java.util.Arrays;

public class RandomlyReorderArray {

	public static void main(String[] args) {
		int values[] = { 1, 0, 3, 9, 2 };
		System.out.println(Arrays.toString(randomlyReorderArray(values)));
	}

	private static int[] randomlyReorderArray(int[] values) {

		for (int i = values.length - 1; i >= 0; i--) {
			int randInd = (int) (Math.random() * i);
			int temp = values[i];
			values[i] = values[randInd];
			values[randInd] = temp;
		}
		return values;
	}
}