"""
L665 - Non Decreasing Array

Problem: https://leetcode.com/problems/non-decreasing-array/
Companies: Amazon
Idea: Check if non decrease property voilated more then once. Once it is voilated, we need to correct it atleast once to check if it fails again.
"""

def check_possibility(nums):
    n = len(nums)
    if n < 3:
        return True
    
    non_decreasing = False
    for i in range(n - 1):
        if nums[i] > nums[i + 1]:  # Non decrease voilation check
            if non_decreasing:
                return False
            
            if i > 0:
                if nums[i - 1] <= nums[i + 1]:
                    nums[i] = nums[i + 1]
                else:
                    nums[i + 1] = nums[i]
            else:
                nums[i] = nums[i + 1]
            
            non_decreasing = True
    
    return True


if __name__ == "__main__":
    nums = [4, 2, 3, 5]
    print(check_possibility(nums))
