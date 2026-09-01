"""
L448 - Find All Numbers Disappeared in an Array

Problem: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
Idea: Just put the number in its index place
"""

def find_disappeared_numbers(nums):
    i = 0
    while i < len(nums):
        if i + 1 == nums[i] or nums[i] == nums[nums[i] - 1]:  # just skip if the number is already in its correct
                                                              # position or both the exchanging numbers are same
            i += 1
        else:
            ind = nums[i] - 1
            
            temp = nums[i]
            nums[i] = nums[ind]
            nums[ind] = temp
    
    result_list = []
    for j in range(len(nums)):
        if j + 1 != nums[j]:
            result_list.append(j + 1)
    
    return result_list


if __name__ == "__main__":
    nums = [4, 3, 2, 7, 8, 2, 3, 1]
    print(find_disappeared_numbers(nums))
