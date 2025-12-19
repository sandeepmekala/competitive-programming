"""
L992 - Subarrays with K Different Integers

Problem: https://leetcode.com/problems/subarrays-with-k-different-integers/
Idea: subarraysWithKDistinct(nums, k) = subarraysWithLessThenOrEqualToKDistinct(nums, k) - subarraysWithLessThenOrEqualToKDistinct(nums, k-1)
Time: O(n)
Space: O(k)
"""

def subarrays_with_k_distinct(nums, k):
    return subarrays_with_less_than_or_equal_to_k_distinct(nums, k) - \
           subarrays_with_less_than_or_equal_to_k_distinct(nums, k - 1)


def subarrays_with_less_than_or_equal_to_k_distinct(nums, k):
    l, r, cnt, n = 0, 0, 0, len(nums)
    num_map = {}
    
    while r < n:
        num_map[nums[r]] = num_map.get(nums[r], 0) + 1
        
        while len(num_map) > k:
            num_map[nums[l]] = num_map[nums[l]] - 1
            if num_map[nums[l]] == 0:
                del num_map[nums[l]]
            l += 1
        
        if len(num_map) <= k:
            cnt += (r - l + 1)
        
        r += 1
    
    return cnt


if __name__ == "__main__":
    nums = [1, 2, 1, 2, 3]
    k = 2
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {subarrays_with_k_distinct(nums, k)}")
