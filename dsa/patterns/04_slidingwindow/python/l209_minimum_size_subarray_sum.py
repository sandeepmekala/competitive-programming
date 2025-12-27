"""
L209 - Minimum Size Subarray Sum

Problem: https://leetcode.com/problems/minimum-size-subarray-sum/
Idea: Use sliding window as it ask for contiguous sub array.
Continuously find sum of nums, if sum goes more than target, find the min length of all possibilities.
Time: O(n)
Space: O(1)
"""

def min_sub_array_len(target, nums):
    l, r, current_sum, min_len, n = 0, 0, 0, float('inf'), len(nums)
    
    while r < n:
        current_sum += nums[r]
        
        while current_sum >= target:
            min_len = min(min_len, r - l + 1)
            current_sum -= nums[l]
            l += 1
        
        r += 1
    
    return 0 if min_len == float('inf') else min_len


if __name__ == "__main__":
    nums = [2, 3, 1, 2, 4, 3]
    target = 7
    print(f"Input: target = {target}, nums = {nums}")
    print(f"Output: {min_sub_array_len(target, nums)}")
    
    # Additional test cases
    test_cases = [
        (7, [2, 3, 1, 2, 4, 3]),
        (4, [1, 4, 4]),
        (11, [1, 1, 1, 1, 1, 1, 1, 1]),
        (15, [1, 2, 3, 4, 5])
    ]
    
    for target_test, nums_test in test_cases:
        result = min_sub_array_len(target_test, nums_test)
        print(f"Input: target = {target_test}, nums = {nums_test} -> Output: {result}")
