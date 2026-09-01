# Row with Maximum Number of 1s (GFG)
#
# Idea:
# Each row is sorted (0s then 1s).
# For each row:
# - Find the first occurrence of 1 using lower bound
# - Number of 1s = total_columns - index
#
# Time Complexity: O(r * log c)
# Space Complexity: O(1)

def lower_bound(nums: list[int], target: int) -> int:
    left, right = 0, len(nums) - 1
    ans = len(nums)

    while left <= right:
        mid = (left + right) // 2
        if nums[mid] >= target:
            ans = mid
            right = mid - 1
        else:
            left = mid + 1

    return ans


def row_with_max_1s(mat: list[list[int]]) -> int:
    rows, cols = len(mat), len(mat[0])
    max_ones = 0
    ans_row = -1

    for row in range(rows):
        first_one_index = lower_bound(mat[row], 1)
        ones_count = cols - first_one_index

        if ones_count > max_ones:
            max_ones = ones_count
            ans_row = row

    return ans_row


# Driver code
if __name__ == "__main__":
    mat = [
        [0, 0, 0, 1],
        [0, 1, 1, 1],
        [1, 1, 1, 1],
        [0, 0, 0, 0]
    ]

    print(row_with_max_1s(mat))  # 2
