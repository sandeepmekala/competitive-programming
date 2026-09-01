# Problem: https://leetcode.com/problems/combination-sum/
# Idea: Similar like subset problem. But we have to track sum with subsets to compare with target.
# Use Pick / Not Pick approach:
#   - Pick the current number (stay on same index, as reuse is allowed)
#   - Not pick the current number (move to next index)
# Time: O(2^n)
# Space: O(n)

def combinationSum(nums, target):
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
        backtrack(nums, ind, target - nums[ind], path, result)
        path.pop()  # backtrack

    # not pick
    backtrack(nums, ind + 1, target, path, result)


# -------- Test --------
nums = [2, 3, 6, 7]
target = 7
print(combinationSum(nums, target))
# Expected: [[2, 2, 3], [7]]
