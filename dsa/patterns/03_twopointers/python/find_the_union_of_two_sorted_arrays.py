# Find the Union of Two Sorted Arrays
#
# Problem: Find the union of two sorted arrays
#
# Idea:
# - Use two pointers to traverse both arrays
# - Append the smaller element
# - Avoid duplicates by checking the last inserted element
#
# Time: O(n + m)
# Space: O(1) excluding the result array


def find_union(nums1, nums2):
    i = j = 0
    union = []

    while i < len(nums1) and j < len(nums2):
        if nums1[i] <= nums2[j]:
            if not union or union[-1] != nums1[i]:
                union.append(nums1[i])
            i += 1
        else:
            if not union or union[-1] != nums2[j]:
                union.append(nums2[j])
            j += 1

    while i < len(nums1):
        if not union or union[-1] != nums1[i]:
            union.append(nums1[i])
        i += 1

    while j < len(nums2):
        if not union or union[-1] != nums2[j]:
            union.append(nums2[j])
        j += 1

    return union


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums1 = [1, 2, 3, 4, 5]
    nums2 = [1, 2, 3]
    print(find_union(nums1, nums2))  # Output: [1, 2, 3, 4, 5]
