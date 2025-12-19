"""
L26 - Remove Duplicates from Sorted Array
Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
Idea: Use two pointers. One ptr finds distinct number and other one holds the place to insert the distinct num.
Time: O(n)
Space: O(1)
"""

def remove_duplicates(nums):
    """
    Remove duplicates from sorted array in-place.
    
    Args:
        nums: List[int] - Sorted array with possible duplicates
    
    Returns:
        int - Length of array after removing duplicates
    """
    l = 0
    for r in range(1, len(nums)):
        if nums[r] != nums[l]:
            l += 1
            nums[l] = nums[r]
    return l + 1


if __name__ == "__main__":
    nums = [1, 1, 1, 2]
    result = remove_duplicates(nums)
    print(result)  # Expected: 2
    print(nums[:result])  # Expected: [1, 2]
