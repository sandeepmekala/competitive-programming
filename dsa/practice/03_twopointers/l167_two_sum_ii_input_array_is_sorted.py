"""
L167 - Two Sum II - Input Array Is Sorted
Problem: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Idea: One ptr comes from front and another comes from back.
Time: O(n)
Space: O(1)
"""

def two_sum(nums, target):
    """
    Find two numbers in a sorted array that add up to target.
    
    Args:
        numbers: List[int] - Sorted array of integers
        target: int - Target sum
    
    Returns:
        List[int] - 1-indexed positions of the two numbers
    """
    l, r = 0, len(nums) - 1
    
    while l < r:
        current_sum = nums[l] + nums[r]
        if current_sum == target:
            return [l + 1, r + 1]  # 1-indexed
        elif current_sum > target:
            r -= 1
        else:
            l += 1
    
    return []


if __name__ == "__main__":
    numbers = [2, 7, 11, 15]
    target = 9
    result = two_sum(numbers, target)
    print(result)  # Expected: [1, 2]
