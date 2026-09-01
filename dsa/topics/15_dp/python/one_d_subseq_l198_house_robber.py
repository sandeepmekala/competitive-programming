# DP / Subsequences
#
# Problem: https://leetcode.com/problems/house-robber/
# Idea: Go left to right by caching the results of smaller problems.
# If you choose to rob the current house, you need rob remaining nums[i-2] houses,
# if you ignore the current house, you need to rob nums[i-1] houses.
#
# T[i] = Max{
#     profit(i) + T[i-2],
#     T[i-1]
# }
#
# Time: O(n)
# Space: O(n)

def rob_recursive(ind, profit):
    if ind == 0:
        return profit[ind]

    non_pick = rob_recursive(ind - 1, profit)
    pick = profit[ind]
    if ind > 1:
        pick += rob_recursive(ind - 2, profit)

    return max(pick, non_pick)


def rob(profit):
    n = len(profit)
    dp = [-1] * n

    dp[0] = profit[0]
    for i in range(1, n):
        non_pick = dp[i - 1]
        pick = profit[i]
        if i > 1:
            pick += dp[i - 2]

        dp[i] = max(pick, non_pick)

    return dp[n - 1]


# -------- Test --------
nums = [2, 7, 9, 3, 1]
n = len(nums)

print(rob_recursive(n - 1, nums))  # Expected: 12
print(rob(nums))                   # Expected: 12
