from collections import deque


def update_matrix(mat):
    """
    Problem:
    https://leetcode.com/problems/01-matrix/

    Idea:
    - This is a **multi-source BFS** problem.
    - All cells with value `0` are treated as BFS sources.
    - Push all `0` cells into the queue with distance 0.
    - BFS level-by-level and update distance for `1` cells.
    - The first time we reach a cell is the shortest distance to a `0`.

    Time Complexity: O(m * n)
    Space Complexity: O(m * n)
    """
    m, n = len(mat), len(mat[0])

    dist = [[0] * n for _ in range(m)]
    visited = [[False] * n for _ in range(m)]
    q = deque()

    # Initialize queue with all 0-cells
    for i in range(m):
        for j in range(n):
            if mat[i][j] == 0:
                q.append((i, j, 0))  # (row, col, distance)
                visited[i][j] = True

    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    while q:
        row, col, steps = q.popleft()
        dist[row][col] = steps

        for dr, dc in directions:
            nr, nc = row + dr, col + dc
            if 0 <= nr < m and 0 <= nc < n and not visited[nr][nc]:
                visited[nr][nc] = True
                q.append((nr, nc, steps + 1))

    return dist


if __name__ == "__main__":
    grid = [
        [0, 1, 1, 0],
        [1, 1, 0, 0],
        [0, 0, 1, 1]
    ]

    ans = update_matrix(grid)
    for row in ans:
        print(row)
