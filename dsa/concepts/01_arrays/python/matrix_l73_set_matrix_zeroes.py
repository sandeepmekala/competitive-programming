"""
Matrix L73 - Set Matrix Zeroes

Problem: https://leetcode.com/problems/set-matrix-zeroes/
If you find 0 in any cell mark that row and col as 0.
Idea: Mark in first row and col of you see any 0's.
"""

def set_zeroes(matrix):
    first_row_0 = False
    first_col_0 = False
    m = len(matrix)
    n = len(matrix[0])
    
    for i in range(m):
        for j in range(n):
            if matrix[i][j] == 0:
                if i == 0:
                    first_row_0 = True
                if j == 0:
                    first_col_0 = True
                
                matrix[0][j] = 0
                matrix[i][0] = 0
    
    for i in range(m - 1, -1, -1):
        for j in range(n - 1, -1, -1):
            if i == 0:
                if first_row_0:
                    matrix[0][j] = 0
            elif j == 0:
                if first_col_0:
                    matrix[i][0] = 0
            elif matrix[i][0] == 0 or matrix[0][j] == 0:
                matrix[i][j] = 0


if __name__ == "__main__":
    matrix = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
    set_zeroes(matrix)
    for row in matrix:
        print(row)
