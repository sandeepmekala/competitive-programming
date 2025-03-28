package com.algos.company.google;

public class DP_MaxJumpScore {

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println(getMaxScore(nums));
        System.out.println(getMaxScore(nums, 0, new Integer[nums.length]));
    }

    // Problem: https://leetcode.ca/2018-12-05-1696-Jump-Game-VI/
    // https://leetcode.com/discuss/interview-question/4978447/Google-coding-interview-experience
    // Approach 1 : tc : O(n) dfs + memorization
    public static int getMaxScore(int[] nums, int index, Integer[] dp) {
        if (index == nums.length - 1)
            return 0;
        int result = 0;
        if (dp[index] != null)
            return dp[index];
        for (int i = index + 1; i < nums.length; i++) {
            // At each iteration we decide to land + sub problem.
            result = Math.max(result, (i - index) * nums[i] + getMaxScore(nums, i, dp));
        }
        dp[index] = result;
        return result;
    }

    // Approach 3 : Iterative version tc : O(n)
    // While going from target to source, make note of max seen so far, at each
    // iteration we want to append max to the result.
    public static int getMaxScore(int[] nums) {
        int result = 0;
        int maxSeenSoFar = Integer.MIN_VALUE;
        // First value doesn't matter hence condition > 0
        for (int i = nums.length - 1; i > 0; i--) {
            maxSeenSoFar = Math.max(maxSeenSoFar, nums[i]);
            result += maxSeenSoFar;
        }
        return result;
    }
}
