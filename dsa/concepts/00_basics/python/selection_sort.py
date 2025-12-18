"""
Selection Sort

Idea: Select min element in each iteration and put it in its correct place
Time complexity is O(n^2)
Non-stable sorting
Space complexity is O(1). Means Inplace sorting.
"""

def selection_sort(nums):
    n = len(nums)
    
    for i in range(n - 1):
        min_idx = i
        
        # Find the minimum element in remaining unsorted array
        for j in range(i + 1, n):
            if nums[j] < nums[min_idx]:
                min_idx = j
        
        nums[min_idx], nums[i] = nums[i], nums[min_idx]
        print(nums)


if __name__ == "__main__":
    numbers = [2, 7, 4, 1, 5, 3]
    print(f"Original: {numbers}")
    selection_sort(numbers)
    print(f"Final sorted: {numbers}")
