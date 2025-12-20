"""
L88 - Merge Sorted Array

Problem: https://leetcode.com/problems/merge-sorted-array/
Idea: Merge from the end to avoid overwriting elements
Time: O(m + n)
Space: O(1)
"""

def merge(nums1, m, nums2, n):
    i = m - 1  # Last element in nums1
    j = n - 1  # Last element in nums2
    k = m + n - 1  # Last position in nums1
    
    while i >= 0 and j >= 0:
        if nums1[i] > nums2[j]:
            nums1[k] = nums1[i]
            i -= 1
        else:
            nums1[k] = nums2[j]
            j -= 1
        k -= 1
    
    # Copy remaining elements from nums2
    while j >= 0:
        nums1[k] = nums2[j]
        j -= 1
        k -= 1


if __name__ == "__main__":
    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [2, 5, 6]
    n = 3
    
    print(f"Before merge: nums1 = {nums1}, nums2 = {nums2}")
    merge(nums1, m, nums2, n)
    print(f"After merge: nums1 = {nums1}")
