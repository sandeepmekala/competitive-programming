"""
L2133 - Check if Every Row and Column Contains All Numbers

Problem: https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
Idea: Add each row and col elements to HashSet and check if all are unique
Time: O(n^2) where n is the size of the board
Space: O(n) for the sets
"""

def check_valid(matrix):
    n = len(matrix)
    
    for i in range(n):
        row_set = set()
        col_set = set()
        
        for j in range(n):
            # Check row uniqueness
            if matrix[i][j] in row_set:
                return False
            row_set.add(matrix[i][j])
            
            # Check column uniqueness
            if matrix[j][i] in col_set:
                return False
            col_set.add(matrix[j][i])
    
    return True

if __name__ == "__main__":
    matrix = [[1, 2, 3], [3, 1, 2], [2, 3, 1]]
    print(f"Input: {matrix}")
    print(f"Output: {check_valid(matrix)}")
