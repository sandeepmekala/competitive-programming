from collections import deque

INF = 2**31 - 1


def walls_and_gates(rooms):
    """
    Problem:
    https://leetcode.com/problems/walls-and-gates/
    https://www.lintcode.com/problem/663/

    Idea:
    - This is a classic **multi-source BFS** problem.
    - All gates (cells with value 0) act as BFS sources.
    - Start BFS simultaneously from all gates.
    - Each BFS level increases distance by 1.
    - Update empty rooms (INF) with the minimum distance to a gate.
    - Walls (-1) are never visited.

    Time Complexity: O(m * n)
    Space Complexity: O(m * n)
    """
    if not rooms or not rooms[0]:
        return

    m, n = len(rooms), len(rooms[0])
    q = deque()

    # Initialize queue with all gates
    for i in range(m):
        for j in range(n):
            if rooms[i][j] == 0:
                q.append((i, j, 0))  # (row, col, distance)

    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    while q:
        row, col, dist = q.popleft()

        for dr, dc in directions:
            nr, nc = row + dr, col + dc
            if 0 <= nr < m and 0 <= nc < n and rooms[nr][nc] == INF:
                rooms[nr][nc] = dist + 1
                q.append((nr, nc, dist + 1))


if __name__ == "__main__":
    rooms = [
        [INF, -1, 0, INF],
        [INF, INF, INF, -1],
        [INF, -1, INF, -1],
        [0, -1, INF, INF],
    ]

    walls_and_gates(rooms)

    for row in rooms:
        print(row)
