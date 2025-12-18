"""
Radix Sort

Idea: Use counting sort technique. Sort the numbers based on integer at each position 
from right to left (least significant digit to most significant digit)
Stable sort
Time and space complexity O(d*(n+k)) where d is number of digits, k is base (10)
"""

def radix_sort(nums):
    if not nums:
        return []
    
    # Find the maximum number to know number of digits
    max_num = max(nums)
    
    # Do counting sort for every digit
    position = 1
    sorted_array = nums[:]  # Create a copy
    
    while max_num // position > 0:
        sorted_array = counting_sort_by_digit(sorted_array, position)
        position *= 10
    
    return sorted_array


def counting_sort_by_digit(nums, position):
    n = len(nums)
    num_freqs = [0] * 10  # Base is 10 (digits 0-9)
    sorted_array = [0] * n
    
    # Count frequency of each digit at given position
    for num in nums:
        digit = (num // position) % 10
        num_freqs[digit] += 1
    
    # Calculate cumulative sum of frequencies
    for i in range(1, len(num_freqs)):
        num_freqs[i] = num_freqs[i] + num_freqs[i - 1]
    
    # Shift indices to get starting positions
    for i in range(len(num_freqs) - 1, 0, -1):
        num_freqs[i] = num_freqs[i - 1]
    num_freqs[0] = 0
    
    # Place elements in sorted order based on current digit
    for num in nums:
        digit = (num // position) % 10
        index = num_freqs[digit]
        sorted_array[index] = num
        num_freqs[digit] += 1
    
    return sorted_array


if __name__ == "__main__":
    numbers = [53, 89, 150, 36, 633, 233]
    print(f"Original: {numbers}")
    sorted_numbers = radix_sort(numbers)
    print(f"Sorted: {sorted_numbers}")
    
    test_array = [170, 45, 75, 90, 2, 802, 24, 66]
    print(f"\nOriginal: {test_array}")
    print(f"Sorted: {radix_sort(test_array)}")
