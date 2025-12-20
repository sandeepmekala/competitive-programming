"""
LeetCode 34 - Find First and Last Position of Element in Sorted Array

Idea:
Use lower bound and upper bound via binary search.

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def lower_bound(nums, target):
    low, high = 0, len(nums) - 1
    res = len(nums)

    while low <= high:
        mid = (low + high) // 2
        if nums[mid] >= target:
            res = mid
            high = mid - 1
        else:
            low = mid + 1

    return res


def upper_bound(nums, target):
    low, high = 0, len(nums) - 1
    res = len(nums)

    while low <= high:
        mid = (low + high) // 2
        if nums[mid] > target:
            res = mid
            high = mid - 1
        else:
            low = mid + 1

    return res


def search_range(nums, target):
    n = len(nums)

    lb = lower_bound(nums, target)
    if lb == n or nums[lb] != target:
        return [-1, -1]

    ub = upper_bound(nums, target)
    return [lb, ub - 1]


# Driver code
if __name__ == "__main__":
    nums = [5, 7, 7, 8, 8, 10]
    target = 8
    print(search_range(nums, target))  # [3, 4]
