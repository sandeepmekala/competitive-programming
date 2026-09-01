# L75 - Sort Colors
#
# Problem: https://leetcode.com/problems/sort-colors/
#
# Idea (Dutch National Flag):
# - nums[0 : low]      -> 0s
# - nums[low : mid]    -> 1s
# - nums[mid : high+1] -> unknown
# - nums[high+1 : ]    -> 2s
#
# Time: O(n)
# Space: O(1)


def sort_colors(nums):
    low = mid = 0
    high = len(nums) - 1

    while mid <= high:
        if nums[mid] == 0:
            nums[low], nums[mid] = nums[mid], nums[low]
            low += 1
            mid += 1
        elif nums[mid] == 1:
            mid += 1
        else:  # nums[mid] == 2
            nums[mid], nums[high] = nums[high], nums[mid]
            high -= 1


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [2, 0, 2, 1, 1, 0]
    sort_colors(nums)
    print(nums)  # Output: [0, 0, 1, 1, 2, 2]
