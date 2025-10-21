package  com.algos.topics.li15_dp.revised;

public class Subsequence_NinjasTraining {
    public static void main(String args[]) {
        Subsequence_NinjasTraining obj = new Subsequence_NinjasTraining();

        int[][] points = {{10,40,70},
                          {20,50,80},
                          {30,60,90}};


        int n = points.length;
        // if I perform 3 on nth day, what is the max points I can get from 0 to n-1 days
        System.out.println(obj.ninjaTraining(n - 1, 3, points));
        System.out.println(obj.ninjaTraining(n, points));
    }

    // Problem: https://bit.ly/3F4yl8z
    public int ninjaTraining(int ind, int last, int[][] points) {
        if (ind == 0) {
            int max = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    max = Math.max(max, points[0][i]);
            }
            return max;
        }

        int max = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int pnts = points[ind][i] + ninjaTraining(ind - 1, i, points);
                max = Math.max(max, pnts);
            }
        }

        return max;
    }

    public int ninjaTraining(int n, int[][] points) {
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
