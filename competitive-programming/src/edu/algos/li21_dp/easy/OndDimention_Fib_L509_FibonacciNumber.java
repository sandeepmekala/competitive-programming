package edu.algos.li21_dp.easy;

public class OndDimention_Fib_L509_FibonacciNumber {

	public static void main(String[] args) {
		OndDimention_Fib_L509_FibonacciNumber obj = new OndDimention_Fib_L509_FibonacciNumber();

		System.out.println(obj.fibBottomUp(25));
		
		int[] mem = new int[26];
		System.out.println(obj.fib(25));
	}

	// Problem: https://leetcode.com/problems/fibonacci-number/
	// Idea: fib(n) = fib(n-1) - fib(n-2)
	public int fib(int n) {
        int first = 0, second = 1;
        if(n == 0 || n == 1){
            return n;
        }
        for(int i=2; i<=n; i++){
            int temp = first+second;
            first = second;
            second = temp;
        }
        return second;
    }

	private int fibBottomUp(int n) {

		int nums[] = new int[n+1];
		nums[0] = 0;
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
