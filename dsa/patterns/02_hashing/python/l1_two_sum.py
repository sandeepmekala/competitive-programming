"""
L1 - Two Sum

Problem: https://leetcode.com/problems/two-sum/
Idea: Use map to put num and its index
Time: O(n)
Space: O(n)
"""

def two_sum(nums, target):
    num_map = {}
    
    for i, num in enumerate(nums):
        rem = target - num
        if rem in num_map:
            return [num_map[rem], i]
        
        num_map[num] = i
    
    return []


if __name__ == "__main__":
    nums = [2, 7, 11, 15]
    target = 9
    print(f"Input: nums = {nums}, target = {target}")
    print(f"Output: {two_sum(nums, target)}")
