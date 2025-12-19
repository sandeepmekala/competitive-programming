"""
LeetCode 1901 - Find a Peak Element II

Idea:
Perform binary search on columns.
For a mid column:
- find the row with maximum element in that column
- compare it with its left and right neighbors
- move search space accordingly

Time Complexity: O(m * log n)
Space Complexity: O(1)
"""

def find_row_of_max_in_column(mat, col):
    max_row = 0
    for r in range(len(mat)):
        if mat[r][col] > mat[max_row][col]:
            max_row = r
    return max_row


def find_peak_grid(mat):
    rows, cols = len(mat), len(mat[0])
    low, high = 0, cols - 1

    while low <= high:
        mid = (low + high) // 2

        max_row = find_row_of_max_in_column(mat, mid)

        left = mat[max_row][mid - 1] if mid > 0 else float("-inf")
        right = mat[max_row][mid + 1] if mid < cols - 1 else float("-inf")

        # Found peak
        if mat[max_row][mid] > left and mat[max_row][mid] > right:
            return [max_row, mid]

        # Move search space
        if mat[max_row][mid] < left:
            high = mid - 1
        else:
            low = mid + 1

    return [-1, -1]


# Driver code
if __name__ == "__main__":
    nums = [
        [1, 4],
        [3, 2]
    ]

    result = find_peak_grid(nums)
    print(result[0], result[1])
