"""
LeetCode 4 - Median of Two Sorted Arrays

Idea:
Binary Search on the smaller array to partition both arrays
into left and right halves such that:
- left half has (n + 1) // 2 elements
- max(left) <= min(right)

Time Complexity: O(log(min(n1, n2)))
Space Complexity: O(1)
"""

import math


def find_median_sorted_arrays(nums1, nums2):
    n1, n2 = len(nums1), len(nums2)

    # Ensure binary search on smaller array
    if n1 > n2:
        return find_median_sorted_arrays(nums2, nums1)

    n = n1 + n2
    left = (n + 1) // 2
    low, high = 0, n1

    while low <= high:
        cut1 = (low + high) // 2
        cut2 = left - cut1

        l1 = -math.inf if cut1 == 0 else nums1[cut1 - 1]
        l2 = -math.inf if cut2 == 0 else nums2[cut2 - 1]

        r1 = math.inf if cut1 == n1 else nums1[cut1]
        r2 = math.inf if cut2 == n2 else nums2[cut2]

        if l1 <= r2 and l2 <= r1:
            if n % 2 == 1:
                return max(l1, l2)
            return (max(l1, l2) + min(r1, r2)) / 2.0

        elif l1 > r2:
            high = cut1 - 1
        else:
            low = cut1 + 1

    return 0.0


# Driver code
if __name__ == "__main__":
    nums1 = [1, 3]
    nums2 = [2]
    print(find_median_sorted_arrays(nums1, nums2))
