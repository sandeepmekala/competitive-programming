"""
L36 - Valid Sudoku

Problem: https://leetcode.com/problems/valid-sudoku/
Idea: Use Set to find each section has distinct elements
Time: O(1) - fixed 9x9 board
Space: O(1) - fixed size sets
"""

def is_valid_sudoku(board):
    # Check rows
    for i in range(len(board)):
        seen = set()
        for j in range(len(board[i])):
            if board[i][j] != '.':
                if board[i][j] in seen:
                    return False
                seen.add(board[i][j])
    
    # Check columns
    for j in range(len(board)):
        seen = set()
        for i in range(len(board)):
            if board[i][j] != '.':
                if board[i][j] in seen:
                    return False
                seen.add(board[i][j])
    
    # Check 3x3 boxes
    boxes = [[set() for _ in range(3)] for _ in range(3)]
    
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] != '.':
                if board[i][j] in boxes[i//3][j//3]:
                    return False
                boxes[i//3][j//3].add(board[i][j])
    
    return True

if __name__ == "__main__":
    board = [['8','3','.','.','7','.','.','.','.'],
             ['6','.','.','1','9','5','.','.','.'],
             ['.','9','8','.','.','.','.','6','.'],
             ['8','.','.','.','6','.','.','.','3'],
             ['4','.','.','8','.','3','.','.','1'],
             ['7','.','.','.','2','.','.','.','6'],
             ['.','6','.','.','.','.','2','8','.'],
             ['.','.','.','4','1','9','.','.','5'],
             ['.','.','.','.','8','.','.','7','9']]
    print(f"Input: {board}")
    print(f"Output: {is_valid_sudoku(board)}")
