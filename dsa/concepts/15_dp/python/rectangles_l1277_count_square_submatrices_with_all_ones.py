# DP / Matrix
#
# Problem: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
# Idea: We store the count of squares in each cell and sum them up.
# We take the min of all the 3 surrounding cells and add one.
# This boosts the count if all the 3 cells are 1's.
# Similarly, if all the 3 cells are 2 it boosts it to 3.

def countSquares(matrix):
    m = len(matrix)
    n = len(matrix[0])

    count = [[0] * n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            if matrix[i][j] == 1:
                if i == 0 or j == 0:
                    count[i][j] = 1
                else:
                    count[i][j] = 1 + min(
                        count[i - 1][j - 1],
                        count[i - 1][j],
                        count[i][j - 1]
                    )

    total = 0
    for i in range(m):
        for j in range(n):
            total += count[i][j]

    return total


# -------- Test --------
matrix = [
    [1, 0, 1],
    [1, 1, 0],
    [1, 1, 0]
]

print(countSquares(matrix))  # Expected: 7
