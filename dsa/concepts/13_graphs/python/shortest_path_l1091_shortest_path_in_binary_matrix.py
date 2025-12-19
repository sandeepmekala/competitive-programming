from collections import deque
import math


"""
Problem: https://leetcode.com/problems/shortest-path-in-binary-matrix/
Idea:
Apply Dijkstra / BFS since all edges have unit weight.
We can move in 8 directions.
Track distance matrix and return distance when bottom-right is reached.

Time Complexity: O(n * m)
Space Complexity: O(n * m)
"""
def shortest_path_binary_matrix(grid):
    if grid[0][0] == 1:
        return -1

    m, n = len(grid), len(grid[0])
    dist = [[math.inf] * n for _ in range(m)]

    q = deque()
    dist[0][0] = 1
    q.append((0, 0))

    while q:
        row, col = q.popleft()

        if row == m - 1 and col == n - 1:
            return dist[row][col]

        for dr in (-1, 0, 1):
            for dc in (-1, 0, 1):
                nrow, ncol = row + dr, col + dc
                if is_safe(grid, m, n, nrow, ncol):
                    if dist[row][col] + 1 < dist[nrow][ncol]:
                        dist[nrow][ncol] = dist[row][col] + 1
                        q.append((nrow, ncol))

    return -1


def is_safe(grid, m, n, r, c):
    return 0 <= r < m and 0 <= c < n and grid[r][c] == 0


# one test (same as Java main)
if __name__ == "__main__":
    grid = [
        [0, 0, 0],
        [1, 1, 0],
        [1, 1, 0]
    ]
    print(shortest_path_binary_matrix(grid))  # 4
