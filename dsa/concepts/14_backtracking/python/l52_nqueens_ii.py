# Problem: https://leetcode.com/problems/n-queens-ii/
# Idea: For each row, recursively check if col gives solution. Else,
# increment col. If none of the cols give solution, increment row.
# Time complexity: O(n^n) as we start by placing 4 queens in each row and col
# 0. Each recursion checks for different col. It will be tree with 4 children
# and col depth.
# Time: O(n^n)
# Space: O(n^2)
def totalNQueens(n):
    board = [[0] * n for _ in range(n)]
    return backtrack(board, 0)


def backtrack(board, col):
    n = len(board)
    if col == n:
        return 1

    count = 0
    for row in range(n):
        if isSafe(board, row, col):
            board[row][col] = 1
            count += backtrack(board, col + 1)
            board[row][col] = 0  # Backtrack

    return count


def isSafe(board, curRow, curCol):
    n = len(board)

    # left side
    for i in range(curCol):
        if board[curRow][i] == 1:
            return False

    # upper-left diagonal
    i, j = curRow, curCol
    while i >= 0 and j >= 0:
        if board[i][j] == 1:
            return False
        i -= 1
        j -= 1

    # lower-left diagonal
    i, j = curRow, curCol
    while i < n and j >= 0:
        if board[i][j] == 1:
            return False
        i += 1
        j -= 1

    return True


# -------- Test --------
print(totalNQueens(4))  # Output: 2
