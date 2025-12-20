"""
LeetCode 74 - Search a 2D Matrix

Idea:
Treat the 2D matrix as a sorted 1D array.
Apply binary search on indices [0, m*n - 1].

Mapping:
row = mid // n
col = mid % n

Time Complexity: O(log(m*n))
Space Complexity: O(1)
"""

def search_matrix(matrix, target):
    if not matrix or not matrix[0]:
        return False

    m, n = len(matrix), len(matrix[0])
    low, high = 0, m * n - 1

    while low <= high:
        mid = (low + high) // 2
        row, col = mid // n, mid % n

        if matrix[row][col] == target:
            return True
        elif matrix[row][col] < target:
            low = mid + 1
        else:
            high = mid - 1

    return False


# Driver code
if __name__ == "__main__":
    matrix = [
        [1, 3, 5, 7],
        [10, 11, 16, 20],
        [23, 30, 34, 60]
    ]
    print(search_matrix(matrix, 5))  # True
