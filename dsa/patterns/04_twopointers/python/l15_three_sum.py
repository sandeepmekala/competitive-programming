"""
L15 - Three Sum
Problem: https://leetcode.com/problems/3sum/
Idea: Sort the nums to eliminate the duplicates
Time: O(n^2)
Space: O(1) excluding the result array
"""

def three_sum(nums):
    """
    Find all unique triplets in the array that sum to zero.
    
    Args:
        nums: List[int] - Array of integers
    
    Returns:
        List[List[int]] - List of unique triplets that sum to zero
    """
    n = len(nums)
    ans = []
    if n < 3:
        return ans
    
    nums.sort()
    for i in range(n - 2):
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        
        l, r = i + 1, n - 1
        while l < r:
            total = nums[i] + nums[l] + nums[r]
            if total < 0:
                l += 1
            elif total > 0:
                r -= 1
            else:
                ans.append([nums[i], nums[l], nums[r]])
                l += 1
                r -= 1
                while l < r and nums[l] == nums[l - 1]:
                    l += 1  # skip duplicates
                while l < r and nums[r] == nums[r + 1]:
                    r -= 1
    
    return ans


if __name__ == "__main__":
    nums = [-2, 0, 0, 2, 2]
    result = three_sum(nums)
    print(result)  # Expected: [[-2, 0, 2]]
