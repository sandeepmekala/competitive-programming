# L73 - Set Matrix Zeroes
#
# Problem: https://leetcode.com/problems/set-matrix-zeroes/
# If you find 0 in any cell mark that row and col as 0.
# Idea: Use first row and first column as markers.
# Time: O(m * n)
# Space: O(1)


def set_zeroes(matrix):
    m, n = len(matrix), len(matrix[0])
    conv_col, conv_row = False, False

    for r in range(m):
        for c in range(n):
            if (matrix[r][c] == 0):
                if r == 0:
                    conv_row = True
                if c == 0:
                    conv_col = True
                matrix[r][0] = 0
                matrix[0][c] = 0

    for r in range(1, m):
        for c in range(1, n):
            if matrix[r][0] == 0 or matrix[0][c] == 0:
                matrix[r][c] = 0
    if (conv_row):
        for c in range(n):
            matrix[0][c] = 0
    if (conv_col):
        for r in range(m):
            matrix[r][0] = 0


# -------------------- TEST --------------------
if __name__ == "__main__":
    matrix = [
        [1, 1, 1],
        [1, 0, 1],
        [1, 1, 1]
    ]

    set_zeroes(matrix)
    for row in matrix:
        print(row)
