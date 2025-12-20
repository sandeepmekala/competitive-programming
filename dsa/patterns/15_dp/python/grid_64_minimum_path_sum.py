#  Problem: https://leetcode.com/problems/minimum-path-sum/
#  Idea: Use DP as the sum to current position can be defined as sum to previous positions and cost to travel to current position
	#
	#  i\j	0	1	2	3
	#  	0	1	4	9	17
	#  	1	5	6	7	14
	#  	2	9	9	9	12
	#
	#
	# Time: O(m*n)
    # Space: O(m*n)

INF = float("inf")


def minPathSum_recursive(grid, i, j):
    if i == 0 and j == 0:
        return grid[i][j]

    up = INF
    left = INF

    if i > 0:
        up = minPathSum_recursive(grid, i - 1, j)
    if j > 0:
        left = minPathSum_recursive(grid, i, j - 1)

    return grid[i][j] + min(up, left)


def minPathSum(grid):
    m = len(grid)
    n = len(grid[0])

    cost = [[0] * n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            if i == 0 and j == 0:
                cost[i][j] = grid[i][j]
            else:
                up = INF
                left = INF
                if i > 0:
                    up = cost[i - 1][j]
                if j > 0:
                    left = cost[i][j - 1]
                cost[i][j] = grid[i][j] + min(up, left)

    return cost[m - 1][n - 1]


# ---------------- Test (same as Java main) ----------------

grid = [
    [1, 3, 5, 8],
    [4, 2, 1, 7],
    [4, 3, 2, 3]
]

m = len(grid)
n = len(grid[0])

print(minPathSum_recursive(grid, m - 1, n - 1))
print(minPathSum(grid))
