# Problem: https://leetcode.com/problems/word-search/
# Idea: Do dfs on the grid and check the char at index is matching the board grid char.
# Pass the index of word in the recursion
# If ind == word len, then return true.
def exist(board, word):
    m, n = len(board), len(board[0])
    visited = [[False] * n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            if dfs(board, word, i, j, 0, visited):
                return True
    return False


def dfs(board, word, row, col, ind, visited):
    if ind == len(word):
        return True

    if not isSafe(board, word, row, col, ind, visited):
        return False

    visited[row][col] = True

    dirs = [(0, -1), (-1, 0), (0, 1), (1, 0)]
    for dr, dc in dirs:
        if dfs(board, word, row + dr, col + dc, ind + 1, visited):
            return True

    visited[row][col] = False      # backtrack
    return False


def isSafe(board, word, i, j, ind, visited):
    return (
        0 <= i < len(board) and
        0 <= j < len(board[0]) and
        not visited[i][j] and
        board[i][j] == word[ind]
    )


# -------- Test --------
board = [
    ['A', 'B', 'C', 'E'],
    ['S', 'F', 'C', 'S'],
    ['A', 'D', 'E', 'E']
]
word = "ABCCED"

print(exist(board, word))  # True
