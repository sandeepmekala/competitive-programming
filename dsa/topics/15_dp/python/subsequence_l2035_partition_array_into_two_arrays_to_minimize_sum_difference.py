# DP / Subset Sum
# Problem: https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
# Idea:
# 1. Compute total sum of nums.
# 2. Use DP to compute all possible subset sums from 0 to total sum.
# 3. For negative numbers, use a dict to simulate DP table with keys as "index:sum".
# 4. Minimum difference is min(abs(total - 2 * subset_sum)) for feasible subset sums.
# Time: O(n*total)
# Space: O(n*total) (can be optimized)

def minimum_difference(nums):
    target = sum(nums)
    n = len(nums)
    
    # DP dictionary to handle negative numbers
    sum_dp = {}
    
    for ind in range(n):
        for tar in range(target + 1):
            key = f"{ind}:{tar}"
            if tar == 0:
                sum_dp[key] = True
            elif ind == 0:
                sum_dp[key] = (tar == nums[ind])
            else:
                not_pick = sum_dp.get(f"{ind-1}:{tar}", False)
                pick = False
                if nums[ind] <= tar:
                    pick = sum_dp.get(f"{ind-1}:{tar-nums[ind]}", False)
                sum_dp[key] = not_pick or pick

    min_diff = float('inf')
    for s1 in range(target // 2 + 1):
        if sum_dp.get(f"{n-1}:{s1}", False):
            s2 = target - s1
            min_diff = min(min_diff, abs(s2 - s1))
    
    return min_diff


# -------- Test --------
nums = [2, -1, 0, 4, -2, -9]
print(minimum_difference(nums))  # Expected: 0
