# Matrix L59 - Spiral Matrix II
#
# Problem: https://leetcode.com/problems/spiral-matrix-ii/
#
# Idea:
# - Use four pointers: top, bottom, left, right
# - Fill the matrix layer by layer in spiral order
# - Move the pointer once that row/column is processed


def generate_matrix(n):
    matrix = [[0] * n for _ in range(n)]

    top, bottom = 0, n - 1
    left, right = 0, n - 1
    num = 1

    while top <= bottom and left <= right:
        # Traverse left → right
        for col in range(left, right + 1):
            matrix[top][col] = num
            num += 1
        top += 1

        # Traverse top → bottom
        for row in range(top, bottom + 1):
            matrix[row][right] = num
            num += 1
        right -= 1

        # Traverse right → left
        if top <= bottom:
            for col in range(right, left - 1, -1):
                matrix[bottom][col] = num
                num += 1
            bottom -= 1

        # Traverse bottom → top
        if left <= right:
            for row in range(bottom, top - 1, -1):
                matrix[row][left] = num
                num += 1
            left += 1

    return matrix


# -------------------- TEST --------------------
if __name__ == "__main__":
    result = generate_matrix(3)
    for row in result:
        print(row)
