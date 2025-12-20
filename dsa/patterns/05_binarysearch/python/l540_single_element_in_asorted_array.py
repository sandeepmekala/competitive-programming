"""
LeetCode 540 - Single Element in a Sorted Array

Idea:
All elements appear twice except one.
Before the single element:
- pairs start at even index
After the single element:
- pairs start at odd index

Use binary search on index parity.

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def single_non_duplicate(nums):
    n = len(nums)

    # Edge cases
    if n == 1:
        return nums[0]
    if nums[0] != nums[1]:
        return nums[0]
    if nums[n - 1] != nums[n - 2]:
        return nums[n - 1]

    low, high = 1, n - 2

    while low <= high:
        mid = (low + high) // 2

        # Found the single element
        if nums[mid - 1] != nums[mid] != nums[mid + 1]:
            return nums[mid]

        # Check parity
        if mid % 2 == 0:
            # Even index
            if nums[mid] == nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1
        else:
            # Odd index
            if nums[mid] == nums[mid - 1]:
                low = mid + 1
            else:
                high = mid - 1

    return -1


# Driver code
if __name__ == "__main__":
    nums = [1, 1, 2, 3, 3, 4, 4, 8, 8]
    print(single_non_duplicate(nums))  # 2
