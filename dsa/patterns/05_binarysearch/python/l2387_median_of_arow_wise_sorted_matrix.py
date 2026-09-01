# Median of a Row-Wise Sorted Matrix
#
# Idea:
# Binary search on the value range [min, max] of mat.
# For a guessed mid, count how many elements are <= mid
# using upper bound on each row.
#
# Time Complexity: O(log(range) * r * log(c))
# Space Complexity: O(1)

def upper_bound(nums: list[int], target: int) -> int:
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = (left + right) // 2
        if nums[mid] <= target:
            left = mid + 1
        else:
            right = mid - 1

    return left


def count_smaller_equal(mat: list[list[int]], value: int) -> int:
    count = 0
    for row in mat:
        count += upper_bound(row, value)
    return count


def find_median(mat: list[list[int]]) -> int:
    rows, cols = len(mat), len(mat[0])

    # Median lies between, min and max in mat
    left = min(row[0] for row in mat)
    right = max(row[-1] for row in mat)

    # For median, half element should be left and half should be right
    required = (rows * cols) // 2

    while left <= right:
        mid = (left + right) // 2
        count = count_smaller_equal(mat, mid)

        if count <= required:
            left = mid + 1
        else:
            right = mid - 1

    return left


# Driver code
if __name__ == "__main__":
    mat = [
        [1, 3, 8],
        [2, 3, 4],
        [1, 2, 5]
    ]
    print(find_median(mat))  # 3
