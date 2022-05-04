package edu.algos.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContiguousSubsetProduct {

	public static void main(String[] args) throws IOException {
		long k = 30;
		String inputArr[] = "2,3,-2,4".split(" ");
		long product = 1;
		int j = 0;
		int count = 0;
		for (int i = 0; i < inputArr.length; i++) {
			product *= Integer.parseInt(inputArr[i]);
			if (product < k) {
				count += (i - j + 1);
			} else {
				while (product > k) {
					product /= Integer.parseInt(inputArr[j++]);
				}
				if (product < k) {
					count += (i - j + 1);
				}
			}
		}
		System.out.println(count);
	}
}
