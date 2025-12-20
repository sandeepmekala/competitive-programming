"""
Bubble Sort

Idea: The biggest element is bubbled to last one for each iteration
Time complexity in worst & average case is O(n^2). Best case O(n)
Stable sorting
Inplace sorting.
"""

def bubble_sort(nums):
    n = len(nums)
    
    for i in range(n):
        sorted_flag = True
        
        for j in range(n - 1):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
                sorted_flag = False
        
        if sorted_flag:
            break
        
        print(nums)


if __name__ == "__main__":
    numbers = [2, 7, 4, 1, 5, 3]
    print(f"Original: {numbers}")
    bubble_sort(numbers)
    print(f"Final sorted: {numbers}")
