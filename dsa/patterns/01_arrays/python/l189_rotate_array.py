"""
L189 - Rotate Array

Problem: https://leetcode.com/problems/rotate-array/
Idea: Reverse entire array, then reverse first k elements, then reverse remaining
Time: O(n)
Space: O(1)
"""

def rotate(nums, k):
    n = len(nums)
    k = k % n  # Handle k > n
    
    # Reverse entire array
    reverse(nums, 0, n - 1)
    # Reverse first k elements
    reverse(nums, 0, k - 1)
    # Reverse remaining elements
    reverse(nums, k, n - 1)


def reverse(nums, start, end):
    while start < end:
        nums[start], nums[end] = nums[end], nums[start]
        start += 1
        end -= 1


if __name__ == "__main__":
    nums = [1, 2, 3, 4, 5, 6, 7]
    k = 3
    print(f"Original: {nums}")
    rotate(nums, k)
    print(f"After rotating by {k}: {nums}")
