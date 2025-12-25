# PrefixSum L304 - Range Sum Query 2D Immutable
#
# Problem: https://leetcode.com/problems/range-sum-query-2d-immutable/
# Companies: Amazon
#
# Idea:
# - Calculate 2D prefix sum
# - prefix[i][j] stores sum of submatrix (0,0) to (i-1,j-1)
#
# Time:
#   Preprocessing: O(m * n)
#   Query: O(1)
#
# Space: O(m * n)


class NumMatrix:
    def __init__(self, matrix):
        rows, cols = len(matrix), len(matrix[0])

        self.prefix = [[0] * (cols + 1) for _ in range(rows + 1)]

        for r in range(1, rows + 1):
            for c in range(1, cols + 1):
                self.prefix[r][c] = (
                    matrix[r - 1][c - 1]
                    + self.prefix[r - 1][c]
                    + self.prefix[r][c - 1]
                    - self.prefix[r - 1][c - 1]
                )

    def sum_region(self, row1, col1, row2, col2):
        return (
            self.prefix[row2 + 1][col2 + 1]
            - self.prefix[row1][col2 + 1]
            - self.prefix[row2 + 1][col1]
            + self.prefix[row1][col1]
        )


# -------------------- TEST --------------------
if __name__ == "__main__":
    matrix = [
        [3, 0, 1, 4, 2],
        [5, 6, 3, 2, 1],
        [1, 2, 0, 1, 5],
        [4, 1, 0, 1, 7],
        [1, 0, 3, 0, 5]
    ]

    obj = NumMatrix(matrix)
    print(obj.sum_region(2, 1, 4, 3))  # Output: 8
