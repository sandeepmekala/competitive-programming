"""
L724 - Find Pivot Index

Problem: https://leetcode.com/problems/find-pivot-index/
Idea: Just use sum and prefix sum
"""

def pivot_index(nums):
    total_sum = sum(nums)
    
    prefix_sum = 0
    for i in range(len(nums)):
        if prefix_sum == total_sum - nums[i]:
            return i
        
        prefix_sum += nums[i]
        total_sum -= nums[i]
    
    return -1


if __name__ == "__main__":
    nums = [1, 7, 3, 6, 5, 6]
    print(pivot_index(nums))
