"""
Problem: https://leetcode.com/problems/next-greater-element-i/
Idea:
Move from right to left and maintain a monotonically decreasing stack.
For each element, pop smaller or equal elements from the stack.
The top of the stack (if any) will be the next greater element.
Store results in a map for quick lookup.
"""

def next_greater_element(nums1, nums2):
    stack = []
    next_greater = {}

    # Build next greater mapping for nums2
    for num in reversed(nums2):
        while stack and stack[-1] <= num:
            stack.pop()

        next_greater[num] = stack[-1] if stack else -1
        stack.append(num)

    # Build result for nums1 using the map
    return [next_greater[num] for num in nums1]


# Example usage
if __name__ == "__main__":
    nums1 = [4, 1, 2]
    nums2 = [1, 3, 4, 2]
    print(next_greater_element(nums1, nums2))  # [-1, 3, -1]
