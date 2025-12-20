"""
L229 - Majority Element II

Problem: https://leetcode.com/problems/majority-element-ii/description/
Idea: Use Moore's Voting algorithm
"""

def majority_element(nums):
    el1 = float('-inf')
    el2 = float('-inf')
    cnt1 = 0
    cnt2 = 0
    n = len(nums)
    
    for num in nums:
        if num == el1:
            cnt1 += 1
        elif num == el2:
            cnt2 += 1
        elif cnt1 == 0:
            el1 = num
            cnt1 = 1
        elif cnt2 == 0:
            el2 = num
            cnt2 = 1
        else:
            cnt1 -= 1
            cnt2 -= 1
    
    cnt1 = 0
    cnt2 = 0
    for num in nums:
        if num == el1:
            cnt1 += 1
        if num == el2:
            cnt2 += 1
    
    ans = []
    if cnt1 > n // 3:
        ans.append(el1)
    if cnt2 > n // 3:
        ans.append(el2)
    
    return ans


if __name__ == "__main__":
    nums = [2, 1, 1, 3, 1, 4, 5, 6]
    print(majority_element(nums))
