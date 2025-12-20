"""
L217 - Contains Duplicate

Problem: https://leetcode.com/problems/contains-duplicate/
Idea: Use Set to check duplicates
Time: O(n)
Space: O(n)
"""

def contains_duplicate(nums):
    seen = set()
    
    for num in nums:
        if num in seen:
            return True
        seen.add(num)
    
    return False


if __name__ == "__main__":
    test_cases = [
        [1, 2, 3, 1],
        [1, 2, 3, 4],
        [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
    ]
    
    for i, nums in enumerate(test_cases, 1):
        print(f"Test case {i}: {nums}")
        print(f"Contains duplicate: {contains_duplicate(nums)}")
        print()
