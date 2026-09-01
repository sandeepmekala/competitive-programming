# Problem: https://leetcode.com/problems/combination-sum-ii/
# Idea: Similar like unique subsets problem.
# We sort the array so that duplicates come together.
# Use Pick / Not Pick approach:
#   - Pick current element (move to next index, no reuse)
#   - Skip all duplicates and then Not Pick
# Time: O(2^n)
# Space: O(n)

def combinationSum2(nums, target):
    nums.sort()
    result = []
    backtrack(nums, 0, target, [], result)
    return result


def backtrack(nums, ind, target, path, result):
    if ind == len(nums):
        if target == 0:
            result.append(path[:])
        return

    # pick
    if nums[ind] <= target:
        path.append(nums[ind])
        backtrack(nums, ind + 1, target - nums[ind], path, result)
        path.pop()  # backtrack

    # skip duplicates before not-pick
    while ind + 1 < len(nums) and nums[ind] == nums[ind + 1]:
        ind += 1

    # not pick
    backtrack(nums, ind + 1, target, path, result)


# -------- Test --------
nums = [10, 1, 2, 7, 6, 1, 5]
target = 8
print(combinationSum2(nums, target))
# Expected:
# [
#   [1,1,6],
#   [1,2,5],
#   [1,7],
#   [2,6]
# ]
