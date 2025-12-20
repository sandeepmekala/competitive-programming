"""
Problem: https://www.geeksforgeeks.org/counting-inversions/?ref=lbp
Idea:
Use merge sort.
While merging two sorted halves, if an element from the right half
is smaller than an element from the left half, then all remaining
elements in the left half form an inversion with this element.
"""

def count_inversions(nums):
    def merge_sort(left, right):
        if left >= right:
            return 0

        mid = (left + right) // 2
        count = merge_sort(left, mid)
        count += merge_sort(mid + 1, right)
        count += merge(left, mid, right)
        return count

    def merge(left, mid, right):
        inversions = 0
        temp = []
        i, j = left, mid + 1

        while i <= mid and j <= right:
            if nums[i] <= nums[j]:
                temp.append(nums[i])
                i += 1
            else:
                temp.append(nums[j])
                inversions += (mid - i + 1)  # all remaining left elements
                j += 1

        temp.extend(nums[i:mid + 1])
        temp.extend(nums[j:right + 1])

        nums[left:right + 1] = temp
        return inversions

    return merge_sort(0, len(nums) - 1)


# Example usage
if __name__ == "__main__":
    arr = [5, 3, 2, 4, 1]
    print(count_inversions(arr))  # 8
