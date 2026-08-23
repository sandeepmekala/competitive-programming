"""
L179 - Largest Number

Problem: https://leetcode.com/problems/largest-number/
Idea: Custom sort by comparing concatenated strings
Time: O(n log n)
Space: O(n)
"""

from functools import cmp_to_key

def largest_number(nums):
    # Convert to strings
    str_nums = [str(num) for num in nums]
    
    # Custom comparator: compare x+y vs y+x
    def compare(x, y):
        if x + y > y + x:
            return -1
        elif x + y < y + x:
            return 1
        else:
            return 0
    
    # Sort using custom comparator
    str_nums.sort(key=cmp_to_key(compare))
    
    # Join and handle edge case of all zeros
    result = ''.join(str_nums)
    return '0' if result[0] == '0' else result


if __name__ == "__main__":
    test_cases = [
        [10, 2],
        [3, 30, 34, 5, 9],
        [1],
        [0, 0],
        [432, 43]
    ]
    
    for i, nums in enumerate(test_cases, 1):
        print(f"Test case {i}: {nums}")
        print(f"Largest number: {largest_number(nums)}")
        print()
