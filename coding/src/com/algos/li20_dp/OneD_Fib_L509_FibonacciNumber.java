package  com.algos.li20_dp;

public class OneD_Fib_L509_FibonacciNumber {

	public static void main(String[] args) {
		OneD_Fib_L509_FibonacciNumber obj = new OneD_Fib_L509_FibonacciNumber();

		
		System.out.println(obj.fib(25));
		System.out.println(obj.fib2(25));
		System.out.println(obj.fib3(25));
	}

	// Problem: https://leetcode.com/problems/fibonacci-number/
	// Idea: fib(n) = fib(n-1) - fib(n-2)
	public int fib(int n) {
        int prev2 = 0, prev1 = 1;
        if(n == 0 || n == 1)
            return n;
        for(int i=2; i<=n; i++){
            int curr = prev2+prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

	private int fib3(int n) {

		int nums[] = new int[n+1];
		nums[0] = 0;
		nums[1] = 1;
		for (int i = 2; i <= n; i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}

		return nums[n];
	}
	
	public int fib2(int n) {
		if (n == 0 || n == 1) 
			return n;
			
		return fib3(n - 1) + fib3(n - 2);
	}
}
