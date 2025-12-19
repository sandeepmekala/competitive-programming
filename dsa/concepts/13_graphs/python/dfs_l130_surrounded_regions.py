"""
Problem:
https://leetcode.com/problems/surrounded-regions/

Idea:
- Run DFS from all border cells that contain 'O'
- Mark all such reachable 'O's as visited (they cannot be surrounded)
- Convert all remaining unvisited 'O' cells to 'X'

Time: O(m * n)
Space: O(m * n)
"""


def solve(board):
    if not board or not board[0]:
        return board

    m, n = len(board), len(board[0])
    vis = [[0] * n for _ in range(m)]

    # Run DFS from all border cells
    for i in range(m):
        for j in range(n):
            if (i == 0 or j == 0 or i == m - 1 or j == n - 1):
                if board[i][j] == 'O' and vis[i][j] == 0:
                    dfs(board, i, j, vis)

    # Flip all unvisited 'O' to 'X'
    for i in range(m):
        for j in range(n):
            if board[i][j] == 'O' and vis[i][j] == 0:
                board[i][j] = 'X'

    return board


"""
DFS to mark all border-connected 'O' cells
"""


def dfs(board, i, j, vis):
    vis[i][j] = 1
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    for di, dj in directions:
        ni, nj = i + di, j + dj
        if is_safe(board, ni, nj, vis):
            dfs(board, ni, nj, vis)


"""
Check if the cell is valid for DFS
"""


def is_safe(board, i, j, vis):
    m, n = len(board), len(board[0])
    return (
        0 <= i < m and
        0 <= j < n and
        board[i][j] == 'O' and
        vis[i][j] == 0
    )


# -------------------- TEST --------------------
if __name__ == "__main__":
    board = [
        ['X', 'X', 'X', 'X'],
        ['X', 'O', 'X', 'X'],
        ['X', 'O', 'O', 'X'],
        ['X', 'O', 'X', 'X'],
        ['X', 'X', 'O', 'O']
    ]

    result = solve(board)
    for row in result:
        print(row)
