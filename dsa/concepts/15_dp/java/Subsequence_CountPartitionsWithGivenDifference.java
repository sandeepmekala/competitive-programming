public class Subsequence_CountPartitionsWithGivenDifference {
    public static void main(String[] args) {
        Subsequence_CountPartitionsWithGivenDifference obj = new Subsequence_CountPartitionsWithGivenDifference();

        int[] nums = new int[] { 5, 2, 5, 1 };
        System.out.println(obj.countPartitions(nums, 3));
    }

    // Problem: Similar to number of equal partition possible
    // s1-s2 = d
    // totalSum - s2 - s2 = d
    // totalSum - d = 2*s2
    // s2 = (totalSum-d)/2
    // The question boils down to finding number of subsets with s2
    // Time: O(n*tar)
    // Space: O(n*tar)
    public int countPartitions(int nums[], int d) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if (totalSum - d < 0 || (totalSum - d) % 2 == 1)    // as nums[i] >= 0 and there are no decimals in nums
            return 0;

        int target = (totalSum - d) / 2;
        return findWays(nums, target);
    }

    public int findWays(int nums[], int target) {
        int n = nums.length;
        int[][] sum = new int[n][target + 1];
        if (nums[0] == 0)
            sum[0][0] = 2; // 2 cases -pick and not pick
        else
            sum[0][0] = 1; // 1 case - not pick

        if (nums[0] != 0 && nums[0] <= target)
            sum[0][nums[0]] = 1; // 1 case -pick
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notPick = sum[i - 1][j];
                int pick = 0;
                if (j - nums[i] >= 0)
                    pick = sum[i - 1][j - nums[i]];

                sum[i][j] = pick + notPick;
            }
        }
        return sum[n - 1][target];
    }

    int mod = (int) (Math.pow(10, 9) + 7);
    public int findWays(int ind, int target, int[] nums, int[][] sum) {
        if (ind == 0) {
            if (target == 0 && nums[0] == 0)
                return 2;
            if (target == 0 || target == nums[0])
                return 1;
            return 0;
        }

        if (sum[ind][target] != -1)
            return sum[ind][target];

        int notTaken = findWays(ind - 1, target, nums, sum);

        int taken = 0;
        if (nums[ind] <= target)
            taken = findWays(ind - 1, target - nums[ind], nums, sum);

        return sum[ind][target] = (notTaken + taken) % mod;
    }
}
