"""
L1480 - Running Sum of 1d Array

Problem: https://leetcode.com/problems/running-sum-of-1d-array/
Idea: Trakc prefixSum;
"""

def running_sum(nums):
    prefix_sum = 0
    for i in range(len(nums)):
        prefix_sum += nums[i]
        nums[i] = prefix_sum
    
    return nums


if __name__ == "__main__":
    nums = [1, 2, 3, 4, 5]
    print(running_sum(nums))
