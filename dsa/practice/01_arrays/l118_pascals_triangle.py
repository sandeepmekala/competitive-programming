# L118 - Pascal's Triangle
#
# Problem: https://leetcode.com/problems/pascals-triangle/
# Idea: Each row starts and ends with 1.
# Middle elements are the sum of two elements above.
# Time: O(n^2)
# Space: O(n^2)


def generate(num_rows):
    triangle = []

    for r in range(num_rows):
        row = [1] * (r + 1)

        for c in range(1, r):
            row[c] = triangle[r - 1][c - 1] + triangle[r - 1][c]

        triangle.append(row)

    return triangle


# -------------------- TEST --------------------
if __name__ == "__main__":
    num_rows = 5
    for row in generate(num_rows):
        print(row)
