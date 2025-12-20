# Problem: https://leetcode.com/problems/n-queens/
# Idea: For each row, recursively check if col gives solution. Else,
# Increment col. If none of the cols give solution, increment row.
# Time: O(n^n) as we start by placing 4 queens in each row and col 0.
# Each recursion checks for different col. It will be tree with 4 children
# Tree depth is col's
# Space: O(n^2)
def solveNQueens(n):
    result = []
    board = [[0] * n for _ in range(n)]
    solve(board, 0, result)
    return result


def solve(board, col, result):
    n = len(board)
    if col == n:
        saveResult(board, result)
        return

    for row in range(n):
        if isSafe(board, row, col):
            board[row][col] = 1
            solve(board, col + 1, result)
            board[row][col] = 0  # backtrack


def saveResult(board, result):
    res = []
    for i in range(len(board)):
        row = ""
        for j in range(len(board)):
            if board[i][j] == 1:
                row += "Q"
            else:
                row += "."
        res.append(row)
    result.append(res)


# This checks can be optimized to O(1) using hashing
# Left: n size array hash with entries for each row
# Top left diagonal: index = (n-1)-(row-col), 2*n-1 size array hash
# Bottom left diagonal: index = row+col, 2*n-1 size array hash
def isSafe(board, row, col):
    n = len(board)

    # left side
    for i in range(col):
        if board[row][i] == 1:
            return False

    # top-left diagonal
    i, j = row, col
    while i >= 0 and j >= 0:
        if board[i][j] == 1:
            return False
        i -= 1
        j -= 1

    # lower-left diagonal
    i, j = row, col
    while i < n and j >= 0:
        if board[i][j] == 1:
            return False
        i += 1
        j -= 1

    return True


# -------- Test --------
print(solveNQueens(4))
