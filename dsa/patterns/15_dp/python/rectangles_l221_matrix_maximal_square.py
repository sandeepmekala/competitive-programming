# DP / Matrix
#
# Problem: https://leetcode.com/problems/maximal-square/
# Idea: We store the count of squares in each cell and track the maximum.
# We take the min of all the 3 surrounding cells and add one.
# This boosts the count if all the 3 cells are 1's.
# Similarly, if all the 3 cells are 2 it boosts it to 3.
#
#  0  0  0  0  0  0
#  0  0  0  1  1  1
#  0  1  0  1  2  2
#  0  0  1  1  2  3
#  0  1  0  1  2  3
#

def maximalSquare(matrix):
    m = len(matrix)
    n = len(matrix[0])

    maximum = 0
    count = [[0] * (n + 1) for _ in range(m + 1)]

    for i in range(m):
        for j in range(n):
            if matrix[i][j] == '1':
                if i == 0 or j == 0:          # [0][0] boundary positions
                    count[i][j] = 1
                else:
                    count[i][j] = 1 + min(
                        count[i - 1][j - 1],
                        count[i][j - 1],
                        count[i - 1][j]
                    )

                if count[i][j] > maximum:
                    maximum = count[i][j]

    return maximum * maximum


# -------- Test --------
matrix = [
    ['1','0','1','0','0'],
    ['1','0','1','1','1'],
    ['1','1','1','1','1'],
    ['1','0','1','1','1']
]

print(maximalSquare(matrix))  # Expected: 9
