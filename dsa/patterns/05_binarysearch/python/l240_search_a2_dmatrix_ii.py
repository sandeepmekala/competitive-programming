# LeetCode 240 - Search a 2D Matrix II
#
# Idea:
# Start from the top-right corner.
# - If target < current → move left
# - If target > current → move down
# Each step eliminates one row or one column.
#
# Time Complexity: O(m + n)
# Space Complexity: O(1)

def search_matrix(matrix: list[list[int]], target: int) -> bool:
    row, col = 0, len(matrix[0]) - 1

    while row < len(matrix) and col >= 0:
        current = matrix[row][col]

        if current == target:
            return True
        if target < current:
            col -= 1
        else:
            row += 1

    return False


# Driver code
if __name__ == "__main__":
    matrix = [
        [1, 4, 7, 11, 15],
        [2, 5, 8, 12, 19],
        [3, 6, 9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
    ]

    print(search_matrix(matrix, 5))  # True
