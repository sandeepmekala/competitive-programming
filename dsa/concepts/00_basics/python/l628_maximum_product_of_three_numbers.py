"""
L628 - Maximum Product of Three Numbers

Problem: https://leetcode.com/problems/maximum-product-of-three-numbers/
Idea: Find max1,2,3 and min1,2 and calculate product.
The maximum product can be either:
1. Product of three largest numbers
2. Product of two smallest (most negative) and largest number
Time complexity: O(n)
Space complexity: O(1)
"""

def maximum_product(nums):
    max1 = max2 = max3 = float('-inf')
    min1 = min2 = float('inf')
    
    for num in nums:
        # Update maximum values
        if num > max1:
            max3 = max2
            max2 = max1
            max1 = num
        elif num > max2:
            max3 = max2
            max2 = num
        elif num > max3:
            max3 = num
        
        # Update minimum values
        if num < min1:
            min2 = min1
            min1 = num
        elif num < min2:
            min2 = num
    
    # Return maximum of two possible products
    return max(max1 * max2 * max3, max1 * min1 * min2)


if __name__ == "__main__":
    nums1 = [1, 2, 3, 4]
    print(f"Input: {nums1}")
    print(f"Maximum product: {maximum_product(nums1)}")
    
    nums2 = [-4, -3, -2, -1, 60]
    print(f"\nInput: {nums2}")
    print(f"Maximum product: {maximum_product(nums2)}")
    
    nums3 = [-1, -2, -3, 4]
    print(f"\nInput: {nums3}")
    print(f"Maximum product: {maximum_product(nums3)}")
