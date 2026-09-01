# Find the Intersection of Two Sorted Arrays
#
# Problem: Find the intersection of two sorted arrays
#
# Idea:
# - Use two pointers to traverse both arrays
# - Move the pointer of the smaller element
#
# Time: O(n + m)
# Space: O(1) excluding the result array


def find_intersection(nums1, nums2):
    i = j = 0
    intersection = []

    while i < len(nums1) and j < len(nums2):
        if nums1[i] == nums2[j]:
            intersection.append(nums1[i])
            i += 1
            j += 1
        elif nums1[i] < nums2[j]:
            i += 1
        else:
            j += 1

    return intersection


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums1 = [1, 2, 3, 4, 5]
    nums2 = [1, 2, 3]
    print(find_intersection(nums1, nums2))  # Output: [1, 2, 3]
