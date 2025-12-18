"""
L152 - Maximum Product Subarray

Problem: https://leetcode.com/problems/maximum-product-subarray/
Idea: Track both max and min products as negative numbers can become positive
Time: O(n)
Space: O(1)
"""

def max_product(nums):
    max_prod = min_prod = result = nums[0]
    
    for i in range(1, len(nums)):
        if nums[i] < 0:
            max_prod, min_prod = min_prod, max_prod
        
        max_prod = max(nums[i], max_prod * nums[i])
        min_prod = min(nums[i], min_prod * nums[i])
        
        result = max(result, max_prod)
    
    return result


if __name__ == "__main__":
    test_cases = [
        [2, 3, -2, 4],
        [-2, 0, -1],
        [-2, 3, -4],
        [0, 2],
        [-3, -1, -1]
    ]
    
    for i, nums in enumerate(test_cases, 1):
        print(f"Test case {i}: {nums}")
        print(f"Maximum product: {max_product(nums)}")
        print()
