"""
Problem: https://leetcode.com/problems/number-of-enclaves/

Idea:
- Any land cell (1) connected to the boundary cannot be an enclave
- Run DFS from all boundary land cells and mark them as visited
- Finally count all land cells which are NOT visited
- Those are enclaves

Time: O(m * n)
Space: O(m * n)
"""


def num_enclaves(grid):
    m, n = len(grid), len(grid[0])
    visited = [[0] * n for _ in range(m)]

    # Run DFS from all boundary cells
    for i in range(m):
        for j in range(n):
            if i == 0 or j == 0 or i == m - 1 or j == n - 1:
                if grid[i][j] == 1 and visited[i][j] == 0:
                    dfs(grid, i, j, visited)

    # Count remaining unvisited land cells
    count = 0
    for i in range(m):
        for j in range(n):
            if grid[i][j] == 1 and visited[i][j] == 0:
                count += 1

    return count


def dfs(grid, row, col, visited):
    if not is_safe(grid, row, col, visited):
        return

    visited[row][col] = 1

    dfs(grid, row + 1, col, visited)
    dfs(grid, row - 1, col, visited)
    dfs(grid, row, col + 1, visited)
    dfs(grid, row, col - 1, visited)


def is_safe(grid, row, col, visited):
    m, n = len(grid), len(grid[0])
    return (
        0 <= row < m and
        0 <= col < n and
        grid[row][col] == 1 and
        visited[row][col] == 0
    )


# -------------------- TEST --------------------
if __name__ == "__main__":
    grid = [
        [0, 0, 0, 0],
        [1, 0, 1, 0],
        [0, 1, 1, 0],
        [0, 0, 0, 0]
    ]

    print(num_enclaves(grid))
