"""
Problem:
https://leetcode.com/problems/island-perimeter/

Idea:
- Adjacent water or boundary contributes 1 to perimeter
- Start DFS from the first land cell found
- If DFS goes out of bounds or hits water, return 1
- Use visited matrix to avoid double counting
- Sum perimeter contributions from all 4 directions

Time: O(m * n)
Space: O(m * n)
"""


def island_perimeter(grid):
    m, n = len(grid), len(grid[0])
    visited = [[False] * n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            if grid[i][j] == 1:
                return dfs(grid, i, j, visited)

    return 0


"""
DFS to calculate perimeter contribution
"""


def dfs(grid, i, j, visited):
    if not is_safe(grid, i, j):
        return 1

    if visited[i][j]:
        return 0

    visited[i][j] = True
    perimeter = 0

    perimeter += dfs(grid, i + 1, j, visited)
    perimeter += dfs(grid, i - 1, j, visited)
    perimeter += dfs(grid, i, j + 1, visited)
    perimeter += dfs(grid, i, j - 1, visited)

    return perimeter


"""
Check if cell is inside grid and is land
"""


def is_safe(grid, i, j):
    m, n = len(grid), len(grid[0])
    return 0 <= i < m and 0 <= j < n and grid[i][j] == 1


# -------------------- TEST --------------------
if __name__ == "__main__":
    grid = [
        [0, 1, 0, 0],
        [1, 1, 1, 0],
        [0, 1, 0, 0],
        [1, 1, 0, 0]
    ]

    print(island_perimeter(grid))
