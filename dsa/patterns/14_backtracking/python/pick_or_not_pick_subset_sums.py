# Problem: https://practice.geeksforgeeks.org/problems/subset-sums2234/1
# Idea:
# For each element, we have two choices:
# 1. Pick the element and add it to sum
# 2. Do not pick the element
# When index reaches end, store the sum
# Time: O(2^n)
# Space: O(n) -> recursion stack

def subset_sums(nums):
    result = []
    subset_sums_helper(nums, 0, 0, result)
    result.sort()
    return result


def subset_sums_helper(nums, ind, current_sum, result):
    if ind == len(nums):
        result.append(current_sum)
        return

    # pick the element
    subset_sums_helper(nums, ind + 1, current_sum + nums[ind], result)

    # do-not pick the element
    subset_sums_helper(nums, ind + 1, current_sum, result)


# -------- Test --------
nums = [3, 1, 2]
print(subset_sums(nums))
