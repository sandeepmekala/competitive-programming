"""
L31 - Next Permutation

Problem: https://leetcode.com/problems/next-permutation/
Idea: Find rightmost ascending pair, swap with next larger element, reverse suffix
Time: O(n)
Space: O(1)
"""

def next_permutation(nums):
    # Find the rightmost character that is smaller than its next character
    i = len(nums) - 2
    while i >= 0 and nums[i] >= nums[i + 1]:
        i -= 1
    
    if i >= 0:  # If such character exists
        # Find the smallest character on right side of above character that is greater than above character
        j = len(nums) - 1
        while nums[j] <= nums[i]:
            j -= 1
        
        # Swap the found characters
        nums[i], nums[j] = nums[j], nums[i]
    
    # Reverse the suffix starting at i+1
    nums[i + 1:] = reversed(nums[i + 1:])


if __name__ == "__main__":
    test_cases = [
        [1, 2, 3],
        [3, 2, 1],
        [1, 1, 5],
        [1, 3, 2],
        [2, 3, 1]
    ]
    
    for nums in test_cases:
        original = nums.copy()
        next_permutation(nums)
        print(f"{original} -> {nums}")
