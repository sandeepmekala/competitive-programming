# L48 - Rotate Image
#
# Problem: https://leetcode.com/problems/rotate-image/
# Idea: Transpose the matrix, then reverse each row
# Time: O(n^2)
# Space: O(1)


def rotate(matrix):
    n = len(matrix)

    # Transpose
    for r in range(n):
        for c in range(r):
            matrix[r][c], matrix[c][r] = matrix[c][r], matrix[r][c]
    # Reverse Rows
    for row in matrix:
        row.reverse()


# -------------------- TEST --------------------
if __name__ == "__main__":
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]

    rotate(matrix)
    for row in matrix:
        print(row)
