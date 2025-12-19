"""
L1004 - Max Consecutive Ones III

Problem: https://leetcode.com/problems/max-consecutive-ones-iii/
Idea: This can be reframed as find the longest subarray with at most k zeros
Time: O(n)
Space: O(1)
"""

def longest_ones(nums, k):
    l, r, n, max_len, zeros = 0, 0, len(nums), 0, 0
    
    while r < n:
        if nums[r] == 0:
            zeros += 1
        
        if zeros > k:
            if nums[l] == 0:
                zeros -= 1
            l += 1
        
        if zeros <= k:
            max_len = max(max_len, r - l + 1)
        
        r += 1
    
    return max_len


if __name__ == "__main__":
    nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
    k = 2
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {longest_ones(nums, k)}")
