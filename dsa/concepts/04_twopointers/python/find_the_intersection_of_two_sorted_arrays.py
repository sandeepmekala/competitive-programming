"""
Find the Intersection of Two Sorted Arrays
Problem: Find the intersection of two sorted arrays
Idea: Use two pointers to traverse both arrays simultaneously
Time: O(n + m) where n and m are lengths of the arrays
Space: O(1) excluding the result array
"""

def find_intersection(nums1, nums2):
    """
    Find the intersection of two sorted arrays.
    
    Args:
        nums1: List[int] - First sorted array
        nums2: List[int] - Second sorted array
    
    Returns:
        List[int] - List containing intersection elements
    """
    n1, n2 = len(nums1), len(nums2)
    i = j = 0
    intersection = []
    
    while i < n1 and j < n2:
        if nums1[i] == nums2[j]:
            intersection.append(nums1[i])
            i += 1
            j += 1
        elif nums1[i] < nums2[j]:
            i += 1
        else:
            j += 1
    
    return intersection


if __name__ == "__main__":
    nums1 = [1, 2, 3, 4, 5]
    nums2 = [1, 2, 3]
    result = find_intersection(nums1, nums2)
    print(result)  # Expected: [1, 2, 3]
