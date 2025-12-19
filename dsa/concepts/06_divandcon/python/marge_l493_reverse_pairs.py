"""
Problem: https://leetcode.com/problems/reverse-pairs/
Idea:
Use merge sort.
While merging two sorted halves, count pairs such that
nums[i] > 2 * nums[j] where i is in the left half and j is in the right half.
Pairs inside left and right halves are counted recursively.
Cross pairs are counted before merging.
"""

def reverse_pairs(nums):
    def merge_sort(left, right):
        if left >= right:
            return 0

        mid = (left + right) // 2
        pairs = merge_sort(left, mid)
        pairs += merge_sort(mid + 1, right)
        pairs += count_and_merge(left, mid, right)
        return pairs

    def count_and_merge(left, mid, right):
        # Count reverse pairs
        count = 0
        j = mid + 1

        for i in range(left, mid + 1):
            while j <= right and nums[i] > 2 * nums[j]:
                j += 1
            count += j - (mid + 1)

        # Merge the two sorted halves
        temp = []
        l, r = left, mid + 1

        while l <= mid and r <= right:
            if nums[l] <= nums[r]:
                temp.append(nums[l])
                l += 1
            else:
                temp.append(nums[r])
                r += 1

        temp.extend(nums[l:mid + 1])
        temp.extend(nums[r:right + 1])

        nums[left:right + 1] = temp
        return count

    return merge_sort(0, len(nums) - 1)


# Example usage
if __name__ == "__main__":
    nums = [1, 3, 2, 3, 1]
    print(reverse_pairs(nums))  # 2
