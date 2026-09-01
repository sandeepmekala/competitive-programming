# Problem: https://leetcode.com/problems/minimum-falling-path-sum/
# Idea: Same as triangle problem, but there can be multiple source. Hence, we need to start recursion from each column and take max of all the col maxes.
# Time: O(m*n)
# Space: O(m*n)
def minFallingPathSum(matrix):
    m, n = len(matrix), len(matrix[0])

    cost = [[0] * n for _ in range(m)]

    for j in range(n):
        cost[0][j] = matrix[0][j]  # i=0

    for i in range(1, m):
        for j in range(n):
            l = matrix[i][j] + cost[i - 1][j]
            ld = matrix[i][j] + cost[i - 1][j - 1] if j - 1 >= 0 else int(1e9)
            rd = matrix[i][j] + cost[i - 1][j + 1] if j + 1 < n else int(1e9)

            cost[i][j] = min(l, ld, rd)

    ans = int(1e9)
    for j in range(n):
        ans = min(ans, cost[m - 1][j])

    return ans


def minFallingPathSum2(matrix):
    m = len(matrix)
    ans = int(1e8)

    for j in range(len(matrix[0])):
        ans = min(ans, minFallingPathSum_recursive(matrix, m - 1, j))

    return ans


def minFallingPathSum_recursive(matrix, i, j):
    if j < 0 or j >= len(matrix[0]):
        return int(1e8)
    if i == 0:
        return matrix[i][j]

    l = matrix[i][j] + minFallingPathSum_recursive(matrix, i - 1, j)
    ld = matrix[i][j] + minFallingPathSum_recursive(matrix, i - 1, j - 1)
    rd = matrix[i][j] + minFallingPathSum_recursive(matrix, i - 1, j + 1)

    return min(l, ld, rd)


# ---------------- Test (same as Java main) ----------------

matrix = [
    [2, 1, 3],
    [6, 5, 4],
    [7, 8, 9]
]

print(minFallingPathSum(matrix))
print(minFallingPathSum2(matrix))
