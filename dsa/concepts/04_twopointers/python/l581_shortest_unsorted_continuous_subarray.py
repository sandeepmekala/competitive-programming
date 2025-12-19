"""
L581 - Shortest Unsorted Continuous Subarray
Problem: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
Companies: Amazon
Idea: Find the min and max in unsorted part of the array. Find the indices where those fits in second traversal.
Time: O(n)
Space: O(1)
"""

def find_unsorted_subarray(nums):
    """
    Find the length of shortest unsorted continuous subarray.
    
    Args:
        nums: List[int] - Array of integers
    
    Returns:
        int - Length of shortest unsorted continuous subarray
    """
    n = len(nums)
    min_val = float('inf')
    max_val = float('-inf')
    
    # Find minimum element that is out of order
    for i in range(1, n):
        if nums[i] < nums[i - 1]:
            min_val = min(min_val, nums[i])
    
    # If array is already sorted
    if min_val == float('inf'):
        return 0
    
    # Find maximum element that is out of order
    for j in range(n - 2, -1, -1):
        if nums[j] > nums[j + 1]:
            max_val = max(max_val, nums[j])
    
    # Find left boundary where min_val should be placed
    left = 0
    for i in range(n):
        if nums[i] > min_val:
            left = i
            break
    
    # Find right boundary where max_val should be placed
    right = n
    for j in range(n - 1, -1, -1):
        if nums[j] < max_val:
            right = j
            break
    
    return right - left + 1


if __name__ == "__main__":
    arr = [2, 6, 4, 8, 10, 9, 15]
    result = find_unsorted_subarray(arr)
    print(result)  # Expected: 5
