# Problem: https://leetcode.com/problems/reverse-pairs/
#
# Idea:
# Use merge sort.
# While merging two sorted halves, count pairs such that nums[i] > 2 * nums[j]
# Pairs inside left and right halves are counted recursively.
# Cross pairs are counted before merging.

def reverse_pairs(nums: list[int]) -> int:
    def merge_sort(left: int, right: int) -> int:
        if left >= right:
            return 0

        mid = (left + right) // 2
        pairs = merge_sort(left, mid)
        pairs += merge_sort(mid + 1, right)
        pairs += count_and_merge(left, mid, right)

        return pairs

    def count_and_merge(left: int, mid: int, right: int) -> int:
        # Count reverse pairs
        count = 0
        j = mid + 1

        for i in range(left, mid + 1):
            while j <= right and nums[i] > 2 * nums[j]:
                j += 1
            count += j - (mid + 1)

        # Merge the two sorted halves
        merged = []
        i, j = left, mid + 1

        while i <= mid and j <= right:
            if nums[i] <= nums[j]:
                merged.append(nums[i])
                i += 1
            else:
                merged.append(nums[j])
                j += 1

        merged.extend(nums[i:mid + 1])
        merged.extend(nums[j:right + 1])

        nums[left:right + 1] = merged
        return count

    return merge_sort(0, len(nums) - 1)


# Driver code
if __name__ == "__main__":
    nums = [1, 3, 2, 3, 1]
    print(reverse_pairs(nums))  # 2
