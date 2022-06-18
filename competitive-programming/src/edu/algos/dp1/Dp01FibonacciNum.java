package edu.algos.dp1;

public class Dp01FibonacciNum {

	public static void main(String[] args) {
		Dp01FibonacciNum obj = new Dp01FibonacciNum();

		System.out.println(obj.fibBottomUp(25));
		
		int[] mem = new int[26];
		System.out.println(obj.fibTopDown(mem, 25));
	}

	private int fibBottomUp(int n) {

		int nums[] = new int[n+1];
		nums[0] = 1;
		nums[1] = 1;
		for (int i = 2; i <= n; i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}

		return nums[n];
	}
	
	private int fibTopDown(int[] solutions, int n) {

		if (solutions[n] == 0) {
			if (n == 0 || n == 1) {
				solutions[n] = 1;
			} else {
				solutions[n] = fibTopDown(solutions, n - 1) + fibTopDown(solutions, n - 2);
			}
		}
		return solutions[n];
	}
}
