import java.util.Arrays;

public class Subsequence_SubsetSumEqualsToTarget {
    public static void main(String args[]) {
        Subsequence_SubsetSumEqualsToTarget obj = new Subsequence_SubsetSumEqualsToTarget();

        int[] nums = { 1, 2, 3, 4 };
        int target = 4;
        int n = nums.length;

        System.out.println(obj.subsetSumToK(nums, n - 1, target));
        System.out.println(obj.subsetSumToK(nums, target));
    }

    // Problem: https://bit.ly/3ukNmRZ
    // Time: O(n*tar)
    // Space: O(n*tar)
    public boolean subsetSumToK(int[] nums, int ind, int target) {
        if (ind == 0)
            return nums[0] == target || target == 0;

        boolean notPick = subsetSumToK(nums, ind - 1, target);
        boolean pick = false;
        if (nums[ind] <= target)
            pick = subsetSumToK(nums, ind - 1, target - nums[ind]);

        return notPick || pick;
    }

    public boolean subsetSumToK(int[] nums, int target){
        int n = nums.length;
        boolean[][] dp = new boolean[n][target+1];
        for(int i=0; i<n; i++)
            dp[i][0] = true;

        if(nums[0]<=target)
            dp[0][nums[0]] = true;
        for(int ind=1; ind<n; ind++){
            for(int tar=1; tar<=target; tar++){
                boolean notTake = dp[ind-1][tar];
                boolean take = false;
                if(nums[ind]<=tar)
                    take = dp[ind-1][tar-nums[ind]];

                dp[ind][tar] = notTake||take;
            }
        }

        return dp[n-1][target];
    }

}
