# L119 - Pascal's Triangle II
#
# Problem: https://leetcode.com/problems/pascals-triangle-ii/
# Idea: Generate only the required row using space optimization
# Time: O(rowIndex^2)
# Space: O(rowIndex)


def get_row(row_index):
    row = [1] * (row_index + 1)

    for r in range(2, row_index + 1):
        # Update values from right to left to avoid overwriting needed values
        for c in range(r - 1, 0, -1):   # r is already 1
            row[c] += row[c - 1]

    return row


# -------------------- TEST --------------------
if __name__ == "__main__":
    row_index = 3
    print(get_row(row_index))  # [1, 3, 3, 1]
