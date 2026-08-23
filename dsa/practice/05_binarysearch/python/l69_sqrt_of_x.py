# LeetCode 69 - Sqrt(x)
#
# Idea:
# Binary search on the range [1, x].
# Use division instead of multiplication to avoid overflow.
#
# Time Complexity: O(log n)
# Space Complexity: O(1)

def my_sqrt(x: int) -> int:
    if x == 0:
        return 0

    left, right = 1, x
    res = 0

    while left <= right:
        mid = (left + right) // 2

        if mid <= x // mid:  # mid*mid <= x we have to return int <= sqrt(x)
            res = mid
            left = mid + 1
        else:
            right = mid - 1

    return res


# Driver code
if __name__ == "__main__":
    x = 8
    print(my_sqrt(x))  # 2
