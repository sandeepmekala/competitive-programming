# DP / Subsequence
#
# Problem: Count partitions of array into two subsets such that difference = d
# Idea:
#   - Let s1 - s2 = d
#   - totalSum - s2 - s2 = d => s2 = (totalSum - d) // 2
#   - Count subsets with sum = s2
# Time: O(n*target)
# Space: O(n*target)

def countPartitions(nums, d):
    totalSum = sum(nums)
    if totalSum - d < 0 or (totalSum - d) % 2 == 1:  # no valid partitions
        return 0

    target = (totalSum - d) // 2
    return findWays(nums, target)

def findWays(nums, target):
    n = len(nums)
    dp = [[0] * (target + 1) for _ in range(n)]

    if nums[0] == 0:
        dp[0][0] = 2  # 2 cases: pick or not pick
    else:
        dp[0][0] = 1  # 1 case: not pick

    if nums[0] != 0 and nums[0] <= target:
        dp[0][nums[0]] = 1  # 1 case: pick

    for i in range(1, n):
        for t in range(target + 1):
            notPick = dp[i - 1][t]
            pick = 0
            if t - nums[i] >= 0:
                pick = dp[i - 1][t - nums[i]]
            dp[i][t] = pick + notPick

    return dp[n - 1][target]


# -------- Test --------
nums = [5, 2, 5, 1]
d = 3
print(countPartitions(nums, d))  # Expected output: number of partitions
