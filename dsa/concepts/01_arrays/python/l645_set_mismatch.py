"""
L645 - Set Mismatch

Problem: https://leetcode.com/problems/set-mismatch/
Idea: Place the nums at its index position
"""

def find_error_nums(nums):
    i = 0  # 0
    while i < len(nums):
        num_index = nums[i] - 1  # 1
        if nums[i] - 1 == i or nums[i] == nums[num_index]:
            i += 1
            continue
        
        temp = nums[num_index]
        nums[num_index] = nums[i]
        nums[i] = temp
    
    for i in range(len(nums)):
        if nums[i] != i + 1:
            return [nums[i], i + 1]
    
    return [-1, -1]


if __name__ == "__main__":
    nums = [4, 2, 1, 2]
    print(find_error_nums(nums))
