# LeetCode 540 - Single Element in a Sorted Array
#
# Idea:
# All elements appear twice except one.
# Before the single element:
# - pairs start at even index
# After the single element:
# - pairs start at odd index
#
# Use binary search on index parity.
#
# Time Complexity: O(log n)
# Space Complexity: O(1)

def single_non_duplicate(nums: list[int]) -> int:
    # Edge cases
    if len(nums) == 1:
        return nums[0]
    if nums[0] != nums[1]:
        return nums[0]
    if nums[-1] != nums[-2]:
        return nums[-1]

    left, right = 1, len(nums) - 2

    while left <= right:
        mid = (left + right) // 2

        # Found the single element
        if nums[mid - 1] != nums[mid] != nums[mid + 1]:
            return nums[mid]

        # Check parity
        if mid % 2 == 0:
            # Even index
            if nums[mid] == nums[mid + 1]:
                left = mid + 1
            else:
                right = mid - 1
        else:
            # Odd index
            if nums[mid] == nums[mid - 1]:
                left = mid + 1
            else:
                right = mid - 1

    return -1


# Driver code
if __name__ == "__main__":
    nums = [1, 1, 2, 3, 3, 4, 4, 8, 8]
    print(single_non_duplicate(nums))  # 2
