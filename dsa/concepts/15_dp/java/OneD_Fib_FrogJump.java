
import java.util.Arrays;

public class OneD_Fib_FrogJump {
    public static void main(String args[]) {
        OneD_Fib_FrogJump obj = new OneD_Fib_FrogJump();
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(obj.frogJump(n - 1, height, dp));
        System.out.println(obj.frogJump(height));
    }

    // Problem: https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
    // Time: O(n)
	// Space: O(n)
    public int frogJump(int[] heights) {
        int n = heights.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        for (int ind = 1; ind < n; ind++) {
            int jump1 = dp[ind - 1] + Math.abs(heights[ind] - heights[ind - 1]);
            int jump2 = Integer.MAX_VALUE;
            if (ind > 1)
                jump2 = dp[ind - 2] + Math.abs(heights[ind] - heights[ind - 2]);

            dp[ind] = Math.min(jump1, jump2);
        }

        return dp[n - 1];
    }

    public int frogJump(int ind, int[] height, int[] dp) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int jump1 = frogJump(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);
        int jump2 = Integer.MAX_VALUE;
        if (ind > 1)
            jump2 = frogJump(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);

        return dp[ind] = Math.min(jump1, jump2);
    }
}
