"""
L414 - Third Maximum Number

Problem: https://leetcode.com/problems/third-maximum-number/
Idea: Swap max -> secMax, secMax -> thirdMax
"""

def third_max(nums):
    if len(nums) == 1:
        return nums[0]
    if len(nums) == 2:
        return max(nums[0], nums[1])
    
    max_val = None
    second_max = None
    third_max = None
    
    for num in nums:
        if num == max_val or num == second_max or num == third_max:
            continue
        
        if max_val is None or num > max_val:
            third_max = second_max  # n
            second_max = max_val    # -1
            max_val = num           # 1
        elif second_max is None or num > second_max:
            third_max = second_max
            second_max = num
        elif third_max is None or num > third_max:
            third_max = num
    
    if third_max is not None:
        return third_max
    return max_val


if __name__ == "__main__":
    nums = [-2147483648, -2147483648, -2147483648, -2147483648, 1, 1, 1]
    print(third_max(nums))
