# Greedy
# Problem: https://leetcode.com/problems/jump-game/
# Idea: For every position check what is the maximum index it can reach.
# If at any point current index is greater than max reachable index, return false.
# Time: O(n)
# Space: O(1)

def can_jump(nums):
    longest = 0
    n = len(nums)

    for i in range(n):
        if i > longest:
            return False
        longest = max(longest, i + nums[i])

    return True


# -------- Test --------
nums = [3, 2, 1, 0, 4]
print(can_jump(nums))   # Expected: False
