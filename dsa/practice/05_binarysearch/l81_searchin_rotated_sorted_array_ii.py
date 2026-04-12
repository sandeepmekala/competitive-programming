# LeetCode 81 - Search in Rotated Sorted Array II
#
# Idea:
# Same as rotated array search, but duplicates cause ambiguity when
# nums[low] == nums[mid] == nums[high].
# In that case, shrink both ends.
#
# Time Complexity:
# - Average: O(log n)
# - Worst: O(n)
# Space Complexity: O(1)

def search(nums: list[int], target: int) -> bool:
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = (left + right) // 2

        if nums[mid] == target:
            return True

        # Ambiguous case due to duplicates nums = [1, 3, 1, 1, 1] target = 3
        if nums[left] == nums[mid] == nums[right]:
            left += 1
            right -= 1
            continue

        # Left half is sorted
        if nums[left] <= nums[mid]:
            if nums[left] <= target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
        # Right half is sorted
        else:
            if nums[mid] < target <= nums[right]:
                left = mid + 1
            else:
                right = mid - 1

    return False


# Driver code
if __name__ == "__main__":
    nums = [2, 5, 6, 0, 0, 1, 2]
    target = 0
    print(search(nums, target))  # True
