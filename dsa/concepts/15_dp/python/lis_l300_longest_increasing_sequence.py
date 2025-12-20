import sys
sys.setrecursionlimit(10**7)

# Problem: https://leetcode.com/problems/longest-increasing-subsequence/
# Idea: Pass prev element index to find the lis of current element
# Time: O(n^2)
# Space: O(n)
def lengthOfLis(nums, ind, prev):
    n = len(nums)
    if ind == n:
        return 0

    notPick = lengthOfLis(nums, ind + 1, prev)
    pick = 0
    if prev == -1 or nums[ind] > nums[prev]:
        pick = 1 + lengthOfLis(nums, ind + 1, ind)

    return max(pick, notPick)


# Idea: Find lis of all the previous elements starting from left to right,	then find lis of current element
# Current element lis is the max of all the previous elements lis plus 1
# O(n^2) as it takes another loop to find the max for current element
# Lis can be printed if we track the parent array if the cur lis gets updated.
# The same can be written in interative way where ind = n-1 -> 0, prev = ind-1 -> -1. prev can't be greater then ind.
# There is a better way of implementing it with same O(n^2) time as below.
# Alternative: We can use binary search to create a new increasing temp array by inserting and overriding the elements in temp array to reduce the time complexity.
# But that adds O(n) space. With this approach, we can't derive the the lis string.
def lengthOfLIS(nums):
    n = len(nums)
    if n == 1:
        return 1

    lis = [1] * n              # lis for each element is itself
    maxLen = 0

    for i in range(1, n):
        for j in range(i):
            if nums[i] > nums[j]:
                if 1 + lis[j] > lis[i]:
                    lis[i] = 1 + lis[j]

        maxLen = max(maxLen, lis[i])   # max lis of all the elements

    return maxLen


# -------- Test (same as Java main) --------
nums = [2, -1, 4, 3, 5, -1, 3, 2]
print(lengthOfLis(nums, 0, -1))   # ind, prev
print(lengthOfLIS(nums))
