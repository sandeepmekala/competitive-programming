"""
L658 - Find K Closest Elements
Problem: https://leetcode.com/problems/find-k-closest-elements/
Companies: Amazon
Idea: Find x/closest index. From there move two ptr's in both direction and check dist.
Time: O(log n + k)
Space: O(k) for the result
"""

def find_closest_elements(arr, k, x):
    """
    Find k closest elements to x in a sorted array.
    
    Args:
        arr: List[int] - Sorted array of integers
        k: int - Number of closest elements to find
        x: int - Target value
    
    Returns:
        List[int] - k closest elements in sorted order
    """
    n = len(arr)
    
    # Find the closest index to x
    if x < arr[0]:
        closest = 0
    elif x > arr[n - 1]:
        closest = n - 1
    else:
        closest = search(arr, x)
    
    result = []
    i, j = closest, closest + 1
    
    while k > 0:
        dist1 = abs(arr[i] - x) if i >= 0 else float('inf')
        dist2 = abs(arr[j] - x) if j < n else float('inf')
        
        if dist1 <= dist2:
            result.insert(0, arr[i])
            i -= 1
        else:
            result.append(arr[j])
            j += 1
        k -= 1
    
    return result


def search(arr, x):
    """
    Binary search to find the closest element to x.
    
    Args:
        arr: List[int] - Sorted array
        x: int - Target value
    
    Returns:
        int - Index of closest element to x
    """
    start, end = 0, len(arr) - 1
    
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == x:
            return mid
        elif arr[mid] < x:
            start = mid + 1
        else:
            end = mid - 1
    
    # Return the index with smaller distance to x
    if end < 0:
        return start
    if start >= len(arr):
        return end
    
    return end if abs(arr[end] - x) <= abs(arr[start] - x) else start


if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5]
    k = 4
    x = 3
    result = find_closest_elements(arr, k, x)
    print(result)  # Expected: [1, 2, 3, 4]
