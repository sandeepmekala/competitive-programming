"""
Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/
Idea: Apply Quickselect algorithm.
Use partition logic to place a pivot in its correct position.
Instead of sorting the whole array, keep narrowing the search
towards index (n - k), which represents the k-th largest element.
Time: Average O(n), Worst O(n^2)
"""

import random

def find_kth_largest(nums, k):
    n = len(nums)
    target = n - k
    left, right = 0, n - 1

    while True:
        # Pick a random pivot to avoid worst-case behavior
        pivot_index = random.randint(left, right)
        nums[pivot_index], nums[right] = nums[right], nums[pivot_index]

        p = partition(nums, left, right)

        if p == target:
            return nums[p]
        elif p < target:
            left = p + 1
        else:
            right = p - 1


def partition(nums, left, right):
    pivot = nums[right]
    idx = left

    for i in range(left, right):
        if nums[i] < pivot:
            nums[i], nums[idx] = nums[idx], nums[i]
            idx += 1

    nums[idx], nums[right] = nums[right], nums[idx]
    return idx


# Example usage
if __name__ == "__main__":
    nums = [3, 2, 1, 5, 6, 4]
    k = 2
    print(find_kth_largest(nums, k))  # 5
