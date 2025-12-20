"""
PrefixSum L304 - Range Sum Query 2D Immutable

Problem: https://leetcode.com/problems/range-sum-query-2d-immutable/
Companies: Amazon
Idea: Calculate the prefix sum of each cell in matrix
"""

class NumMatrix:
    def __init__(self, matrix):
        m = len(matrix)
        n = len(matrix[0])
        
        self.prefix_sum = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                self.prefix_sum[i][j] = (matrix[i - 1][j - 1] + 
                                       self.prefix_sum[i - 1][j] + 
                                       self.prefix_sum[i][j - 1] - 
                                       self.prefix_sum[i - 1][j - 1])
    
    def sum_region(self, row1, col1, row2, col2):
        total = 0
        total += self.prefix_sum[row2 + 1][col2 + 1]
        total -= self.prefix_sum[row1][col2 + 1]
        total -= self.prefix_sum[row2 + 1][col1]
        total += self.prefix_sum[row1][col1]
        
        return total


if __name__ == "__main__":
    matrix = [
        [3, 0, 1, 4, 2],
        [5, 6, 3, 2, 1],
        [1, 2, 0, 1, 5],
        [4, 1, 0, 1, 7],
        [1, 0, 3, 0, 5]
    ]
    obj = NumMatrix(matrix)
    print(obj.sum_region(2, 1, 4, 3))
