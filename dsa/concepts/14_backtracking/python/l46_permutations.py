# Problem: https://leetcode.com/problems/permutations/
# Idea: Fix each position once swap each element to that position to generat permutations starting with that element.
# Time: O(n!*n)
# Space: O(1)

def permute(nums):
    result = []
    permute_helper(nums, 0, result)
    return result


def permute_helper(nums, ind, result):
    if ind == len(nums) - 1:
        result.append(nums[:])   # copy current permutation
        return

    for i in range(ind, len(nums)):
        swap(nums, ind, i)
        permute_helper(nums, ind + 1, result)
        swap(nums, ind, i)       # backtracking


def swap(nums, l, r):
    nums[l], nums[r] = nums[r], nums[l]


# -------- Test --------
print(permute([1, 2, 3]))
