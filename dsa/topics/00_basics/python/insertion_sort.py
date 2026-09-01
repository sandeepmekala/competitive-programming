"""
Insertion Sort

Idea: Treat left array as sorted. Move the current element to its correct position 
in sorted array by shifting elements to right.
Time complexity is worst & average case O(n^2). Best case O(n) if array is already sorted.
Stable sorting
Space complexity is O(1). Means Inplace sorting.
"""

def insertion_sort(nums):
    for i in range(1, len(nums)):
        current = nums[i]
        j = i
        
        # Shift elements to the right until we find the correct position
        while j > 0 and nums[j - 1] > current:
            nums[j] = nums[j - 1]
            j -= 1
        
        # Insert the current element at its correct position
        nums[j] = current
        print(nums)


if __name__ == "__main__":
    numbers = [2, 7, 4, 1, 5, 3]
    print(f"Original: {numbers}")
    insertion_sort(numbers)
    print(f"Final sorted: {numbers}")
