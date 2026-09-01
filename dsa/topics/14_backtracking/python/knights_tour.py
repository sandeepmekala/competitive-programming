# Problem: Knight’s Tour
# Idea:
# Use backtracking to try all 8 possible knight moves.
# Mark each cell with move number.
# If we reach N*N moves, tour is complete.
# If a path fails, backtrack.

N = 8

def knights_tour():
    board = [[-1] * N for _ in range(N)]

    # All possible knight moves
    dr = [2, 1, -1, -2, -2, -1, 1, 2]
    dc = [1, 2, 2, 1, -1, -2, -2, -1]

    board[0][0] = 0  # starting position

    if backtrack(0, 0, 1, board, dr, dc):
        print_board(board)
        return True
    else:
        print("Solution does not exist")
        return False


# Backtracking function
def backtrack(row, col, move, board, dr, dc):
    if move == N * N:
        return True

    for i in range(8):
        nrow = row + dr[i]
        ncol = col + dc[i]

        if is_safe(nrow, ncol, board):
            board[nrow][ncol] = move
            if backtrack(nrow, ncol, move + 1, board, dr, dc):
                return True
            board[nrow][ncol] = -1  # backtrack

    return False


# Check if move is valid
def is_safe(r, c, board):
    return 0 <= r < N and 0 <= c < N and board[r][c] == -1


# Print solution
def print_board(board):
    for row in board:
        print(row)


# -------- Test --------
knights_tour()
