# DP / Subsequence
#
# Problem: https://leetcode.com/problems/target-sum/
# Idea: Convert target sum problem into subset sum with difference
#       If we consider '-' signs as s2 subset:
#       s1 - s2 = target
#       totalSum - s2 - s2 = target
#       s2 = (totalSum - target) / 2
# Time: O(n * target)
# Space: O(n * target)

def findTargetSumWays(nums, target):
    return countPartitions(nums, target)

def countPartitions(nums, d):
    totalSum = sum(nums)
    if totalSum - d < 0 or (totalSum - d) % 2 == 1:
        return 0
    target = (totalSum - d) // 2
    return findWays(nums, target)

def findWays(nums, target):
    n = len(nums)
    dp = [[0] * (target + 1) for _ in range(n)]

    # Base case
    if nums[0] == 0:
        dp[0][0] = 2  # pick or not pick
    else:
        dp[0][0] = 1  # not pick

    if nums[0] != 0 and nums[0] <= target:
        dp[0][nums[0]] = 1  # pick

    for i in range(1, n):
        for t in range(target + 1):
            notPick = dp[i - 1][t]
            pick = 0
            if nums[i] <= t:
                pick = dp[i - 1][t - nums[i]]
            dp[i][t] = pick + notPick

    return dp[n - 1][target]


# -------- Test --------
nums = [1, 1, 1, 1, 1]
target = 3
print(findTargetSumWays(nums, target))  # Expected: 5
