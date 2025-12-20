# DP / Recursion
# Problem: https://bit.ly/3ukNmRZ
# Idea:
# 1. For each element, we can either pick it or not pick it to reach target.
# 2. Recursion with base case: index 0, check if nums[0] == target or target == 0.
# 3. DP table stores whether a sum is possible with first i elements.
# Time: O(n*target)
# Space: O(n*target)

def subset_sum_to_k_recursive(nums, ind, target):
    if ind == 0:
        return nums[0] == target or target == 0

    not_pick = subset_sum_to_k_recursive(nums, ind - 1, target)
    pick = False
    if nums[ind] <= target:
        pick = subset_sum_to_k_recursive(nums, ind - 1, target - nums[ind])

    return not_pick or pick


def subset_sum_to_k_dp(nums, target):
    n = len(nums)
    dp = [[False] * (target + 1) for _ in range(n)]

    # Base case: sum 0 is always possible
    for i in range(n):
        dp[i][0] = True

    if nums[0] <= target:
        dp[0][nums[0]] = True

    for ind in range(1, n):
        for tar in range(1, target + 1):
            not_take = dp[ind - 1][tar]
            take = False
            if nums[ind] <= tar:
                take = dp[ind - 1][tar - nums[ind]]
            dp[ind][tar] = not_take or take

    return dp[n - 1][target]


# -------- Test --------
nums = [1, 2, 3, 4]
target = 4
n = len(nums)

print(subset_sum_to_k_recursive(nums, n - 1, target))  # Recursive approach
print(subset_sum_to_k_dp(nums, target))                # DP approach
