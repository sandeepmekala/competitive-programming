"""
LeetCode 33 - Search in Rotated Sorted Array

Idea:
At every step, one half of the array is always sorted.
Check which half is sorted and decide where the target can lie.

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def search(nums, target):
    low, high = 0, len(nums) - 1

    while low <= high:
        mid = (low + high) // 2

        if nums[mid] == target:
            return mid

        # Left half is sorted
        if nums[low] <= nums[mid]:
            if nums[low] <= target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        # Right half is sorted
        else:
            if nums[mid] < target <= nums[high]:
                low = mid + 1
            else:
                high = mid - 1

    return -1


# Driver code
if __name__ == "__main__":
    nums = [4, 5, 6, 7, 8, 1, 2, 3]
    target = 8
    print(search(nums, target))   # 4
