"""
Problem:
https://leetcode.com/problems/max-area-of-island/

Idea:
- Same idea as Number of Islands
- Traverse the grid
- For each unvisited land cell, run DFS
- DFS returns area contributed by that island
- Track and return the maximum area

Time: O(m * n)
Space: O(m * n)
"""


def max_area_of_island(grid):
    m, n = len(grid), len(grid[0])
    visited = [[False] * n for _ in range(m)]
    max_area = 0

    for i in range(m):
        for j in range(n):
            if grid[i][j] == 1 and not visited[i][j]:
                area = dfs(grid, i, j, visited)
                max_area = max(max_area, area)

    return max_area


"""
DFS to calculate area of the current island
"""


def dfs(grid, i, j, visited):
    visited[i][j] = True
    area = 1

    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    for di, dj in directions:
        ni, nj = i + di, j + dj
        if is_safe(grid, ni, nj, visited):
            area += dfs(grid, ni, nj, visited)

    return area


"""
Check if cell is inside grid, unvisited and land
"""


def is_safe(grid, i, j, visited):
    m, n = len(grid), len(grid[0])
    return (
        0 <= i < m and
        0 <= j < n and
        grid[i][j] == 1 and
        not visited[i][j]
    )


# -------------------- TEST --------------------
if __name__ == "__main__":
    grid = [
        [0, 1],
        [1, 0],
        [1, 1],
        [1, 0]
    ]

    print(max_area_of_island(grid))
