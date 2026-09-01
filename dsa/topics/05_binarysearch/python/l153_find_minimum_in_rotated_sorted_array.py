# LeetCode 153 - Find Minimum in Rotated Sorted Array
#
# Idea:
# If the current subarray is already sorted, the minimum is at the left.
# Otherwise:
# - If left half is sorted, minimum is nums[low], discard left half
# - Else right half is sorted, minimum is nums[mid], discard right half
#
# Time Complexity: O(log n)
# Space Complexity: O(1)

def find_min(nums: list[int]) -> int:
    left, right = 0, len(nums) - 1
    minnum = float("inf")

    while left <= right:
        mid = left + (right - left) // 2

        if nums[left] <= nums[mid]:
            minnum = min(minnum, nums[left])
            left = mid + 1
        else:
            minnum = min(minnum, nums[mid])
            right = mid - 1
    return minnum


# Driver code
if __name__ == "__main__":
    nums = [4, 5, 6, 7, 0, 1, 2]
    print(find_min(nums))  # 0
