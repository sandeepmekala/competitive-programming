
import java.util.Arrays;

public class Subsequence_UnboundedKnapsack {
    public static void main(String[] args) {
        Subsequence_UnboundedKnapsack obj = new Subsequence_UnboundedKnapsack();

        int[] wt = { 2, 4, 6 };
        int[] val = { 5, 11, 13 };
        int weight = 10, n = wt.length;

        System.out.println(obj.unboundedKnapsack(n, weight, val, wt));
        System.out.println(obj.unboundedKnapsack2(n, weight, val, wt));
    }

    // Problem: https://bit.ly/3IvPdXS
    // Time: O(n*Wmax)
    // Space: O(n*Wmax)
    public int unboundedKnapsack(int n, int w, int[] profit,int[] weight) {
        int[][] value = new int[n][w+1];

        for(int i=weight[0]; i<=w; i++)
            value[0][i] = (i/weight[0]) * profit[0];

        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=w; cap++){
                int notTaken = 0 + value[ind-1][cap];
                int taken = Integer.MIN_VALUE;
                if(weight[ind] <= cap)
                    taken = profit[ind] + value[ind][cap - weight[ind]];

                value[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return value[n-1][w];
    }

    public int unboundedKnapsack2(int n, int w, int[] profit, int[] weight) {
        return unboundedKnapsack2(weight, profit, n - 1, w);
    }

    private int unboundedKnapsack2(int[] wt, int[] val, int ind, int weight) {
        if (ind == 0)
            return (weight / wt[0]) * val[0];

        int notTaken = 0 + unboundedKnapsack2(wt, val, ind - 1, weight);
        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= weight)
            taken = val[ind] + unboundedKnapsack2(wt, val, ind, weight - wt[ind]);

        return Math.max(notTaken, taken);
    }
}
