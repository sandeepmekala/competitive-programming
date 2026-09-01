# Problem: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
# Idea: Run dfs from each cell in the direction of increasing path.
# Store the path lens in a lip matrix so that we don't have to compute dfs if it is already done.
# Path len for a cell is 1+max of all its neighbors. Find it and store it in lip while recursion exiting.


def longestIncreasingPath(matrix):
    globalMax = 0
    m = len(matrix)
    n = len(matrix[0])

    dp = [[0] * n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            maxLen = dfs(i, j, matrix, dp)
            if maxLen > globalMax:
                globalMax = maxLen

    return globalMax


def dfs(i, j, matrix, dp):
    if dp[i][j] != 0:
        return dp[i][j]

    maxLen = 0
    dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    for di, dj in dirs:
        ni = i + di
        nj = j + dj
        if isSafe(i, j, ni, nj, matrix):
            curr = dfs(ni, nj, matrix, dp)
            maxLen = max(maxLen, curr)

    dp[i][j] = 1 + maxLen
    return dp[i][j]


def isSafe(i, j, ni, nj, matrix):
    return (
        ni >= 0 and ni < len(matrix)
        and nj >= 0 and nj < len(matrix[0])
        and matrix[ni][nj] > matrix[i][j]
    )


# ---------------- Test (same as Java main) ----------------

matrix = [
    [3, 4, 5],
    [3, 2, 6],
    [2, 2, 1]
]

print(longestIncreasingPath(matrix))
