"""
L75 - Sort Colors
Problem: https://leetcode.com/problems/sort-colors/
Idea: Use low, mid and high pointers.
All the element before low should be 0 (0, low-1)
All the elements between low and before mid should be 1 (low, mid-1)
All the elements after high should be 2 (high+1, n-1)
Time: O(n)
Space: O(1)
"""

def sort_colors(nums):
    """
    Sort an array containing only 0s, 1s, and 2s in-place.
    
    Args:
        nums: List[int] - Array containing only 0s, 1s, and 2s
    
    Returns:
        None - Modifies the array in-place
    """
    low = mid = 0
    high = len(nums) - 1
    
    while mid <= high:
        if nums[mid] == 0:
            nums[mid], nums[low] = nums[low], nums[mid]
            low += 1
            mid += 1
        elif nums[mid] == 1:
            mid += 1
        else:  # nums[mid] == 2
            nums[mid], nums[high] = nums[high], nums[mid]
            high -= 1


if __name__ == "__main__":
    nums = [2, 0, 2, 1, 1, 0]
    sort_colors(nums)
    print(nums)  # Expected: [0, 0, 1, 1, 2, 2]
