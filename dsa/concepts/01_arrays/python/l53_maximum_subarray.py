"""
L53 - Maximum Subarray

Problem: https://leetcode.com/problems/maximum-subarray/
Idea: Continuously add numbers, if sum goes above global sum, update global sum.
If sum goes negative, reset it to 0.
Time: O(n)
Space: O(1)
"""

def max_sub_array(nums):
    total_sum = 0
    max_sum = float('-inf')
    
    for i in range(len(nums)):
        total_sum += nums[i]
        if total_sum > max_sum:
            max_sum = total_sum
        if total_sum < 0:
            total_sum = 0
    
    return max_sum


def max_sub_array2(nums):
    total_sum = 0
    max_sum = float('-inf')
    start = 0
    end = 0
    
    for i in range(len(nums)):
        total_sum += nums[i]
        if total_sum > max_sum:
            max_sum = total_sum
            end = i
        if total_sum < 0:
            total_sum = 0
            start = i + 1
    
    return [start, end]


if __name__ == "__main__":
    print(max_sub_array([1, -3, 2, 1, -1]))  # 3
    print(max_sub_array2([1, -3, 2, 1, -1]))  # [2, 3]
