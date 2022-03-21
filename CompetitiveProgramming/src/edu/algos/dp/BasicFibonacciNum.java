package edu.algos.dp;

public class BasicFibonacciNum {

	public static void main(String[] args) {

		System.out.println(fibBottomUp(25));
		
		int[] solutions = new int[26];
		System.out.println(fibTopDown(solutions, 25));
	}

	private static int fibBottomUp(int n) {

		int nums[] = new int[n];
		nums[0] = 1;
		nums[1] = 1;
		for (int i = 2; i <= n - 1; i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}

		return nums[n - 1];
	}
	private static int fibTopDown(int[] solutions, int n) {

		if (solutions[n] == 0) {
			if (n == 1 || n == 2) {
				solutions[n] = 1;
			} else {
				solutions[n] = fibTopDown(solutions, n - 1) + fibTopDown(solutions, n - 2);
			}
		}
		return solutions[n];
	}
}
