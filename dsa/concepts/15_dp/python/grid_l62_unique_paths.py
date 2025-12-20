# Problem: https://leetcode.com/problems/unique-paths/
# Idea: As there are only 2 directions to move, you can reach any position from the top or left.
# So total ways to reach any position is ways to reach top + ways to reach left
#
# i\j	0	1	2	3
# 0	1	1	1	1
# 1	1	2	3	4
# 2	1	3	6	10
# 3	1	4	10	20
#
# The same problem can be solved as combinatotics problem.
# We have to m-1 down and n-1 right directions to reach target. Total will (m-1)+(n-1) = m+n-2.
# Out of these m+n-2 direction we need to choose either m-1 down direction or n-1 right directions.
# Hence, ans will be (m+n-2)C(m-1) or (m+n-2)C(n-1)
#
# Time: O(m*n)
# Space: O(m*n)


def uniquePaths2(i, j):
    if i == 0 and j == 0:
        return 1

    up = 0
    left = 0
    if i > 0:
        up = uniquePaths2(i - 1, j)
    if j > 0:
        left = uniquePaths2(i, j - 1)

    return up + left


def uniquePaths(m, n):
    dp = [[0] * n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            if i == 0 and j == 0:
                dp[i][j] = 1                            # base case
            else:
                up = 0
                left = 0
                if i > 0:
                    up = dp[i - 1][j]
                if j > 0:
                    left = dp[i][j - 1]
                dp[i][j] = up + left

    return dp[m - 1][n - 1]


# ---------------- Test (same as Java main) ----------------

matrix = [[0]*4 for _ in range(4)]
m = len(matrix)
n = len(matrix[0])

print(uniquePaths(m, n))
print(uniquePaths2(m - 1, n - 1))
