# Problem: https://leetcode.com/problems/permutations-ii/
# Idea: Fix each position once swap each element to that position to generat permutations.
# Skip duplicate numbers using set. Alternatively, you can sort nums also.
# Time: O(n!)
# Space: O(1)

def permuteUnique(nums):
    result = []
    # nums.sort()
    permute(nums, 0, result)
    return result


def permute(nums, ind, result):
    if ind == len(nums) - 1:
        result.append(nums[:])   # copy current permutation
        return

    distinct = set()
    for i in range(ind, len(nums)):
        # if i > ind and nums[i] == nums[i - 1]: continue
        if nums[i] in distinct:
            continue
        distinct.add(nums[i])

        swap(nums, ind, i)
        permute(nums, ind + 1, result)
        swap(nums, ind, i)       # backtracking


def swap(nums, l, i):
    nums[l], nums[i] = nums[i], nums[l]


# -------- Test --------
print(permuteUnique([1, 1, 2]))
