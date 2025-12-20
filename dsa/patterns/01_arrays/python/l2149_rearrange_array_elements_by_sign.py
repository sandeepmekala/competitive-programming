"""
L2149 - Rearrange Array Elements by Sign

Problem: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
Idea: Traverse the array and put positive numbers at even index and negative numbers at odd index.
"""

def rearrange_array(nums):
    n = len(nums)
    
    temp = [0] * n
    pos = 0
    neg = 1
    
    for i in range(n):
        if nums[i] < 0:
            temp[neg] = nums[i]
            neg += 2
        else:
            temp[pos] = nums[i]
            pos += 2
    
    return temp


if __name__ == "__main__":
    nums = [-1, 2, 3, -4, -1, 4]
    nums = rearrange_array(nums)
    print(nums)
