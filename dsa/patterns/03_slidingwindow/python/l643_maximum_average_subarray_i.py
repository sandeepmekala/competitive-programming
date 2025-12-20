"""
L643 - Maximum Average Subarray I

Problem: https://leetcode.com/problems/maximum-average-subarray-i/
Idea: Track the fixed size sliding window of k. Calculate sum from it and avg. Track global max avg.
Time: O(n)
Space: O(1)
"""

def find_max_average(nums, k):
    current_sum = 0
    max_avg = float('-inf')
    l, r, n = 0, 0, len(nums)
    
    # Calculate sum of first k elements
    while r < k:
        current_sum += nums[r]
        r += 1
    
    max_avg = max(max_avg, current_sum / k)
    
    # Slide the window
    while r < n:
        current_sum = current_sum - nums[l] + nums[r]
        max_avg = max(max_avg, current_sum / k)
        l += 1
        r += 1
    
    return max_avg


if __name__ == "__main__":
    nums = [1, 12, -5, -6, 50, 3]
    k = 4
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {find_max_average(nums, k)}")
