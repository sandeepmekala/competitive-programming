"""
LeetCode 704 - Binary Search

Idea:
Divide the search space in half each time.

Time Complexity: O(log n)
Space Complexity:
- Iterative: O(1)
- Recursive: O(log n) (call stack)
"""

# -----------------------
# Iterative Binary Search
# -----------------------
def binary_search(nums, target):
    low, high = 0, len(nums) - 1

    while low <= high:
        mid = low + (high - low) // 2

        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            low = mid + 1
        else:
            high = mid - 1

    return -1


# -----------------------
# Recursive Binary Search
# -----------------------
def binary_search_recursive(nums, left, right, target):
    if left > right:
        return -1

    mid = (left + right) // 2

    if nums[mid] == target:
        return mid
    elif target < nums[mid]:
        return binary_search_recursive(nums, left, mid - 1, target)
    else:
        return binary_search_recursive(nums, mid + 1, right, target)


# Driver code
if __name__ == "__main__":
    arr = [2, 3, 4, 10, 40]
    target = 10

    print(binary_search(arr, target))                     # 3
    print(binary_search_recursive(arr, 0, len(arr)-1, target))  # 3
