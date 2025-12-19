"""
Find the Union of Two Sorted Arrays
Problem: Find the union of two sorted arrays
Idea: Use two pointers to traverse both arrays and avoid duplicates
Time: O(n + m) where n and m are lengths of the arrays
Space: O(1) excluding the result array
"""

def find_union(nums1, nums2):
    """
    Find the union of two sorted arrays.
    
    Args:
        nums1: List[int] - First sorted array
        nums2: List[int] - Second sorted array
    
    Returns:
        List[int] - List containing union elements without duplicates
    """
    n1, n2 = len(nums1), len(nums2)
    i = j = 0
    union = []
    
    while i < n1 and j < n2:
        if nums1[i] <= nums2[j]:
            if not union or union[-1] != nums1[i]:
                union.append(nums1[i])
            i += 1
        else:
            if not union or union[-1] != nums2[j]:
                union.append(nums2[j])
            j += 1
    
    while i < n1:
        if not union or union[-1] != nums1[i]:
            union.append(nums1[i])
        i += 1
    
    while j < n2:
        if not union or union[-1] != nums2[j]:
            union.append(nums2[j])
        j += 1
    
    return union


if __name__ == "__main__":
    nums1 = [1, 2, 3, 4, 5]
    nums2 = [1, 2, 3]
    result = find_union(nums1, nums2)
    print(result)  # Expected: [1, 2, 3, 4, 5]
