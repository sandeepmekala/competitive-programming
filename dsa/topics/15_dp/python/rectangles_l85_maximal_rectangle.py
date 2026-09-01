# Stack / Histogram
#
# Problem: https://leetcode.com/problems/maximal-rectangle/
# Idea: Use max rectangle area in histogram logic to find the max area of 1's
# For the subsequence of rows, cumulatively add rows so that we get bigger
# histograms by consecutive 1's in each column
# Time = O(rows * cols)
# Space = O(cols)

def maximalRectangle(matrix):
    m = len(matrix)
    n = len(matrix[0])

    maximum = float('-inf')
    histogram = [0] * n

    for i in range(m):
        for j in range(n):
            if matrix[i][j] == '1':
                histogram[j] += 1
            else:
                histogram[j] = 0

        area = maxArea(histogram)
        maximum = max(maximum, area)

    return maximum


def maxArea(heights):
    n = len(heights)
    maxArea = 0
    stack = []

    for i in range(n + 1):
        while stack and (i == n or heights[stack[-1]] >= heights[i]):
            top = stack.pop()
            if stack:
                area = heights[top] * (i - stack[-1] - 1)
            else:
                area = heights[top] * i

            maxArea = max(maxArea, area)

        stack.append(i)

    return maxArea


# -------- Test --------
matrix = [
    ['1','0','0','1','1','1'],
    ['1','0','1','1','0','1'],
    ['0','1','1','1','1','1'],
    ['0','0','1','1','1','1']
]

print(maximalRectangle(matrix))  # Expected: 8
