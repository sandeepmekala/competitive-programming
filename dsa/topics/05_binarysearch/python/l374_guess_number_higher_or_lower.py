"""
LeetCode 374 - Guess Number Higher or Lower

Idea:
Use binary search.
The guess API tells whether the picked number is:
- higher
- lower
- equal

Time Complexity: O(log n)
Space Complexity: O(1)
"""

# Mock API (LeetCode provides this)
def guess(num):
    pick = 6
    if num == pick:
        return 0
    elif num > pick:
        return -1
    else:
        return 1


def guess_number(n):
    left, right = 1, n

    while left <= right:
        mid = left + (right - left) // 2

        res = guess(mid)
        if res == 0:
            return mid
        elif res == -1:
            right = mid - 1
        else:
            left = mid + 1

    return -1


# Driver code
if __name__ == "__main__":
    print(guess_number(10))  # 6
