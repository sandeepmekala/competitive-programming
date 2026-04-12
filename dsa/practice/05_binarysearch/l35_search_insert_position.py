# LeetCode 35 - Search Insert Position
#
# Idea:
# Use binary search to find the lower bound (first index >= target).
#
# Time Complexity: O(log n)
# Space Complexity: O(1)

def search_insert(nums: list[int], target: int) -> int:
    left, right = 0, len(nums) - 1
    ans = len(nums)

    while left <= right:
        mid = left + (right - left) // 2

        if nums[mid] >= target:
            ans = mid
            right = mid - 1
        else:
            left = mid + 1

    return ans


# Driver code
if __name__ == "__main__":
    nums = [1, 3, 5, 6]
    target = 5
    print(search_insert(nums, target))  # 2
