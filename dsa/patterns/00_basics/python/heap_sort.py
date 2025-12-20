"""
Heap Sort

TODO: https://www.geeksforgeeks.org/heap-sort/?ref=lbp

Idea: Build a max heap from the array, then repeatedly extract the maximum
element and place it at the end of the array.
Time complexity: O(n log n) in all cases
Space complexity: O(1) - inplace sorting
Non-stable sorting
"""

def heap_sort(nums):
    n = len(nums)
    
    # Build max heap
    for i in range(n // 2 - 1, -1, -1):
        heapify(nums, n, i)
    
    # Extract elements from heap one by one
    for i in range(n - 1, 0, -1):
        # Move current root to end
        nums[0], nums[i] = nums[i], nums[0]
        
        # Call heapify on the reduced heap
        heapify(nums, i, 0)
        print(nums)


def heapify(nums, n, i):
    largest = i  # Initialize largest as root
    left = 2 * i + 1  # Left child
    right = 2 * i + 2  # Right child
    
    # If left child exists and is greater than root
    if left < n and nums[left] > nums[largest]:
        largest = left
    
    # If right child exists and is greater than largest so far
    if right < n and nums[right] > nums[largest]:
        largest = right
    
    # If largest is not root
    if largest != i:
        nums[i], nums[largest] = nums[largest], nums[i]
        
        # Recursively heapify the affected sub-tree
        heapify(nums, n, largest)


if __name__ == "__main__":
    numbers = [12, 11, 13, 5, 6, 7]
    print(f"Original: {numbers}")
    heap_sort(numbers)
    print(f"Final sorted: {numbers}")
