# LeetCode 4 - Median of Two Sorted Arrays
#
# Idea:
# Binary Search on the smaller array to partition both arrays
# into left and right halves such that:
# - left half has (n + 1) // 2 elements, n is total elements
# - max(left) <= min(right)
#
# Time Complexity: O(log(min(n1, n2)))
# Space Complexity: O(1)

import math


def find_median_sorted_arrays(nums1: list[int], nums2: list[int]) -> float:
    n1, n2 = len(nums1), len(nums2)

    if n1 > n2:  # BS on smaller array
        return find_median_sorted_arrays(nums2, nums1)

    left, right = 0, n1     # take min 0 and max n1 elements from nums1
    left_size = (n1 + n2 + 1) // 2  # +1 for odd total len

    while left <= right:
        mid1 = (left + right) // 2
        mid2 = left_size - mid1

        l1 = -math.inf if mid1 == 0 else nums1[mid1 - 1]
        l2 = -math.inf if mid2 == 0 else nums2[mid2 - 1]

        r1 = math.inf if mid1 == n1 else nums1[mid1]
        r2 = math.inf if mid2 == n2 else nums2[mid2]

        if l1 <= r2 and l2 <= r1:
            if (n1 + n2) % 2 == 1:
                return max(l1, l2)
            return (max(l1, l2) + min(r1, r2)) / 2.0

        if l1 > r2:
            right = mid1 - 1
        else:
            left = mid1 + 1

    return 0.0


# Driver code
if __name__ == "__main__":
    # nums1 = [1, 3]
    nums1 = [-10, -9, -8]
    # nums2 = [2]
    nums2 = [1, 2]
    print(find_median_sorted_arrays(nums1, nums2))  # 2.0
