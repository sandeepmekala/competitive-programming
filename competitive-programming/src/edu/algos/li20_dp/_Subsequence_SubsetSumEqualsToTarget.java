package edu.algos.li20_dp;

import java.util.Arrays;

public class _Subsequence_SubsetSumEqualsToTarget {
    public static void main(String args[]) {

        int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        System.out.println(subsetSumToK(n, k, arr));
        System.out.println(subsetSumToK2(n, k, arr));
    }

    static boolean subsetSumToK(int n, int target, int[] arr) {
        int dp[][] = new int[n][target + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return subsetSumToK(n - 1, target, arr, dp);
    }

    static boolean subsetSumToK(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;
        if (ind == 0)
            return arr[0] == target;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTaken = subsetSumToK(ind - 1, target, arr, dp);
        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumToK(ind - 1, target - arr[ind], arr, dp);
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    static boolean subsetSumToK2(int n, int target,int[] arr){
        boolean dp[][]= new boolean[n][target+1];
        for(int i=0; i<n; i++)
            dp[i][0] = true;
        
        if(arr[0]<=target)
            dp[0][arr[0]] = true;
        for(int ind=1; ind<n; ind++){
            for(int tar=1; tar<=target; tar++){
                boolean notTaken = dp[ind-1][tar];
                boolean taken = false;
                    if(arr[ind]<=tar)
                        taken = dp[ind-1][tar-arr[ind]];
            
                dp[ind][tar]= notTaken||taken;
            }
        }
        
        return dp[n-1][target];
    }
    
}
