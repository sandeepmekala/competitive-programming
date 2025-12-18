"""
L128 - Longest Consecutive Sequence

Problem: https://leetcode.com/problems/longest-consecutive-sequence/
Idea: Use HashSet to check if num-1 exist in the set
Time: O(n)
Space: O(n)
"""

def longest_consecutive(nums):
    if not nums:
        return 0
    
    num_set = set(nums)
    max_length = 0
    
    for num in nums:
        # Only start counting if this is the beginning of a sequence
        if num - 1 not in num_set:
            current_num = num
            current_length = 0
            
            # Count consecutive numbers
            while current_num in num_set:
                current_length += 1
                current_num += 1
            
            max_length = max(max_length, current_length)
    
    return max_length


if __name__ == "__main__":
    test_cases = [
        [100, 4, 200, 1, 3, 2],
        [0, 3, 7, 2, 5, 8, 4, 6, 0, 1],
        [],
        [1, 2, 0, 1]
    ]
    
    for i, nums in enumerate(test_cases, 1):
        print(f"Test case {i}: {nums}")
        print(f"Longest consecutive sequence: {longest_consecutive(nums)}")
        print()
