# Matrix L54 - Spiral Matrix
#
# Problem: https://leetcode.com/problems/spiral-matrix/
# Idea:
# Use four boundaries (top, bottom, left, right) and
# traverse the matrix layer by layer in spiral order.


def spiral_order(matrix):
    top, bottom = 0, len(matrix) - 1
    left, right = 0, len(matrix[0]) - 1
    result = []

    while top <= bottom and left <= right:
        # Traverse left -> right
        for c in range(left, right + 1):
            result.append(matrix[top][c])
        top += 1

        # Traverse top -> bottom
        for r in range(top, bottom + 1):
            result.append(matrix[r][right])
        right -= 1

        # Traverse right -> left
        if top <= bottom:       # Go r -> l only if there is a row to process
            for c in range(right, left - 1, -1):
                result.append(matrix[bottom][c])
            bottom -= 1

        # Traverse bottom -> top
        if left <= right:       # Go b -> t only if there is a row to process
            for r in range(bottom, top - 1, -1):
                result.append(matrix[r][left])
            left += 1

    return result


# -------------------- TEST --------------------
if __name__ == "__main__":
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    print(spiral_order(matrix))
