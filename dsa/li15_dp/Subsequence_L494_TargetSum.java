
public class Subsequence_L494_TargetSum {
    public static void main(String[] args) {
        Subsequence_L494_TargetSum obj = new Subsequence_L494_TargetSum();

        System.out.println(obj.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    // Problem: https://leetcode.com/problems/target-sum/
    // Idea: Similar to 2 subsets with d difference. If we take -ve out, it will become.
    // s1 -(s2) = target
    // totalSum - s2 - s2 = target;
    // s2 = (totalSum - target)/2
    // Time: O(n*tar)
    // Space: O(n*tar)
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums, target);
    }

    public int countPartitions(int nums[], int d){
        int totalSum = 0;
        for(int num: nums)
            totalSum += num;

        if(totalSum-d < 0 || (totalSum-d)%2 == 1)
            return 0;

        int target = (totalSum-d)/2;
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
}
