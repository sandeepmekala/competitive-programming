package  com.algos.li20_dp;

public class _Partitions_L1043_PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        _Partitions_L1043_PartitionArrayForMaximumSum obj = new _Partitions_L1043_PartitionArrayForMaximumSum();

        int[] nums = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        System.out.println(obj.maxSumAfterPartitioning(nums, k));
    }

    public int maxSumAfterPartitioning2(int[] nums, int k) {
        return maxSumAfterPartitioning2(0, nums, k);
    }

    private int maxSumAfterPartitioning2(int ind, int[] num, int k) {
        int n = num.length;
        //base case:
        if (ind == n) return 0;
    
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for (int j = ind; j < Math.min(ind + k, n); j++) {
            len++;
            maxi = Math.max(maxi, num[j]);
            int sum = len * maxi + maxSumAfterPartitioning2(j + 1, num, k);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }

    // Problem: https://leetcode.com/problems/partition-array-for-maximum-sum/
    public int maxSumAfterPartitioning(int[] num, int k) {
        int n = num.length;
        int[] dp = new int[n + 1];
        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            for (int j = ind; j < Math.min(ind + k, n); j++) {
                len++;
                maxi = Math.max(maxi, num[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }

}
