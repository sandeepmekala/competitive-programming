# Problem: Sudoku Solver
# Idea:
# Try to fill each empty cell ('.') with digits 1–9.
# A number is valid if it does not appear in:
# 1) the same row
# 2) the same column
# 3) the same 3x3 subgrid
# Use backtracking: if a choice leads to failure, undo it.

def solve_sudoku(board):
    solve(board)


def solve(board):
    for row in range(9):
        for col in range(9):
            if board[row][col] == '.':
                for ch in '123456789':
                    if is_safe(board, row, col, ch):
                        board[row][col] = ch
                        if solve(board):
                            return True
                        board[row][col] = '.'  # backtrack
                return False
    return True


def is_safe(board, row, col, ch):
    for i in range(9):
        # row check
        if board[row][i] == ch:
            return False
        # column check
        if board[i][col] == ch:
            return False
        # 3x3 subgrid check
        if board[3 * (row // 3) + i // 3][3 * (col // 3) + i % 3] == ch:
            return False
    return True


# -------- Test --------
board = [
    ['5','3','.','.','7','.','.','.','.'],
    ['6','.','.','1','9','5','.','.','.'],
    ['.','9','8','.','.','.','.','6','.'],
    ['8','.','.','.','6','.','.','.','3'],
    ['4','.','.','8','.','3','.','.','1'],
    ['7','.','.','.','2','.','.','.','6'],
    ['.','6','.','.','.','.','2','8','.'],
    ['.','.','.','4','1','9','.','.','5'],
    ['.','.','.','.','8','.','.','7','9']
]

solve_sudoku(board)

for row in board:
    print(row)
