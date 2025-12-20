"""
L238 - Product of Array Except Self

Problem: https://leetcode.com/problems/product-of-array-except-self/
Idea: Track prefix and suffix products. Result is prefix prod * suffix prod.
Time: O(n)
Space: O(1) - excluding the output array
"""

def product_except_self(nums):
    n = len(nums)
    result = [0] * n
    
    # First pass: Calculate prefix products
    prefix_prod = 1
    for i in range(n):
        result[i] = prefix_prod
        prefix_prod *= nums[i]
    
    # Second pass: Calculate suffix products and multiply with prefix
    suffix_prod = 1
    for i in range(n - 1, -1, -1):
        result[i] *= suffix_prod
        suffix_prod *= nums[i]
    
    return result


if __name__ == "__main__":
    test_array = [1, 2, 3, 4]
    print(f"Input: {test_array}")
    print(f"Product except self: {product_except_self(test_array)}")
    
    test_cases = [
        [-1, 1, 0, -3, 3],
        [2, 3, 4, 5],
        [-1, -2, -3]
    ]
    
    for i, test in enumerate(test_cases, 1):
        print(f"\nTest case {i}: {test}")
        result = product_except_self(test)
        print(f"Result: {result}")
