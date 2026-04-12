# Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/
#
# Idea:
# Apply Quickselect algorithm.
# Use partition logic to place a pivot in its correct position.
# Instead of sorting the whole array, keep narrowing the search
# towards index (n - k), which represents the k-th largest element.
#
# Time: Average O(n), Worst O(n^2)

import random


def find_kth_largest(nums: list[int], k: int) -> int:

    def partition(left: int, right: int) -> int:
        pivot = nums[right]
        store_index = left

        for i in range(left, right):
            if nums[i] < pivot:
                nums[i], nums[store_index] = nums[store_index], nums[i]
                store_index += 1

        nums[store_index], nums[right] = nums[right], nums[store_index]
        return store_index

    n = len(nums)
    target_index = n - k
    left, right = 0, n - 1

    while True:
        # Pick a random pivot to avoid worst-case behavior
        pivot_index = random.randint(left, right)
        nums[pivot_index], nums[right] = nums[right], nums[pivot_index]

        pivot_pos = partition(left, right)

        if pivot_pos == target_index:
            return nums[pivot_pos]
        elif pivot_pos < target_index:
            left = pivot_pos + 1
        else:
            right = pivot_pos - 1


# Driver code
if __name__ == "__main__":
    nums = [3, 2, 1, 5, 6, 4]
    k = 2
    print(find_kth_largest(nums, k))  # 5
