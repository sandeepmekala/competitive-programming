"""
LeetCode 69 - Sqrt(x)

Idea:
Binary search on the range [1, x].
Use division instead of multiplication to avoid overflow.

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def my_sqrt(x):
    if x == 0:
        return 0

    low, high = 1, x
    ans = 0

    while low <= high:
        mid = (low + high) // 2

        if mid <= x // mid:
            ans = mid          # mid*mid <= x
            low = mid + 1
        else:
            high = mid - 1

    return ans


# Driver code
if __name__ == "__main__":
    x = 8
    print(my_sqrt(x))  # 2
