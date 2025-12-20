# Problem: https://leetcode.com/problems/unique-paths-ii/
# Companies: Amazon
# Idea: Same as unique paths. If the cell has obstacle, just assign its ways as 0 so that for subsequent cells that path won't be considered.
#
# Time: O(m*n)
# Space: O(m*n)


def uniquePathsWithObstacles(obstacleGrid):
    m = len(obstacleGrid)
    n = len(obstacleGrid[0])

    ways = [[0] * n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            if obstacleGrid[i][j] == 1:
                ways[i][j] = 0
            elif i == 0 and j == 0:
                ways[i][j] = 1                           # base case
            else:
                up = 0
                left = 0
                if i > 0:
                    up = ways[i - 1][j]
                if j > 0:
                    left = ways[i][j - 1]
                ways[i][j] = up + left

    return ways[m - 1][n - 1]


def uniquePathsWithObstacles_recursive(i, j, obstacleGrid):
    if i == 0 and j == 0:
        return 1
    if obstacleGrid[i][j] == 1:
        return 0

    up = 0
    left = 0
    if i > 0:
        up = uniquePathsWithObstacles_recursive(i - 1, j, obstacleGrid)
    if j > 0:
        left = uniquePathsWithObstacles_recursive(i, j - 1, obstacleGrid)

    return up + left


# ---------------- Test (same as Java main) ----------------

obstacleGrid = [
    [0, 0, 0],
    [0, 1, 0],
    [0, 0, 0]
]

print(uniquePathsWithObstacles(obstacleGrid))

m = len(obstacleGrid)
n = len(obstacleGrid[0])
print(uniquePathsWithObstacles_recursive(m - 1, n - 1, obstacleGrid))
