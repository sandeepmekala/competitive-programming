"""
PrefixSum L560 - Subarray Sum Equals K

Problem: https://leetcode.com/problems/subarray-sum-equals-k/
Idea: Use prefix sum with hashmap to track cumulative sums
Time: O(n)
Space: O(n)
"""

def subarray_sum(nums, k):
    count = 0
    prefix_sum = 0
    sum_count = {0: 1}  # Initialize with 0 sum having count 1
    
    for num in nums:
        prefix_sum += num
        
        # Check if (prefix_sum - k) exists in map
        if prefix_sum - k in sum_count:
            count += sum_count[prefix_sum - k]
        
        # Add current prefix_sum to map
        sum_count[prefix_sum] = sum_count.get(prefix_sum, 0) + 1
    
    return count


if __name__ == "__main__":
    test_cases = [
        ([1, 1, 1], 2),
        ([1, 2, 3], 3),
        ([1, -1, 0], 0),
        ([1, 2, 1, 2, 1], 3)
    ]
    
    for i, (nums, k) in enumerate(test_cases, 1):
        print(f"Test case {i}: nums = {nums}, k = {k}")
        print(f"Number of subarrays: {subarray_sum(nums, k)}")
        print()
