"""
LeetCode 153 - Find Minimum in Rotated Sorted Array

Idea:
If the current subarray is already sorted, the minimum is at the left.
Otherwise:
- If left half is sorted, minimum is nums[low], discard left half
- Else right half is sorted, minimum is nums[mid], discard right half

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def find_min(nums):
    low, high = 0, len(nums) - 1
    ans = float("inf")

    while low <= high:
        # If subarray is already sorted
        if nums[low] <= nums[high]:
            return min(ans, nums[low])

        mid = (low + high) // 2

        # Left half is sorted
        if nums[low] <= nums[mid]:
            ans = min(ans, nums[low])
            low = mid + 1
        # Right half is sorted
        else:
            ans = min(ans, nums[mid])
            high = mid - 1

    return ans


# Driver code
if __name__ == "__main__":
    nums = [4, 5, 6, 7, 0, 1, 2]
    print(find_min(nums))  # 0
