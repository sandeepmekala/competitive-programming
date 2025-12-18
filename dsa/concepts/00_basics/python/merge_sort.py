"""
Merge Sort

Idea: Divide array into two arrays and call mergeSort recursively for other 2 half then call merge.
Use temp array to merge two halves and copy from temp to actual after merge.
Time complexity is worst case O(nlogn)
Space complexity is O(n) if we clear the unused memory during runtime. So, it is not inplace sorting.
Stable sorting
"""

def merge_sort(nums, low=None, high=None):
    if low is None:
        low = 0
    if high is None:
        high = len(nums) - 1
    
    if low >= high:
        return
    
    mid = (low + high) // 2
    merge_sort(nums, low, mid)
    merge_sort(nums, mid + 1, high)
    merge(nums, low, mid, high)


def merge(nums, low, mid, high):
    left = low
    right = mid + 1
    temp = []
    
    # Merge elements from both halves in sorted order
    while left <= mid and right <= high:
        if nums[left] <= nums[right]:
            temp.append(nums[left])
            left += 1
        else:
            temp.append(nums[right])
            right += 1
    
    # Add remaining elements from left half
    while left <= mid:
        temp.append(nums[left])
        left += 1
    
    # Add remaining elements from right half
    while right <= high:
        temp.append(nums[right])
        right += 1
    
    # Copy merged elements back to original array
    for i in range(low, high + 1):
        nums[i] = temp[i - low]
    
    print(nums)


if __name__ == "__main__":
    numbers = [2, 4, 1, 6, 8, 5, 3, 7]
    print(f"Original: {numbers}")
    merge_sort(numbers)
    print(f"Final sorted: {numbers}")
