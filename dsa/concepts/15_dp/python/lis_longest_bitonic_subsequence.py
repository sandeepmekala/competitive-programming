# DP
# Problem: https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
# Idea: Build lis arrays from left to right and right to left and sum them
# 0    1    2    3    4    5    6    7
# 1    1    2    2    3    1    2    2
# 2    1    3    2    3    1    2    1
#
# 2    1    4    3    5    1    3    2
#
# Time: O(n^2)
# Space: O(n)

def longest_bitonic_sequence(nums):
    n = len(nums)

    # LIS from left to right
    lrLis = [1] * n
    for i in range(1, n):
        for j in range(i):
            if nums[j] < nums[i]:
                lrLis[i] = max(lrLis[i], lrLis[j] + 1)

    # LIS from right to left (for decreasing part)
    rlLis = [1] * n
    for i in range(n - 2, -1, -1):
        for j in range(n - 1, i, -1):
            if nums[j] < nums[i]:
                rlLis[i] = max(rlLis[i], rlLis[j] + 1)

    # Combine both
    max_len = 0
    for i in range(n):
        max_len = max(max_len, lrLis[i] + rlLis[i] - 1)

    return max_len


# -------- Test --------
nums = [2, -1, 4, 3, 5, -1, 3, 2]
print(longest_bitonic_sequence(nums))  # Expected: 5
