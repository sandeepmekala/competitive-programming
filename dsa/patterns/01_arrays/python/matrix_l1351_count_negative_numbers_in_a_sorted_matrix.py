"""
Matrix L1351 - Count Negative Numbers in a Sorted Matrix

Problem: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
Idea: Start at the top-right and count the negatives in each column. You can even start at bottom-left.
"""

def count_negatives(grid):
    count = 0
    m = len(grid)
    n = len(grid[0])
    i = 0
    j = n - 1
    
    while i < m and j >= 0:
        if grid[i][j] < 0:
            count += (m - i)
            j -= 1
        else:
            i += 1
    
    return count


if __name__ == "__main__":
    grid = [
        [4, 3, 2, -1],
        [3, 2, 1, -1],
        [1, 1, -1, -2],
        [-1, -1, -2, -3]
    ]
    print(count_negatives(grid))
