public class OneD_Fib_L70_ClimbingStairs {

	public static void main(String[] args) {
		OneD_Fib_L70_ClimbingStairs obj = new OneD_Fib_L70_ClimbingStairs();
		System.out.println(obj.climbStairs(3));
		System.out.println(obj.stairchasesXBottomUp(4, new int[] { 1, 3, 5 }));
	}

	// Problem: https://leetcode.com/problems/climbing-stairs/
	// Idea: The nth stair you can reach from n-1 or n-2 stair.
	// So take the number of ways to reach n-1 and n-2 stairs. This recursively goes till base case for n-1 and n-2 cases.
	// Time: O(n)
	// Space: O(n)
	public int climbStairs(int n) {
		int dp[] = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	private int stairchasesXBottomUp(int n, int x[]) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			int total = 0;
			for (int j = 0; j < x.length; j++) {
				if (i - x[j] >= 0) {
					total += dp[i - x[j]];
				}
			}
			dp[i] = total;
		}

		return dp[n];
	}
}
