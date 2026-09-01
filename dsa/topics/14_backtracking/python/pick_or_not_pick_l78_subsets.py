# Problem: https://leetcode.com/problems/subsets/
# Idea: Pass the solution list.
# Recursively call the same function with and without each element in solution list.
# Time: O(2^n)
# Space: O(n)

def subsets(nums):
    result = []
    backtrack(nums, 0, [], result)
    return result


def backtrack(nums, ind, path, result):
    if ind == len(nums):
        result.append(path[:])
        return

    # pick
    path.append(nums[ind])
    backtrack(nums, ind + 1, path, result)
    path.pop()  # backtrack

    # not pick
    backtrack(nums, ind + 1, path, result)


# -------- Test --------
nums = [1, 2, 3]
print(subsets(nums))
# Expected:
# [
#   [],
#   [3],
#   [2],
#   [2,3],
#   [1],
#   [1,3],
#   [1,2],
#   [1,2,3]
# ]
