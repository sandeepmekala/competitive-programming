# Greedy
# Problem: https://leetcode.com/problems/jump-game-ii/
# Idea: Every iteration, we find the range of positions we can reach from current range.
# Calculate next range of positions we can reach from the positions in the current range.
# Time: O(n)
# Space: O(1)

def jump(nums):
    n = len(nums)
    jumps = 0
    l = r = 0

    while r < n - 1:
        longest = 0
        for i in range(l, r + 1):
            longest = max(longest, i + nums[i])
        l = r + 1
        r = longest
        jumps += 1

    return jumps


# DP (for explanation / comparison)
# Idea: If i is reachable from j, then
# minJumps[i] = min(minJumps[i], minJumps[j] + 1)
# Time: O(n^2)
# Space: O(n)

def jump_dp(nums):
    n = len(nums)
    if n == 1:
        return 0
    if nums[0] == 0:
        return -1

    min_jumps = [float('inf')] * n
    min_jumps[0] = 0

    for i in range(1, n):
        for j in range(i):
            if j + nums[j] >= i:
                min_jumps[i] = min(min_jumps[i], min_jumps[j] + 1)

    return -1 if min_jumps[-1] == float('inf') else min_jumps[-1]


# -------- Test --------
nums = [2, 3, 1, 1, 2, 4, 2, 0, 1, 1]
print(jump(nums))      # Expected: 4
print(jump_dp(nums))   # Expected: 4
