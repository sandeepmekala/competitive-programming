import heapq
import math


"""
Problem: https://leetcode.com/problems/path-with-minimum-effort/
Idea:
Apply Dijkstra's algorithm where the distance is defined as the
maximum absolute height difference encountered along the path.

Instead of summing weights, we minimize the maximum edge cost on the path.

Time Complexity: O(m * n * log(m * n))
Space Complexity: O(m * n)
"""
def minimum_effort_path(heights):
    m, n = len(heights), len(heights[0])

    dist = [[math.inf] * n for _ in range(m)]
    dist[0][0] = 0

    pq = []
    heapq.heappush(pq, (0, 0, 0))   # (effort, row, col)

    while pq:
        effort, row, col = heapq.heappop(pq)

        if row == m - 1 and col == n - 1:
            return effort

        for dr, dc in ((0, -1), (-1, 0), (0, 1), (1, 0)):
            nrow, ncol = row + dr, col + dc
            if is_safe(m, n, nrow, ncol):
                next_effort = max(
                    effort,
                    abs(heights[nrow][ncol] - heights[row][col])
                )

                if next_effort < dist[nrow][ncol]:
                    dist[nrow][ncol] = next_effort
                    heapq.heappush(pq, (next_effort, nrow, ncol))

    return 0


def is_safe(m, n, r, c):
    return 0 <= r < m and 0 <= c < n


# one test (same as Java main)
if __name__ == "__main__":
    heights = [
        [1, 2, 2],
        [3, 8, 2],
        [5, 3, 5]
    ]
    print(minimum_effort_path(heights))  # 2
