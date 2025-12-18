"""
Matrix L54 - Spiral Matrix

Problem: https://leetcode.com/problems/spiral-matrix/
Idea:
"""

def spiral_order(matrix):
    top = 0
    bottom = len(matrix) - 1
    left = 0
    right = len(matrix[0]) - 1
    ans = []
    
    while top <= bottom and left <= right:
        for i in range(left, right + 1):
            ans.append(matrix[top][i])
        top += 1
        
        for i in range(top, bottom + 1):
            ans.append(matrix[i][right])
        right -= 1
        
        if top <= bottom:  # go r -> l only if there is a row to process
            for i in range(right, left - 1, -1):
                ans.append(matrix[bottom][i])
            bottom -= 1
        
        if left <= right:  # go b -> t only if there is a row to process
            for i in range(bottom, top - 1, -1):
                ans.append(matrix[i][left])
            left += 1
    
    return ans


if __name__ == "__main__":
    print(spiral_order([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
