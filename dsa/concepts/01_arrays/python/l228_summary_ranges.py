"""
L228 - Summary Ranges

Problem: https://leetcode.com/problems/summary-ranges/
Idea: Track start of range and detect when sequence breaks
Time: O(n)
Space: O(1) excluding output
"""

def summary_ranges(nums):
    if not nums:
        return []
    
    ranges = []
    start = 0
    
    for i in range(1, len(nums)):
        if nums[i] != nums[i - 1] + 1:
            if start == i - 1:
                ranges.append(str(nums[start]))
            else:
                ranges.append(f"{nums[start]}->{nums[i - 1]}")
            start = i
    
    # Handle the last range
    if start == len(nums) - 1:
        ranges.append(str(nums[start]))
    else:
        ranges.append(f"{nums[start]}->{nums[-1]}")
    
    return ranges


if __name__ == "__main__":
    test_cases = [
        [0, 1, 2, 4, 5, 7],
        [0, 2, 3, 4, 6, 8, 9],
        [],
        [-1],
        [0]
    ]
    
    for i, nums in enumerate(test_cases, 1):
        print(f"Test case {i}: {nums}")
        print(f"Summary ranges: {summary_ranges(nums)}")
        print()
