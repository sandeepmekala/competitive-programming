"""
Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/

Idea 1:
Find the left and right smaller elements for each index.
For each bar, calculate area as:
(height[i]) * (rightSmall[i] - leftSmall[i] + 1)

leftSmall  = index of previous smaller + 1
rightSmall = index of next smaller - 1
"""

def largest_rectangle_area(heights):
    n = len(heights)
    stack = []
    left_small = [0] * n
    right_small = [0] * n

    # Find left smaller
    for i in range(n):
        while stack and heights[stack[-1]] >= heights[i]:
            stack.pop()

        left_small[i] = stack[-1] + 1 if stack else 0
        stack.append(i)

    stack.clear()

    # Find right smaller
    for i in range(n - 1, -1, -1):
        while stack and heights[stack[-1]] >= heights[i]:
            stack.pop()

        right_small[i] = stack[-1] - 1 if stack else n - 1
        stack.append(i)

    max_area = 0
    for i in range(n):
        max_area = max(max_area,
                       heights[i] * (right_small[i] - left_small[i] + 1))

    return max_area
