"""
PrefixSum L325 - Maximum Size Subarray Sum Equals K

Problem: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
Idea: Prefix Sum
Time: O(n), Space: O(n)
"""

def max_sub_array_len(nums, k):
    """
    Approach 1: Using HashMap for prefix sum
    Works for negative numbers too
    """
    map_sum = {0: -1}  # sum -> index
    # if first k elements sum to k, then k-1 - (-1) = k
    max_len = 0
    total_sum = 0
    
    for i in range(len(nums)):
        total_sum += nums[i]
        rem = total_sum - k
        if rem in map_sum:
            length = i - map_sum[rem]
            max_len = max(max_len, length)
        
        if total_sum not in map_sum:
            map_sum[total_sum] = i
    
    return max_len


def max_sub_array_len2(nums, k):
    """
    Approach 2: Two pointers
    Doesn't work for negative numbers
    Time: O(n), Space: O(1)
    """
    n = len(nums)
    l = 0
    r = 0
    total_sum = 0
    max_len = 0
    
    while r < n:
        total_sum += nums[r]
        while total_sum > k:
            total_sum -= nums[l]
            l += 1
        
        if total_sum == k:
            max_len = max(max_len, r - l + 1)
        
        r += 1
    
    return max_len


if __name__ == "__main__":
    arr = [1, -1, 5, -2, 3]
    k = 3
    print(max_sub_array_len(arr, k))
    
    arr2 = [1, 2, 3, 1, 1, 1, 1, 0, 3, 3]
    k2 = 6
    print(max_sub_array_len2(arr2, k2))
