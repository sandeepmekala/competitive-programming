# L26 - Remove Duplicates from Sorted Array
#
# Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
#
# Idea:
# - Use two pointers
# - One pointer (read) scans the array
# - One pointer (write) stores the position to place next unique element
#
# Time: O(n)
# Space: O(1)


def remove_duplicates(nums):
    if not nums:
        return 0

    left = 0 # Hold to index until unique are already stored. First element is already unique.

    for right in range(1, len(nums)):
        if nums[right] != nums[left]:
            left += 1
            nums[left] = nums[right]

    return left + 1


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 1, 1, 2]
    k = remove_duplicates(nums)
    print(k)           # Output: 2
    print(nums[:k])    # Output: [1, 2]
