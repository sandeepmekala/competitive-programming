# LeetCode 34 - Find First and Last Position of Element in Sorted Array
#
# Idea:
# Use lower bound and upper bound via binary search.
# Lower bound: smallest ind such that nums[ind] >= x
# Upper bound: smallest ind such that nums[ind] > x

# Time Complexity: O(log n)
# Space Complexity: O(1)

def lower_bound(nums: list[int], target: int) -> int:
    left, right = 0, len(nums) - 1
    ans = len(nums)

    while left <= right:
        mid = left + (right - left) // 2

        if nums[mid] >= target:
            ans = mid
            right = mid - 1
        else:
            left = mid + 1

    return ans


def upper_bound(nums: list[int], target: int) -> int:
    left, right = 0, len(nums) - 1
    ans = len(nums)

    while left <= right:
        mid = left + (right - left) // 2

        if nums[mid] > target:
            ans = mid
            right = mid - 1
        else:
            left = mid + 1

    return ans


def search_range(nums: list[int], target: int) -> list[int]:
    n = len(nums)

    left = lower_bound(nums, target)
    if left == n or nums[left] != target:
        return [-1, -1]

    right = upper_bound(nums, target) - 1
    return [left, right]


# Driver code
if __name__ == "__main__":
    nums = [5, 7, 7, 8, 8, 10]
    target = 8
    print(search_range(nums, target))  # [3, 4]
