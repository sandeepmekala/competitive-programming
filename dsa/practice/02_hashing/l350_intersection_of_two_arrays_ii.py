"""
L350 - Intersection of Two Arrays II

Problem: https://leetcode.com/problems/intersection-of-two-arrays-ii/
Idea: Use Map to store nums and counts
Time: O(m + n)
Space: O(min(m, n))
"""

def intersect(nums1, nums2):
    from collections import Counter
    
    # Count elements in nums1
    count_map = Counter(nums1)
    result = []
    
    # Check each element in nums2
    for num in nums2:
        if count_map[num] > 0:
            result.append(num)
            count_map[num] -= 1
    
    return result


if __name__ == "__main__":
    test_cases = [
        ([1, 2, 2, 1], [2, 2]),
        ([4, 9, 5], [9, 4, 9, 8, 4]),
        ([1, 2], [1, 1]),
        ([1, 2, 2, 1], [2])
    ]
    
    for i, (nums1, nums2) in enumerate(test_cases, 1):
        print(f"Test case {i}: nums1 = {nums1}, nums2 = {nums2}")
        print(f"Intersection: {intersect(nums1, nums2)}")
        print()
