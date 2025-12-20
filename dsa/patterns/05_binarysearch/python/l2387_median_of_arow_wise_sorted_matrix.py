"""
Median of a Row-Wise Sorted Matrix

Idea:
Binary search on the value range [min_element, max_element].
For a guessed value mid, count how many elements are <= mid
using upper bound on each row.

Time Complexity: O(log(range) * r * log(c))
Space Complexity: O(1)
"""

def upper_bound(nums, target):
    low, high = 0, len(nums) - 1
    while low <= high:
        mid = (low + high) // 2
        if nums[mid] <= target:
            low = mid + 1
        else:
            high = mid - 1
    return low


def count_smaller_equal(mat, mid):
    count = 0
    for row in mat:
        count += upper_bound(row, mid)
    return count


def find_median(mat):
    r, c = len(mat), len(mat[0])

    # Determine search range
    low = min(row[0] for row in mat)
    high = max(row[-1] for row in mat)

    desired = (r * c) // 2

    while low <= high:
        mid = (low + high) // 2
        cnt = count_smaller_equal(mat, mid)

        if cnt <= desired:
            low = mid + 1
        else:
            high = mid - 1

    return low


# Driver code
if __name__ == "__main__":
    mat = [
        [1, 3, 8],
        [2, 3, 4],
        [1, 2, 5]
    ]
    print(find_median(mat))  # 3
