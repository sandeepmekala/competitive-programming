# DP / Subsequence
#
# Problem: https://leetcode.com/problems/partition-equal-subset-sum/
# Idea: Can we split array into two subsets with equal sum?
#       s1 + s2 = totalSum => s1 = s2 = totalSum / 2
# Time: O(n * target)
# Space: O(n * target)

def canPartition(nums):
    n = len(nums)
    totalSum = sum(nums)
    if totalSum % 2 == 1 or n == 1:
        return False

    target = totalSum // 2
    return subsetSumToK(nums, n, target)

def subsetSumToK(nums, n, target):
    dp = [[False] * (target + 1) for _ in range(n)]

    for ind in range(n):
        for tar in range(target + 1):
            if tar == 0:
                dp[ind][tar] = True
            elif ind == 0:
                dp[ind][tar] = (tar == nums[0])
            else:
                notPick = dp[ind - 1][tar]
                pick = False
                if nums[ind] <= tar:
                    pick = dp[ind - 1][tar - nums[ind]]
                dp[ind][tar] = notPick or pick

    return dp[n - 1][target]


# -------- Test --------
nums = [2, 4, 11, 5]
print(canPartition(nums))  # Expected: False
