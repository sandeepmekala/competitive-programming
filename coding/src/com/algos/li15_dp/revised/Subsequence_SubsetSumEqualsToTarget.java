package  com.algos.li15_dp.revised;

import java.util.Arrays;

public class Subsequence_SubsetSumEqualsToTarget {
    public static void main(String args[]) {
        Subsequence_SubsetSumEqualsToTarget obj = new Subsequence_SubsetSumEqualsToTarget();

        int[] arr = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        System.out.println(obj.subsetSumToK(n, k, arr));
        System.out.println(obj.subsetSumToK2(n, k, arr));
    }

    // Problem: https://bit.ly/3ukNmRZ
    // Time: O(n*tar)
    // Space: O(n*tar)
    public boolean subsetSumToK(int n, int target,int[] arr){
        boolean dp[][]= new boolean[n][target+1];
        for(int i=0; i<n; i++)
            dp[i][0] = true;
        
        if(arr[0]<=target)
            dp[0][arr[0]] = true;
        for(int ind=1; ind<n; ind++){
            for(int tar=1; tar<=target; tar++){
                boolean notTake = dp[ind-1][tar];
                boolean take = false;
                if(arr[ind]<=tar)
                    take = dp[ind-1][tar-arr[ind]];
            
                dp[ind][tar]= notTake||take;
            }
        }
        
        return dp[n-1][target];
    }

    public boolean subsetSumToK2(int n, int target, int[] arr) {
        int dp[][] = new int[n][target + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return subsetSumToK(n - 1, target, arr, dp);
    }

    private boolean subsetSumToK(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0)
            return arr[0] == target || target == 0;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTake = subsetSumToK(ind - 1, target, arr, dp);
        boolean take = false;
        if (arr[ind] <= target)
            take = subsetSumToK(ind - 1, target - arr[ind], arr, dp);
        dp[ind][target] = notTake || take ? 1 : 0;
        return notTake || take;
    }
    
}
