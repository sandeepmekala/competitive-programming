"""
LeetCode 441 - Arranging Coins

Idea:
To form k complete rows, we need:
    k * (k + 1) // 2 <= n

Binary search on k.

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def arrange_coins(n):
    left, right = 1, n
    ans = 0

    while left <= right:
        mid = (left + right) // 2
        coins = mid * (mid + 1) // 2

        if coins <= n:
            ans = mid          # mid rows can be formed
            left = mid + 1     # try more rows
        else:
            right = mid - 1    # reduce rows

    return ans


# Driver code
if __name__ == "__main__":
    print(arrange_coins(8))  # 3
