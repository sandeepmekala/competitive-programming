"""
L268 - Missing Number

Problem: https://leetcode.com/problems/missing-number/
Idea: a ^ b ^ b = a
"""

def missing_number(nums):
    xor = 0
    i = 0
    for i in range(len(nums)):
        xor = xor ^ i ^ nums[i]
    return xor ^ i


if __name__ == "__main__":
    print(missing_number([3, 0, 1]))
