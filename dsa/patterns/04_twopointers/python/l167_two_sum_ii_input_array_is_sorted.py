"""
L167 - Two Sum II - Input Array Is Sorted
Problem: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Idea: One ptr comes from front and another comes from back.
Time: O(n)
Space: O(1)
"""

def two_sum(numbers, target):
    """
    Find two numbers in a sorted array that add up to target.
    
    Args:
        numbers: List[int] - Sorted array of integers
        target: int - Target sum
    
    Returns:
        List[int] - 1-indexed positions of the two numbers
    """
    i, j = 0, len(numbers) - 1
    
    while i < j:
        current_sum = numbers[i] + numbers[j]
        if current_sum == target:
            return [i + 1, j + 1]  # 1-indexed
        elif current_sum > target:
            j -= 1
        else:
            i += 1
    
    return []


if __name__ == "__main__":
    numbers = [2, 7, 11, 15]
    target = 9
    result = two_sum(numbers, target)
    print(result)  # Expected: [1, 2]
