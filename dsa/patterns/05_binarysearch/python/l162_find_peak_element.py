"""
LeetCode 162 - Find Peak Element

Idea:
A peak element is greater than its neighbors.
If nums[mid] > nums[mid - 1], then a peak exists on the right side.
Otherwise, a peak exists on the left side.

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def find_peak_element(nums):
    n = len(nums)

    if n == 1:
        return 0
    if nums[0] > nums[1]:
        return 0
    if nums[n - 1] > nums[n - 2]:
        return n - 1

    low, high = 1, n - 2

    while low <= high:
        mid = (low + high) // 2

        if nums[mid - 1] < nums[mid] > nums[mid + 1]:
            return mid
        elif nums[mid] > nums[mid - 1]:
            low = mid + 1
        else:
            high = mid - 1

    return -1


# Driver code
if __name__ == "__main__":
    nums = [1, 2, 3, 1]
    print(find_peak_element(nums))  # 2
