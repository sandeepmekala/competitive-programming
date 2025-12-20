"""
LeetCode 1539 - Kth Missing Positive Number

Idea:
For index i, count of missing numbers before arr[i] is:
    missing = arr[i] - (i + 1)

This missing count is monotonic → binary search.

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def find_kth_positive(arr, k):
    low, high = 0, len(arr) - 1

    while low <= high:
        mid = (low + high) // 2
        missing = arr[mid] - (mid + 1)

        if missing < k:
            low = mid + 1
        else:
            high = mid - 1

    return low + k


# Driver code
if __name__ == "__main__":
    arr = [2, 3, 4, 7, 11]
    k = 5
    print(find_kth_positive(arr, k))  # 9
