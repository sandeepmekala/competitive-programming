package  com.algos.topics.li15_dp.revised;

public class OneD_Fib_L509_FibonacciNumber {

	public static void main(String[] args) {
		OneD_Fib_L509_FibonacciNumber obj = new OneD_Fib_L509_FibonacciNumber();


		System.out.println(obj.fib(25));
		System.out.println(obj.fib3(25));
		System.out.println(obj.fib2(25));
	}

	// Problem: https://leetcode.com/problems/fibonacci-number/
	// Idea: fib(n) = fib(n-1) - fib(n-2)
	public int fib(int n) {
        int prev2 = 0, prev1 = 1;
        if(n <= 1)
            return n;
        for(int i=2; i<=n; i++){
            int curr = prev1+prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

	private int fib2(int n) {

		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	public int fib3(int n) {
		if (n == 0 || n == 1)
			return n;

		return fib2(n - 1) + fib2(n - 2);
	}
}
