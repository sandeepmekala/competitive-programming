"""
Matrix L59 - Spiral Matrix II

Problem: https://leetcode.com/problems/spiral-matrix-ii/
Idea: Use two pointers for each row/column and move the pointer once that row/column processed.
"""

def generate_matrix(n):
    matrix = [[0] * n for _ in range(n)]
    start_i = 0
    start_j = 0
    end_i = len(matrix) - 1
    end_j = len(matrix[0]) - 1
    counter = 1
    
    while start_i < end_i and start_j < end_j:
        for j in range(start_j, end_j + 1):
            matrix[start_i][j] = counter
            counter += 1
        start_i += 1
        
        for i in range(start_i, end_i + 1):
            matrix[i][end_j] = counter
            counter += 1
        end_j -= 1
        
        for j in range(end_j, start_j - 1, -1):
            matrix[end_i][j] = counter
            counter += 1
        end_i -= 1
        
        for i in range(end_i, start_i - 1, -1):
            matrix[i][start_j] = counter
            counter += 1
        start_j += 1
    
    if start_i == end_i and start_j < end_j:
        for j in range(start_j, end_j + 1):
            matrix[start_i][j] = counter
            counter += 1
    
    if start_i < end_i and start_j == end_j:
        for i in range(start_i, end_i + 1):
            matrix[i][end_j] = counter
            counter += 1
    
    if start_i == end_i and start_j == end_j:
        matrix[start_i][end_i] = counter
        counter += 1
    
    return matrix


if __name__ == "__main__":
    matrix = generate_matrix(3)
    for row in matrix:
        print(row)
