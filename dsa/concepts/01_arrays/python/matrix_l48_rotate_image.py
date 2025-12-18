"""
Matrix L48 - Rotate Image

Problem: https://leetcode.com/problems/rotate-image/
Idea: Transpose matrix then reverse each row
Time: O(n^2)
Space: O(1)
"""

def rotate(matrix):
    n = len(matrix)
    
    # Transpose the matrix
    for i in range(n):
        for j in range(i, n):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    
    # Reverse each row
    for i in range(n):
        matrix[i].reverse()


if __name__ == "__main__":
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    
    print("Original matrix:")
    for row in matrix:
        print(row)
    
    rotate(matrix)
    
    print("\nRotated matrix:")
    for row in matrix:
        print(row)
