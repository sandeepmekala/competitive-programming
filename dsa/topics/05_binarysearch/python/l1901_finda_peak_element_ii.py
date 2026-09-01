# LeetCode 1901 - Find a Peak Element II
#
# Idea:
# Perform binary search on columns [0, cols-1].
# For a each mid column:
# - find the row with maximum element in that column
# - compare it with its left and right neighbors. If it ig greater then both, found ans.
# - Else move search space to max side direction
#
# Time Complexity: O(m * log n)
# Space Complexity: O(1)

def find_row_of_max_in_column(mat: list[list[int]], col: int) -> int:
    max_row = 0
    for row in range(len(mat)):
        if mat[row][col] > mat[max_row][col]:
            max_row = row
    return max_row


def find_peak_grid(mat: list[list[int]]) -> list[int]:
    rows, cols = len(mat), len(mat[0])
    left, right = 0, cols - 1

    while left <= right:
        mid = (left + right) // 2

        max_row = find_row_of_max_in_column(mat, mid)

        left_val = mat[max_row][mid - 1] if mid > 0 else float("-inf")
        right_val = mat[max_row][mid + 1] if mid < cols - 1 else float("-inf")

        # Found peak
        if mat[max_row][mid] > left_val and mat[max_row][mid] > right_val:
            return [max_row, mid]

        # Move search space
        if left_val > mat[max_row][mid]:
            right = mid - 1
        else:
            left = mid + 1

    return [-1, -1]


# Driver code
if __name__ == "__main__":
    mat = [
        [1, 4],
        [3, 2]
    ]

    result = find_peak_grid(mat)
    print(result[0], result[1])  # 0 1
