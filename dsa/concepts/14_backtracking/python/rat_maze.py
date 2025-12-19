# Problem: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
# Idea:
# From each cell, try all 4 directions.
# If destination is reached, return True.
# If a move doesn't lead to solution, backtrack.
# Time: O(4^(n*n))
# Space: O(n*n)

def solve_maze(maze):
    n = len(maze)
    vis = [[0] * n for _ in range(n)]

    if solve(maze, 0, 0, vis):
        for row in vis:
            print(row)
    else:
        print("Solution doesn't exist")


def solve(maze, row, col, vis):
    n = len(maze)

    if row == n - 1 and col == n - 1:
        vis[row][col] = 1
        return True

    dirs = [(0, -1), (-1, 0), (0, 1), (1, 0)]
    for dr, dc in dirs:
        nrow, ncol = row + dr, col + dc
        if is_safe(maze, nrow, ncol, vis):
            vis[nrow][ncol] = 1
            if solve(maze, nrow, ncol, vis):
                return True
            vis[nrow][ncol] = 0  # backtrack

    return False


def is_safe(maze, r, c, vis):
    n = len(maze)
    return (
        0 <= r < n and
        0 <= c < n and
        maze[r][c] == 1 and
        vis[r][c] == 0
    )


# -------- Test --------
maze = [
    [1, 0, 0, 0],
    [1, 1, 0, 1],
    [0, 1, 0, 0],
    [1, 1, 1, 1]
]

solve_maze(maze)
