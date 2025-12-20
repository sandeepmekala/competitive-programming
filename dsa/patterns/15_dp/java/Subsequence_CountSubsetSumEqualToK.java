import java.util.Arrays;

public class Subsequence_CountSubsetSumEqualToK {

	public static void main(String[] args) {
		Subsequence_CountSubsetSumEqualToK obj = new Subsequence_CountSubsetSumEqualToK();

		int nums[] = {2,4,6,10};
		//int nums[] = {0,0,1};
		int target  = 16;
        int n = nums.length;
		System.out.println(obj.findWays(nums, n-1, target));
		System.out.println(obj.findWays(nums, target));
	}

    // Problem: https://bit.ly/3B5JBkU
    // Idea:
    // Time: O(n*tar)
    // Space: O(n*tar)
    int mod = (int) (Math.pow(10, 9) + 7);
    public int findWays(int[] nums, int ind, int target) {
        if (ind == 0) {
            if (target == 0 && nums[0] == 0)
                return 2;
            if (target == 0 || target == nums[0])
                return 1;
            return 0;
        }

        int notPick = findWays(nums, ind - 1, target);
        int pick = 0;
        if (nums[ind] <= target)
            pick = findWays(nums, ind - 1, target - nums[ind]);

        return (notPick + pick) % mod;
    }

	public int findWays(int nums[], int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        if (nums[0] == 0)
            dp[0][0] = 2;               // 2 cases - pick and not pick
        else
            dp[0][0] = 1;               // 1 case - not pick

        if (nums[0] != 0 && nums[0] <= target)
            dp[0][nums[0]] = 1;         // 1 case - pick
        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= target; tar++) {
                int notPick = dp[ind - 1][tar];
                int pick = 0;
                if (nums[ind] <= tar)
                    pick = dp[ind - 1][tar - nums[ind]];

                dp[ind][tar] = pick + notPick;
            }
        }
        return dp[n - 1][target];
    }

}
