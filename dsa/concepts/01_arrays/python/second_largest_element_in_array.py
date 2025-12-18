"""
Second Largest Element In Array

Problem: Find the second largest element in an array
"""

def find_second_largest(nums):
    n = len(nums)
    first = float('-inf')
    second = float('-inf')
    
    for i in range(n):
        if nums[i] > first:
            second = first
            first = nums[i]
        elif nums[i] > second and nums[i] != first:
            second = nums[i]
    
    return second


if __name__ == "__main__":
    arr = [12, 35, 1, 10, 34, 1]
    print(find_second_largest(arr))
