# DP / Subsequences
#
# Problem: https://leetcode.com/problems/house-robber-ii/
# Idea: We can't rob both first and last houses. Hence we slip array in to 2 parts.
# One including the first element and another one including last element.
# Run normal House Robber algo on both arrays and take max.
#
# Time: O(n)
# Space: O(n)

def rob(nums):
    n = len(nums)

    if n == 1:
        return nums[0]

    # Case 1: include first house, exclude last
    part1 = nums[0:n-1]

    # Case 2: exclude first house, include last
    part2 = nums[1:n]

    return max(robHelper(part1), robHelper(part2))


def robHelper(profit):
    n = len(profit)
    dp = [-1] * n

    dp[0] = profit[0]
    for i in range(1, n):
        nonPick = dp[i - 1]
        pick = profit[i]
        if i > 1:
            pick += dp[i - 2]

        dp[i] = max(pick, nonPick)

    return dp[n - 1]


# -------- Test --------
nums = [2, 3, 2]
print(rob(nums))  # Expected: 3

# nums = [0, 0]
# print(rob(nums))  # Expected: 0
