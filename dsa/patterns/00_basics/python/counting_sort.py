"""
Counting Sort

Idea: Count the frequencies of each element, find the cumulative sum of frequencies 
to get the correct positions to put the elements
Stable sort
Time and space complexity O(n+k) where k is the range of input
"""

def counting_sort(numbers):
    n = len(numbers)
    
    # Find the maximum element to determine range
    max_val = max(numbers)
    
    # Initialize frequency array
    num_freq = [0] * (max_val + 1)
    sorted_array = [0] * n
    
    # Find frequencies of each element
    for num in numbers:
        num_freq[num] += 1
    
    # Calculate cumulative sum of frequencies
    for i in range(1, len(num_freq)):
        num_freq[i] = num_freq[i] + num_freq[i - 1]
    
    # Cumulative sum gives from which position the next element should start.
    # To get from which position the current element should start, 
    # we need to shift the indices by one position to right.
    for i in range(len(num_freq) - 1, 0, -1):
        num_freq[i] = num_freq[i - 1]
    num_freq[0] = 0
    
    # Place elements in sorted order
    for num in numbers:
        index = num_freq[num]
        sorted_array[index] = num
        num_freq[num] += 1
    
    return sorted_array


if __name__ == "__main__":
    numbers = [1, 0, 3, 1, 3, 1]
    print(f"Original: {numbers}")
    sorted_numbers = counting_sort(numbers)
    print(f"Sorted: {sorted_numbers}")
