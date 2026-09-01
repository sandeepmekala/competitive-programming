from collections import deque


def oranges_rotting(grid):
    """
    Problem: https://leetcode.com/problems/rotting-oranges/

    1 -> fresh, 2 -> rotten, 0 -> empty

    Idea:
    - This is a **multi-source BFS** problem.
    - Count all fresh oranges initially.
    - Push all rotten oranges into the queue with time = 0.
    - For each rotten orange, try to rot its 4-direction neighbors.
    - Each newly rotten orange is added to the queue with time + 1.
    - Track the maximum time taken.
    - If fresh oranges remain at the end, return -1.

    Time: O(m * n)
    Space: O(m * n)
    """
    m, n = len(grid), len(grid[0])

    fresh = 0
    visited = [[False] * n for _ in range(m)]
    q = deque()

    # Initialize queue with all rotten oranges
    for i in range(m):
        for j in range(n):
            if grid[i][j] == 1:
                fresh += 1
            elif grid[i][j] == 2:
                q.append((i, j, 0))   # (row, col, minutes)
                visited[i][j] = True

    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    max_minutes = 0

    while q:
        row, col, minutes = q.popleft()
        max_minutes = max(max_minutes, minutes)

        for dr, dc in directions:
            nr, nc = row + dr, col + dc
            if (
                0 <= nr < m and
                0 <= nc < n and
                grid[nr][nc] == 1 and
                not visited[nr][nc]
            ):
                visited[nr][nc] = True
                fresh -= 1
                q.append((nr, nc, minutes + 1))

    return max_minutes if fresh == 0 else -1


if __name__ == "__main__":
    grid = [
        [1, 2]
    ]
    print(oranges_rotting(grid))
    