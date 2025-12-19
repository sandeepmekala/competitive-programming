"""
L18 - Four Sum
Problem: https://leetcode.com/problems/4sum/
Idea: Sort the nums to eliminate the duplicates
Time: O(n^3)
Space: O(1) excluding the result array
"""

def four_sum(nums, target):
    """
    Find all unique quadruplets in the array that sum to target.
    
    Args:
        nums: List[int] - Array of integers
        target: int - Target sum
    
    Returns:
        List[List[int]] - List of unique quadruplets that sum to target
    """
    n = len(nums)
    ans = []
    if n < 4:
        return ans
    
    nums.sort()
    for i in range(n - 3):
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        
        for j in range(i + 1, n - 2):
            if j > i + 1 and nums[j] == nums[j - 1]:
                continue
            
            two_sum_target = target - (nums[i] + nums[j])
            l, r = j + 1, n - 1
            while l < r:
                two_sum = nums[l] + nums[r]
                if two_sum == two_sum_target:
                    ans.append([nums[i], nums[j], nums[l], nums[r]])
                    l += 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
                elif two_sum > two_sum_target:
                    r -= 1
                else:
                    l += 1
    
    return ans


if __name__ == "__main__":
    nums = [1, 0, -1, 0, -2, 2]
    target = 0
    result = four_sum(nums, target)
    print(result)  # Expected: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
