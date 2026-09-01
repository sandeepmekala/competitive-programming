"""
LeetCode 278 - First Bad Version

Idea:
Binary search to find the first version where isBadVersion(version) == True.
Once a bad version is found, move left to find the earliest one.

Time Complexity: O(log n)
Space Complexity: O(1)
"""

# Mock API (LeetCode provides this)
def isBadVersion(version):
    return version >= 4


def first_bad_version(n):
    left, right = 1, n
    ans = -1

    while left <= right:
        mid = left + (right - left) // 2

        if isBadVersion(mid):
            ans = mid
            right = mid - 1   # move left to find earlier bad version
        else:
            left = mid + 1

    return ans


# Driver code
if __name__ == "__main__":
    print(first_bad_version(5))  # 4
