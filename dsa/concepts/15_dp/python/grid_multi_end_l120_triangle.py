# Problem: https://leetcode.com/problems/triangle/
# Idea: As the target is anything in last row, we can't start recursion from end. Hence, we start recursions from fixed start point.
# Time: O(m*n)
# Space: O(m*n)
def minimumTotal_recursive(triangle, i, j, m):
    if i == m - 1:
        return triangle[i][j]

    down = triangle[i][j] + minimumTotal_recursive(triangle, i + 1, j, m)
    diagonal = triangle[i][j] + minimumTotal_recursive(triangle, i + 1, j + 1, m)

    return min(down, diagonal)


def minimumTotal(triangle):
    m = len(triangle)

    cost = [[0] * m for _ in range(m)]

    for j in range(m - 1, -1, -1):
        cost[m - 1][j] = triangle[m - 1][j]

    for i in range(m - 2, -1, -1):
        for j in range(i, -1, -1):
            down = triangle[i][j] + cost[i + 1][j]
            diagonal = triangle[i][j] + cost[i + 1][j + 1]
            cost[i][j] = min(down, diagonal)

    return cost[0][0]


# ---------------- Test (same as Java main) ----------------

triangle = [
    [2],
    [3, 4],
    [6, 5, 7],
    [4, 1, 8, 3]
]

print(minimumTotal(triangle))

m = len(triangle)
print(minimumTotal_recursive(triangle, 0, 0, m))
