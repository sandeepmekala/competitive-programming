"""
L119 - Pascal's Triangle II

Problem: https://leetcode.com/problems/pascals-triangle-ii/
Idea: Generate only the required row using space optimization
Time: O(rowIndex^2)
Space: O(rowIndex)
"""

def get_row(row_index):
    row = [1] * (row_index + 1)
    
    for i in range(1, row_index):
        for j in range(i, 0, -1):
            row[j] += row[j - 1]
    
    return row


if __name__ == "__main__":
    row_index = 3
    print(f"Row {row_index} of Pascal's triangle: {get_row(row_index)}")
    
    for i in range(6):
        print(f"Row {i}: {get_row(i)}")
