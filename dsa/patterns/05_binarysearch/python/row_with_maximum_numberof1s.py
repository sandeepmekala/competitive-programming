"""
Row with Maximum Number of 1s (GFG)

Idea:
Each row is sorted (0s then 1s).
For each row:
- Find the first occurrence of 1 using lower bound
- Number of 1s = total_columns - index

Time Complexity: O(r * log c)
Space Complexity: O(1)
"""

def lower_bound(nums, target):
    low, high = 0, len(nums) - 1
    res = len(nums)

    while low <= high:
        mid = (low + high) // 2
        if nums[mid] >= target:
            res = mid
            high = mid - 1
        else:
            low = mid + 1

    return res


def row_with_max_1s(mat):
    r, c = len(mat), len(mat[0])
    max_ones = 0
    row_index = -1

    for i in range(r):
        idx = lower_bound(mat[i], 1)
        ones = c - idx
        if ones > max_ones:
            max_ones = ones
            row_index = i

    return row_index


# Driver code
if __name__ == "__main__":
    mat = [
        [0, 0, 0, 1],
        [0, 1, 1, 1],
        [1, 1, 1, 1],
        [0, 0, 0, 0]
    ]

    print(row_with_max_1s(mat))  # 2
