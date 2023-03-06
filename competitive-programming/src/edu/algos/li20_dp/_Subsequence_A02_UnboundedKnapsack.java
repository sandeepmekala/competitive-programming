package edu.algos.li20_dp;

import java.util.Arrays;

public class _Subsequence_A02_UnboundedKnapsack {
    public static void main(String args[]) {

        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        System.out.println(unboundedKnapsack(n, W, val, wt));
    }

    // Problem: https://bit.ly/3IvPdXS
    static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n][W + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return unboundedKnapsack(wt, val, n - 1, W, dp);
    }

    static int unboundedKnapsack(int[] wt, int[] val, int ind, int W, int[][] dp) {
        if (ind == 0) {
            return ((int) (W / wt[0])) * val[0];
        }

        if (dp[ind][W] != -1)
            return dp[ind][W];

        int notTaken = 0 + unboundedKnapsack(wt, val, ind - 1, W, dp);

        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W)
            taken = val[ind] + unboundedKnapsack(wt, val, ind, W - wt[ind], dp);

        return dp[ind][W] = Math.max(notTaken, taken);
    }

    static int unboundedKnapsack2(int n, int W, int[] val,int[] wt) {
        int[][] dp = new int[n][W+1];
        
        //Base Condition
        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = ((int) i/wt[0]) * val[0];
        }
        
        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){
                int notTaken = 0 + dp[ind-1][cap];
                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind][cap - wt[ind]];
                    
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }
        
        return dp[n-1][W];
    }
}
