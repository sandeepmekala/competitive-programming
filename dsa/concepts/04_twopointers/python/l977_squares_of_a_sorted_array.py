"""
L977 - Squares of a Sorted Array
Problem: https://leetcode.com/problems/squares-of-a-sorted-array/
Idea: Use two pointers from both ends, compare absolute values and fill result from right to left
Time: O(n)
Space: O(n) for the result array
"""

def sorted_squares(nums):
    """
    Return squares of a sorted array in sorted order.
    
    Args:
        nums: List[int] - Sorted array of integers
    
    Returns:
        List[int] - Sorted array of squares
    """
    n = len(nums)
    result = [0] * n
    i, j = 0, n - 1
    ind = n - 1
    
    while i <= j:
        if abs(nums[i]) > abs(nums[j]):
            num = abs(nums[i])
            i += 1
        else:
            num = abs(nums[j])
            j -= 1
        result[ind] = num * num
        ind -= 1
    
    return result


if __name__ == "__main__":
    nums = [-4, -1, 0, 3, 10]
    result = sorted_squares(nums)
    print(result)  # Expected: [0, 1, 9, 16, 100]
