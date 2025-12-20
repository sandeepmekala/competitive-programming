"""
Problem: https://leetcode.com/problems/next-greater-element-ii/
Idea:
Same as Next Greater Element.
To handle the circular case, iterate the array twice (virtual duplication).
Use a monotonic decreasing stack.
"""

def next_greater_elements(nums):
    n = len(nums)
    nge = [-1] * n
    stack = []

    # Traverse twice to simulate circular array
    for i in range(2 * n - 1, -1, -1):
        curr = nums[i % n]

        while stack and stack[-1] <= curr:
            stack.pop()

        if i < n:
            nge[i] = stack[-1] if stack else -1

        stack.append(curr)

    return nge


# Example usage
if __name__ == "__main__":
    nums = [1, 2, 3, 4, 3]
    print(next_greater_elements(nums))  # [2, 3, 4, -1, 4]
