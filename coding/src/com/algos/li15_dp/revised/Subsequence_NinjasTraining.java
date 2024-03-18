package  com.algos.li15_dp.revised;

import java.util.Arrays;

public class Subsequence_NinjasTraining {
    public static void main(String args[]) {

        int[][] points = {{10,40,70},
                          {20,50,80},
                          {30,60,90}};
           

        int n = points.length;
        System.out.println(ninjaTraining(n, points));
    }

    // Problem: https://bit.ly/3F4yl8z
    static int ninjaTraining(int n, int[][] points) {
        int dp[][] = new int[n][4];
        for (int[] row: dp)
            Arrays.fill(row, -1);

        return ninjaTraining(n - 1, 3, points, dp);
    }
    
    static int ninjaTraining(int ind, int last, int[][] points, int[][] dp) {
        if (ind == 0) {
            int max = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                max = Math.max(max, points[0][i]);
            }
            return dp[ind][last] = max;
        }
        
        if (dp[ind][last] != -1) 
            return dp[ind][last];

        int max = 0;
        for (int task = 0; task <= 2; task++) {
            if (task != last) {
                int pnts = points[ind][task] + ninjaTraining(ind - 1, task, points, dp);
                max = Math.max(max, pnts);
            }
        }

        return dp[ind][last] = max;
    }
    
    public int ninjaTraining2(int n, int[][] points) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int ind = 1; ind < n; ind++) {
            for (int last = 0; last < 4; last++) {
                dp[ind][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int pnts = points[ind][task] + dp[ind - 1][task];
                        dp[ind][last] = Math.max(dp[ind][last], pnts);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }
}
