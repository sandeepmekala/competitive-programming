# LeetCode 1539 - Kth Missing Positive Number
#
# Idea:
# For index i, count of missing numbers before arr[i] is:
#     missing = arr[i] - (i + 1)
#
# This missing count is monotonic → binary search.
#
# Time Complexity: O(log n)
# Space Complexity: O(1)

def find_kth_positive(arr: list[int], k: int) -> int:
    left, right = 0, len(arr) - 1

    while left <= right:
        mid = (left + right) // 2
        missing = arr[mid] - (mid + 1)

        if missing < k:
            left = mid + 1
        else:
            right = mid - 1

    return left + k     # left tells how many nums are there + k to find the desired num


# Driver code
if __name__ == "__main__":
    arr = [2, 3, 4, 7, 11]
    k = 5
    print(find_kth_positive(arr, k))  # 9
