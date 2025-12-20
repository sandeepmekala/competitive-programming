"""
LeetCode 81 - Search in Rotated Sorted Array II

Idea:
Same as rotated array search, but duplicates cause ambiguity when
nums[low] == nums[mid] == nums[high].
In that case, shrink both ends.

Time Complexity:
- Average: O(log n)
- Worst: O(n)
Space Complexity: O(1)
"""

def search(nums, target):
    low, high = 0, len(nums) - 1

    while low <= high:
        mid = (low + high) // 2

        if nums[mid] == target:
            return True

        # Ambiguous case due to duplicates
        if nums[low] == nums[mid] == nums[high]:
            low += 1
            high -= 1
            continue

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

    return False


# Driver code
if __name__ == "__main__":
    nums = [2, 5, 6, 0, 0, 1, 2]
    target = 0
    print(search(nums, target))  # True
