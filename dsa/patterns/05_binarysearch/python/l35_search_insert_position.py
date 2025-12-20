"""
LeetCode 35 - Search Insert Position

Idea:
Use binary search to find the lower bound (first index >= target).

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def search_insert(nums, target):
    low, high = 0, len(nums) - 1
    res = len(nums)

    while low <= high:
        mid = (low + high) // 2
        if nums[mid] >= target:
            res = mid
            high = mid - 1
        else:
            low = mid + 1

    return res


# Driver code
if __name__ == "__main__":
    nums = [1, 3, 5, 6]
    target = 5
    print(search_insert(nums, target))  # 2
