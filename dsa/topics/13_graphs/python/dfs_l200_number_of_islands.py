"""
Problem:
https://leetcode.com/problems/number-of-islands/

Idea:
- Traverse the grid
- When an unvisited land cell ('1') is found, start DFS/BFS
- DFS/BFS will explore the entire island and mark it visited
- Each DFS/BFS call represents one island

Time: O(m * n)
Space: O(m * n)
"""


def num_islands(grid):
    if not grid or not grid[0]:
        return 0

    n, m = len(grid), len(grid[0])
    vis = [[0] * m for _ in range(n)]
    count = 0

    for i in range(n):
        for j in range(m):
            if grid[i][j] == '1' and vis[i][j] == 0:
                dfs(grid, i, j, vis)
                count += 1

    return count


"""
DFS to explore the entire island
"""


def dfs(grid, i, j, vis):
    vis[i][j] = 1

    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    for di, dj in directions:
        ni, nj = i + di, j + dj
        if is_safe_dfs(grid, ni, nj, vis):
            dfs(grid, ni, nj, vis)


"""
Check if the next cell is valid for DFS
"""


def is_safe_dfs(grid, i, j, vis):
    n, m = len(grid), len(grid[0])
    return (
        0 <= i < n and
        0 <= j < m and
        grid[i][j] == '1' and
        vis[i][j] == 0
    )


# --------------------------------------------------
# BFS VERSION
# --------------------------------------------------

"""
BFS approach to count number of islands
"""


def num_islands_bfs(grid):
    if not grid or not grid[0]:
        return 0

    from collections import deque

    n, m = len(grid), len(grid[0])
    vis = [[0] * m for _ in range(n)]
    count = 0

    for i in range(n):
        for j in range(m):
            if grid[i][j] == '1' and vis[i][j] == 0:
                bfs(grid, i, j, vis)
                count += 1

    return count


"""
BFS traversal to explore an island
"""


def bfs(grid, i, j, vis):
    from collections import deque

    q = deque()
    q.append((i, j))
    vis[i][j] = 1

    while q:
        row, col = q.popleft()
        for drow in [-1, 0, 1]:
            for dcol in [-1, 0, 1]:
                nrow, ncol = row + drow, col + dcol
                if is_safe_bfs(grid, nrow, ncol, vis):
                    vis[nrow][ncol] = 1
                    q.append((nrow, ncol))


"""
Check if the next cell is valid for BFS
"""


def is_safe_bfs(grid, i, j, vis):
    n, m = len(grid), len(grid[0])
    return (
        0 <= i < n and
        0 <= j < m and
        grid[i][j] == '1' and
        vis[i][j] == 0
    )


# -------------------- TEST --------------------
if __name__ == "__main__":
    grid = [
        ['0', '1'],
        ['1', '0'],
        ['1', '1'],
        ['1', '0']
    ]

    print("DFS:", num_islands(grid))
    print("BFS:", num_islands_bfs(grid))
