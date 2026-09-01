import heapq
from typing import List


"""
Problem: https://leetcode.com/problems/swim-in-rising-water/
Idea: We need to track the horizon frontier and always take the minimum
cell (by current max height) and expand in that direction.
Once the frontier reaches bottom-right, return the max height seen so far.
(Dijkstra / Min-Heap on grid)
"""
def swim_in_water(grid: List[List[int]]) -> int:
    m, n = len(grid), len(grid[0])

    visited = [[False] * n for _ in range(m)]
    pq = []  # min-heap: (time_or_max_height, row, col)

    heapq.heappush(pq, (grid[0][0], 0, 0))
    visited[0][0] = True

    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    while pq:
        curr_max, r, c = heapq.heappop(pq)

        if r == m - 1 and c == n - 1:
            return curr_max

        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if is_safe(nr, nc, m, n, visited):
                visited[nr][nc] = True
                heapq.heappush(
                    pq,
                    (max(curr_max, grid[nr][nc]), nr, nc)
                )

    return -1


def is_safe(r: int, c: int, m: int, n: int, visited: List[List[bool]]) -> bool:
    return 0 <= r < m and 0 <= c < n and not visited[r][c]


# one test (same as Java main)
if __name__ == "__main__":
    grid = [
        [0, 2],
        [1, 3]
    ]
    print(swim_in_water(grid))
