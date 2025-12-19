"""
Problem: https://leetcode.com/problems/count-of-smaller-numbers-after-self/
Idea:
Use a modified merge sort.
While merging two sorted halves, count how many elements from the right half
move before elements in the left half. That count tells how many smaller
elements appear after each number.
Time: O(n log n)
"""

def count_smaller(nums):
    n = len(nums)
    result = [0] * n
    indices = list(range(n))  # keeps track of original indices

    def merge_sort(left, right):
        if left >= right:
            return

        mid = (left + right) // 2
        merge_sort(left, mid)
        merge_sort(mid + 1, right)
        merge(left, mid, right)

    def merge(left, mid, right):
        temp = []
        i, j = left, mid + 1
        smaller_count = 0

        while i <= mid and j <= right:
            if nums[indices[j]] < nums[indices[i]]:
                temp.append(indices[j])
                smaller_count += 1
                j += 1
            else:
                temp.append(indices[i])
                result[indices[i]] += smaller_count
                i += 1

        while i <= mid:
            temp.append(indices[i])
            result[indices[i]] += smaller_count
            i += 1

        while j <= right:
            temp.append(indices[j])
            j += 1

        indices[left:right + 1] = temp

    merge_sort(0, n - 1)
    return result


# Example usage
if __name__ == "__main__":
    nums = [5, 2, 6, 1]
    print(count_smaller(nums))  # [2, 1, 1, 0]
