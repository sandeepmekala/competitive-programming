"""
L283 - Move Zeroes
Problem: https://leetcode.com/problems/move-zeroes/
Idea: 1st pointer waits at non 0 place, 2nd pointer waits at 0 place, then swap.
Time: O(n)
Space: O(1)
"""

def move_zeroes(nums):
    """
    Move all zeroes to the end while maintaining relative order of non-zero elements.
    
    Args:
        nums: List[int] - Array of integers
    
    Returns:
        None - Modifies the array in-place
    """
    n = len(nums)
    r = l = 0
    
    while r < n and l < n:
        # Find next non-zero element
        while r < n and nums[r] == 0:
            r += 1
        # Find next zero element that comes before r
        while l < n and nums[l] != 0 and l < r:
            l += 1
        
        if r < n and l < n:
            nums[l], nums[r] = nums[r], nums[l]
            r += 1
            l += 1


if __name__ == "__main__":
    nums = [0, 1, 0, 3, 12]
    move_zeroes(nums)
    print(nums)  # Expected: [1, 3, 12, 0, 0]
