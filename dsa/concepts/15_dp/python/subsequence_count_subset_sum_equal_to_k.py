# DP / Subsequence
#
# Problem: https://bit.ly/3B5JBkU
# Idea: Count subsets whose sum equals target using DP
# Time: O(n*target)
# Space: O(n*target)

MOD = 10**9 + 7

def findWaysRecursive(nums, ind, target):
    if ind == 0:
        if target == 0 and nums[0] == 0:
            return 2  # 2 cases: pick or not pick
        if target == 0 or target == nums[0]:
            return 1
        return 0

    notPick = findWaysRecursive(nums, ind - 1, target)
    pick = 0
    if nums[ind] <= target:
        pick = findWaysRecursive(nums, ind - 1, target - nums[ind])

    return (notPick + pick) % MOD

def findWaysDP(nums, target):
    n = len(nums)
    dp = [[0] * (target + 1) for _ in range(n)]

    # Base case for first element
    if nums[0] == 0:
        dp[0][0] = 2  # pick or not pick
    else:
        dp[0][0] = 1  # not pick

    if nums[0] != 0 and nums[0] <= target:
        dp[0][nums[0]] = 1  # pick

    for ind in range(1, n):
        for tar in range(target + 1):
            notPick = dp[ind - 1][tar]
            pick = 0
            if nums[ind] <= tar:
                pick = dp[ind - 1][tar - nums[ind]]
            dp[ind][tar] = (pick + notPick) % MOD

    return dp[n - 1][target]


# -------- Test --------
nums = [2, 4, 6, 10]
target = 16

print(findWaysRecursive(nums, len(nums) - 1, target))  # Recursive
print(findWaysDP(nums, target))                         # DP
