# L88 - Merge Sorted Array
#
# Problem: https://leetcode.com/problems/merge-sorted-array/
# Idea: Merge from the end to avoid overwriting elements
# Time: O(m + n)
# Space: O(1)


def merge(nums1, m, nums2, n):
    i, j = m - 1, n - 1
    pos = m + n - 1

    while i >= 0 and j >= 0:
        if nums1[i] > nums2[j]:
            nums1[pos] = nums1[i]
            i -= 1
        else:
            nums1[pos] = nums2[j]
            j -= 1
        pos -= 1

    # Copy remaining elements from nums2 (if any)
    while j >= 0:
        nums1[pos] = nums2[j]
        j -= 1
        pos -= 1


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums1 = [1, 2, 3, 0, 0, 0]
    nums2 = [2, 5, 6]
    merge(nums1, 3, nums2, 3)
    print(nums1)
