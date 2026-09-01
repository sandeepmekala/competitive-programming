# LeetCode 162 - Find Peak Element
#
# Idea:
# A peak element is greater than its neighbors.
# If nums[mid] > nums[mid - 1], then a peak exists on the right side.
# Otherwise, a peak exists on the left side.
#
# Time Complexity: O(log n)
# Space Complexity: O(1)

def find_peak_element(nums: list[int]) -> int:
    n = len(nums)

    if n == 1:
        return 0
    if nums[0] > nums[1]:
        return 0
    if nums[-1] > nums[-2]:
        return n - 1

    left, right = 1, n - 2

    while left <= right:
        mid = (left + right) // 2

        if nums[mid - 1] < nums[mid] > nums[mid + 1]:
            return mid
        if nums[mid] > nums[mid - 1]:
            left = mid + 1
        else:
            right = mid - 1

    return -1


# Driver code
if __name__ == "__main__":
    nums = [1, 2, 3, 1]
    print(find_peak_element(nums))  # 2
