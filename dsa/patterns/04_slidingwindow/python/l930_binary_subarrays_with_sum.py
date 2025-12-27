"""
L930 - Binary Subarrays With Sum

Problem: https://leetcode.com/problems/binary-subarrays-with-sum/
Idea: numSubarraysWithSum(nums, goal) = numSubarraysWithSumLessThenOrEqual(nums, goal) - numSubarraysWithSumLessThenOrEqual(nums, goal-1)
Time: O(n)
Space: O(1)
"""

def num_subarrays_with_sum(nums, goal):
    return num_subarrays_with_sum_less_than_or_equal(nums, goal) - \
           num_subarrays_with_sum_less_than_or_equal(nums, goal - 1)


def num_subarrays_with_sum_less_than_or_equal(nums, goal):
    if goal < 0:
        return 0
    
    l, r, current_sum, cnt, n = 0, 0, 0, 0, len(nums)
    
    while r < n:
        current_sum += nums[r]
        
        while current_sum > goal:
            current_sum -= nums[l]
            l += 1
        
        if current_sum <= goal:
            cnt += (r - l + 1)
        
        r += 1
    
    return cnt


if __name__ == "__main__":
    nums = [1, 0, 1, 0, 1]
    goal = 2
    print(f"Input: nums = {nums}, goal = {goal}")
    print(f"Output: {num_subarrays_with_sum(nums, goal)}")
