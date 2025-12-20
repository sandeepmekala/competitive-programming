# Problem: https://leetcode.com/problems/cherry-pickup-ii/
# Idea: Idea is same like fixed start to variable ends. But there are 2 fixed positions and when they overlap, those cells should be counted only once.
# Hence, we run both robots in the same recursion to eliminate the cases of overlapping. This leads to 3D dp.
# Time: O(m*n*n*9)
# Space: O(m*n*n)
def cherryPickup(grid):
    m, n = len(grid), len(grid[0])

    cost = [[[0] * n for _ in range(n)] for _ in range(m)]

    for j1 in range(n):
        for j2 in range(n):
            if j1 == j2:
                cost[m - 1][j1][j2] = grid[m - 1][j1]      # i=m-1
            else:
                cost[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2]

    for i in range(m - 2, -1, -1):
        for j1 in range(n):
            for j2 in range(n):
                maxVal = int(-1e8)
                for dj1 in range(-1, 2):
                    for dj2 in range(-1, 2):
                        value = 0
                        if j1 == j2:
                            value = grid[i][j1]
                        else:
                            value = grid[i][j1] + grid[i][j2]

                        nj1, nj2 = j1 + dj1, j2 + dj2
                        if 0 <= nj1 < n and 0 <= nj2 < n:
                            value += cost[i + 1][nj1][nj2]
                        else:
                            value += int(-1e8)

                        maxVal = max(maxVal, value)

                cost[i][j1][j2] = maxVal

    return cost[0][0][n - 1]


def cherryPickup2(grid):
    m, n = len(grid), len(grid[0])
    return cherryPickup2_dfs(grid, 0, 0, n - 1, m, n)


def cherryPickup2_dfs(grid, i, j1, j2, m, n):
    if j1 < 0 or j2 < 0 or j1 >= n or j2 >= n:
        return int(-1e8)

    if i == m - 1:
        if j1 == j2:
            return grid[m - 1][j1]
        else:
            return grid[m - 1][j1] + grid[m - 1][j2]

    maxVal = int(-1e8)
    for dj1 in range(-1, 2):
        for dj2 in range(-1, 2):
            if j1 == j2:
                value = grid[i][j1]
            else:
                value = grid[i][j1] + grid[i][j2]

            value += cherryPickup2_dfs(grid, i + 1, j1 + dj1, j2 + dj2, m, n)
            maxVal = max(maxVal, value)

    return maxVal


# ---------------- Test (same as Java main) ----------------

grid = [
    [3, 1, 1],
    [2, 5, 1],
    [1, 5, 5],
    [2, 1, 1]
]

print(cherryPickup(grid))
print(cherryPickup2(grid))
