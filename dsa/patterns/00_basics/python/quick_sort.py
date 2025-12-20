"""
Quick Sort

Idea: Choose a pivot element and partition the array around it
Time complexity in average case O(nlogn). Worst case is O(n^2)
Non stable sorting
Space complexity in average case is O(logn) and worst case is O(n). So, it is not inplace sorting.
"""

import random


def quick_sort(nums, low=None, high=None):
    if low is None:
        low = 0
    if high is None:
        high = len(nums) - 1
    
    if low >= high:
        return
    
    print(nums)
    pivot_index = partition(nums, low, high)
    quick_sort(nums, low, pivot_index - 1)
    quick_sort(nums, pivot_index + 1, high)


def randomized_partition(nums, low, high):
    # Select random pivot and swap with first element
    pivot_index = random.randint(low, high)
    nums[pivot_index], nums[low] = nums[low], nums[pivot_index]
    return partition(nums, low, high)


def partition(nums, low, high):
    n = len(nums)
    i = low
    j = high
    
    while i < j:
        # Find element greater than pivot from left
        while i < n and nums[i] <= nums[low]:
            i += 1
        
        # Find element smaller than or equal to pivot from right
        while j >= 0 and nums[j] > nums[low]:
            j -= 1
        
        # Swap if pointers haven't crossed
        if i < j:
            nums[i], nums[j] = nums[j], nums[i]
    
    # Place pivot in its correct position
    nums[j], nums[low] = nums[low], nums[j]
    
    return j


if __name__ == "__main__":
    numbers = [7, 2, 1, 6, 8, 5, 3, 4]
    print(f"Original: {numbers}")
    quick_sort(numbers)
    print(f"Final sorted: {numbers}")
