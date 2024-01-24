package  com.algos.li20_dp;

import java.util.Arrays;

public class Subsequence_A02_UnboundedKnapsack {
    public static void main(String args[]) {
        Subsequence_A02_UnboundedKnapsack obj = new Subsequence_A02_UnboundedKnapsack();

        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int weight = 10, n = wt.length;

        System.out.println(obj.unboundedKnapsack(n, weight, val, wt));
        System.out.println(obj.unboundedKnapsack2(n, weight, val, wt));
    }

    // Problem: https://bit.ly/3IvPdXS
    // Time: O(n*Wmax)
    // Space: O(n*Wmax)
    public int unboundedKnapsack(int n, int weight, int[] val,int[] wt) {
        int[][] value = new int[n][weight+1];
        
        //Base Condition
        for(int i=wt[0]; i<=weight; i++)
            value[0][i] = ((int) i/wt[0]) * val[0];
        
        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=weight; cap++){
                int notTaken = 0 + value[ind-1][cap];
                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + value[ind][cap - wt[ind]];
                    
                value[ind][cap] = Math.max(notTaken, taken);
            }
        }
        
        return value[n-1][weight];
    }

    public int unboundedKnapsack2(int n, int W, int[] val, int[] wt) {
        int[][] value = new int[n][W + 1];
        for (int row[] : value)
            Arrays.fill(row, -1);
        return unboundedKnapsack2(wt, val, n - 1, W, value);
    }

    private int unboundedKnapsack2(int[] wt, int[] val, int ind, int weight, int[][] value) {
        if (ind == 0) 
            return ((int) (weight / wt[0])) * val[0];

        if (value[ind][weight] != -1)
            return value[ind][weight];

        int notTaken = 0 + unboundedKnapsack2(wt, val, ind - 1, weight, value);
        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= weight)
            taken = val[ind] + unboundedKnapsack2(wt, val, ind, weight - wt[ind], value);

        return value[ind][weight] = Math.max(notTaken, taken);
    }
}
