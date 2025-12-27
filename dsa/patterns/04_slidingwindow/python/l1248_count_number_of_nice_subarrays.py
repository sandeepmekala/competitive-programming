"""
L1248 - Count Number of Nice Subarrays

Problem: https://leetcode.com/problems/count-number-of-nice-subarrays/
Idea: It is same as binary subarrays with sum k as you can replace all odd numbers with 1 and even numbers with 0
Time: O(n)
Space: O(1)
"""

def number_of_subarrays(nums, k):
    return num_subarrays_with_sum_less_than_or_equal(nums, k) - \
           num_subarrays_with_sum_less_than_or_equal(nums, k - 1)


def num_subarrays_with_sum_less_than_or_equal(nums, k):
    if k < 0:
        return 0
    
    l, r, current_sum, cnt, n = 0, 0, 0, 0, len(nums)
    
    while r < n:
        current_sum += nums[r] % 2  # Count odd numbers as 1, even as 0
        
        while current_sum > k:
            current_sum -= nums[l] % 2
            l += 1
        
        if current_sum <= k:
            cnt += (r - l + 1)
        
        r += 1
    
    return cnt


if __name__ == "__main__":
    nums = [1, 1, 2, 1, 1]
    k = 3
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {number_of_subarrays(nums, k)}")
