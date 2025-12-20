"""
K-th Element of Two Sorted Arrays

Idea:
Binary search on the smaller array.
Partition arrays such that:
- left part has k elements
- max(left) <= min(right)

Time Complexity: O(log(min(n, m)))
Space Complexity: O(1)
"""

import math


def kth_element(nums1, nums2, k):
    n1, n2 = len(nums1), len(nums2)

    # Always binary search on the smaller array
    if n1 > n2:
        return kth_element(nums2, nums1, k)

    low = max(0, k - n2)
    high = min(k, n1)

    while low <= high:
        cut1 = (low + high) // 2
        cut2 = k - cut1

        l1 = -math.inf if cut1 == 0 else nums1[cut1 - 1]
        l2 = -math.inf if cut2 == 0 else nums2[cut2 - 1]

        r1 = math.inf if cut1 == n1 else nums1[cut1]
        r2 = math.inf if cut2 == n2 else nums2[cut2]

        if l1 <= r2 and l2 <= r1:
            return max(l1, l2)
        elif l1 > r2:
            high = cut1 - 1
        else:
            low = cut1 + 1

    return -1


# Driver code
if __name__ == "__main__":
    nums1 = [2, 3, 6, 7, 9]
    nums2 = [1, 4, 8, 10]
    k = 5
    print(kth_element(nums1, nums2, k))
