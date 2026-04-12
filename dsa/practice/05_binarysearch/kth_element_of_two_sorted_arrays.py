# K-th Element of Two Sorted Arrays
#
# Idea:
# Binary search on the smaller array.
# Partition arrays such that:
# - left part has k elements
# - max(left) <= min(right)
#
# Time Complexity: O(log(min(n, m)))
# Space Complexity: O(1)

import math


def kth_element(nums1: list[int], nums2: list[int], k: int) -> int:
    n1, n2 = len(nums1), len(nums2)

    # Always binary search on the smaller array
    if n1 > n2:
        return kth_element(nums2, nums1, k)

    left = max(0, k - n2)   # if k > n2, we have pick min k-n2 from nums1
    right = min(k, n1)      # if k < n1, we can pick max k

    while left <= right:
        mid1 = (left + right) // 2
        mid2 = k - mid1

        l1 = -math.inf if mid1 == 0 else nums1[mid1 - 1]
        l2 = -math.inf if mid2 == 0 else nums2[mid2 - 1]

        r1 = math.inf if mid1 == n1 else nums1[mid1]
        r2 = math.inf if mid2 == n2 else nums2[mid2]

        if l1 <= r2 and l2 <= r1:
            return max(l1, l2)

        if l1 > r2:
            right = mid1 - 1
        else:
            left = mid1 + 1

    return -1


# Driver code
if __name__ == "__main__":
    nums1 = [2, 3, 6, 7, 9]
    nums2 = [1, 4, 8, 10]
    k = 5
    print(kth_element(nums1, nums2, k))  # 6
