"""
Matrix - Rotate Matrix By One Element
"""

def rotate(matrix):
    start_i = 0
    start_j = 0
    end_i = len(matrix) - 1
    end_j = len(matrix[0]) - 1
    
    while start_i < end_i and start_j < end_j:
        # shift top row
        prev = matrix[start_i + 1][start_j]
        for j in range(start_j, end_j):
            curr = matrix[start_i][j]
            matrix[start_i][j] = prev
            prev = curr
        
        # shift last column
        for i in range(start_i, end_i):
            curr = matrix[i][end_j]
            matrix[i][end_j] = prev
            prev = curr
        
        # shift last row
        for j in range(end_j, start_j, -1):
            curr = matrix[end_i][j]
            matrix[end_i][j] = prev
            prev = curr
        
        # shift first column
        for i in range(end_i, start_i, -1):
            curr = matrix[i][start_j]
            matrix[i][start_j] = prev
            prev = curr
        
        start_i += 1
        start_j += 1
        end_i -= 1
        end_j -= 1
    
    # incase of rectangle matrix with odd dimention, there will be one last row/colum to be processed
    # odd number of rows
    if start_i < end_i:
        prev = matrix[end_i][end_j]
        for i in range(start_i, end_i + 1):
            curr = matrix[i][end_j]
            matrix[i][end_j] = prev
            prev = curr
    
    # odd number of cols
    if start_j < end_j:
        prev = matrix[end_i][end_j]
        for j in range(start_j, end_j + 1):
            curr = matrix[end_i][j]
            matrix[end_i][j] = prev
            prev = curr


def print_matrix(matrix):
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            print(matrix[i][j], end=" ")
        print()


if __name__ == "__main__":
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    
    print_matrix(matrix)
    rotate(matrix)
    
    print()
    print_matrix(matrix)
