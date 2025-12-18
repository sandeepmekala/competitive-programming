"""
L1752 - Check if Array Is Sorted and Rotated

Problem: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
"""

def check(nums):
    n = len(nums)
    count = 0
    
    if nums[0] < nums[n - 1]:
        count += 1
    
    for i in range(1, n):
        if nums[i] < nums[i - 1]:
            count += 1
    
    return count <= 1


if __name__ == "__main__":
    arr = [3, 4, 5, 1, 2]
    print(check(arr))
